package com.dpaula.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dpaula.microservices.core.property.JwtConfiguration;

@SpringBootApplication
@EntityScan({"com.dpaula.microservices.core.model"})
@EnableJpaRepositories({"com.dpaula.microservices.core.repository"})
@EnableEurekaClient
@EnableConfigurationProperties(value=JwtConfiguration.class)
@ComponentScan("com.dpaula")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
