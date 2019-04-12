/**
 * 
 */
package com.dpaula.token.security.config;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import com.dpaula.microservices.core.property.JwtConfiguration;

import lombok.RequiredArgsConstructor;

/**
 * @author Fernando de Lima
 *
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	
    protected final JwtConfiguration jwtConfiguration;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((req, resp, e) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers(jwtConfiguration.getLoginUrl(), 
                		"/**/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET, 
                		"/**/swagger-resources/**", 
                		"/**/webjars/springfox-swagger-ui/**", 
                		"/**/v2/api-docs/**").permitAll()
                .antMatchers("/course/v1/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/usuario/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated();
    }

}
