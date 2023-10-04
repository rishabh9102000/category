package com.api.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.api.registration.dto.RegistrationRequest;
import com.api.registration.exceptions.IdNotFoundException;
import com.api.registration.exceptions.UnavailableException;
import com.api.registration.models.Registration;
import com.api.registration.services.RegService;

import jakarta.validation.Valid;

@RestController
public class RegController {
	@Autowired RegService services;
	
	@PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
	public Registration createHotel(@Valid @RequestBody RegistrationRequest request) throws UnavailableException {
		return services.createReg(request);
	}
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Registration getAvailibility(@PathVariable int id) throws IdNotFoundException{
		return services.getReg(id);}
	
}
