package com.cg.practice.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cityId;
	private String  cityName;
	private List<Integer> movieId;
}
