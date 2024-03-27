package com.evnt.ol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan
//@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
//@ComponentScan("com.evnt")
//@EntityScan("com.evnt.entity")
//@EnableJpaRepositories("com.evnt.repo")
public class ServerTestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServerTestApplication.class, args);
	}

}
