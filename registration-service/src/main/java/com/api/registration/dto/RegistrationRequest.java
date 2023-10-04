package com.api.registration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegistrationRequest {
	@NotBlank(message="name should not be blank")
	private  String name;
	@NotNull
	private int hotelId;
	private int reqSeats;
}
