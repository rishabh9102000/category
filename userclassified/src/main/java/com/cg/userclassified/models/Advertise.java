package com.cg.userclassified.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Advertise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer adId;
	private Integer categoryId;
	private String addFor;
	@NotBlank(message="cannot be empty")
	private String message;
}
