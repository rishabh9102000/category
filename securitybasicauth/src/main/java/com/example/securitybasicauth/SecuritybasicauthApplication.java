package com.example.securitybasicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecuritybasicauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritybasicauthApplication.class, args);
	}

}
