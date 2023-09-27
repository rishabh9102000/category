package com.cg.adminclassified.models;

import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class CustomException {
	//private String developerMessage;
	private String userMessage;
	private String  developerMessage;
	private int statusCode ;

}
