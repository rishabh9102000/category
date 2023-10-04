package com.api.hotel.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelRequest {
	@NotBlank(message="Cannot be empty")
	private String hotelName;
	@NotNull(message = "Price Cannot be empty")
	private double price;
	private int numberOfRooms;
}
