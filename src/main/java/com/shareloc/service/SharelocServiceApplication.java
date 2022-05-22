package com.shareloc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.shareloc.service")
@EntityScan(basePackages = "com.shareloc.service")
@SpringBootApplication
public class SharelocServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharelocServiceApplication.class, args);
	}

}
