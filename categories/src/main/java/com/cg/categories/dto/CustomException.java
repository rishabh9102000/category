package com.cg.categories.dto;

import lombok.Data;

@Data
public class CustomException {
private String userMessage;
private String developerMessage;
private String statusCode;
}
