package com.example.demoactiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.jms.core.JmsTemplate;




@SpringBootApplication
public class DemoactiveMqApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoactiveMqApplication.class, args);
		JmsTemplate jms = run.getBean(JmsTemplate.class);
	}

}
