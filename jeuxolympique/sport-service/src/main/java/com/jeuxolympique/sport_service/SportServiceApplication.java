package com.jeuxolympique.sport_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportServiceApplication.class, args);
	}

}
