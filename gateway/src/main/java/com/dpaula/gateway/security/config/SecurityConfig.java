/**
 * 
 */
package com.dpaula.gateway.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dpaula.gateway.security.filter.GatewayJwtTokenAuthorizationFilter;
import com.dpaula.microservices.core.property.JwtConfiguration;
import com.dpaula.token.security.config.SecurityTokenConfig;
import com.dpaula.token.security.token.converter.TokenConverter;

/**
 * @author Fernando de Lima
 *
 */
@EnableWebSecurity
public class SecurityConfig extends SecurityTokenConfig {
	
    private final TokenConverter tokenConverter;

    public SecurityConfig(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new GatewayJwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }
}