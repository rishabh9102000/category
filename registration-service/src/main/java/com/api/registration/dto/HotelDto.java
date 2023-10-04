package com.api.registration.dto;

import lombok.Data;

@Data
public class HotelDto {
	private int hotelId;
	private String hotelName;
	private double price;
	private int numberOfRooms;
}
