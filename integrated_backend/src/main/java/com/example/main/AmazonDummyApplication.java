package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.main")
@EnableJpaRepositories(basePackages = "com.example.main")
@ComponentScan(basePackages = "com.example.main")
public class AmazonDummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonDummyApplication.class, args);
	}

}
