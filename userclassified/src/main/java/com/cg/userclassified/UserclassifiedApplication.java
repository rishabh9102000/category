package com.cg.userclassified;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class UserclassifiedApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserclassifiedApplication.class, args);
	}
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
