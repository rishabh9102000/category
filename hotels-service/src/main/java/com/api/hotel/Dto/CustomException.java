package com.api.hotel.Dto;

import lombok.Data;

@Data
public class CustomException {
private String userMessage;
private String developerMessage;
private String statusCode;
}
