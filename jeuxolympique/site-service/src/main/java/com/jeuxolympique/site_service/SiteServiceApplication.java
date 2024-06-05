package com.jeuxolympique.site_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
public class SiteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteServiceApplication.class, args);
	}

}
