/**
 * 
 */
package com.dpaula.microservices.core.docs;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Fernando de Lima
 *
 */
public class BaseSwaggerConfig {
    private final String basePackage;

    public BaseSwaggerConfig(String basePackage) {
        this.basePackage = basePackage;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("API Microservices")
                .description("API feita usando microserviços")
                .version("1.0")
                .contact(new Contact("Fernando de Lima", "http://fernandodelima.com.br", "fernando.dpaula@gmail.com"))
                .license("Sem licença")
                .licenseUrl("http://fernandodelima.com.br")
                .build();
    }
}