/**
 * 
 */
package com.dpaula.auth.docs;

import org.springframework.context.annotation.Configuration;

import com.dpaula.microservices.core.docs.BaseSwaggerConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Fernando de Lima
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
	
    public SwaggerConfig() {
        super("com.dpaula.auth.controller");
    }
}