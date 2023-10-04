package com.api.registration.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int regId;
	private  String name;
	private int hotelId;
	private int reqSeats;
}
