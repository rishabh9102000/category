package com.cg.userclassified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.userclassified.exceptions.IdNotFoundException;
import com.cg.userclassified.models.Advertise;
import com.cg.userclassified.services.UserServices;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired UserServices services;
	@PostMapping(value ="/advertise")
	public ResponseEntity<Advertise> createBooking(@Valid @RequestBody Advertise advertise) throws IdNotFoundException{
		return new ResponseEntity<Advertise>(services.addAdvertise(advertise),HttpStatus.CREATED);
	}
	@GetMapping(value ="/advertise")
	public ResponseEntity<List<Advertise>> getAllAdvertise()  {
		return new ResponseEntity<List<Advertise>>(services.getAllAdvertise(),HttpStatus.OK);
	}
	@DeleteMapping(value ="/advertise/{adId}")
	public ResponseEntity<String> removeAdvertise(@PathVariable int adId) throws IdNotFoundException{
		return new ResponseEntity<String>(services.removeAdvertise(adId),HttpStatus.OK);
	}
	@PutMapping(value="/advertise/{adId}/{messgae}")
	public ResponseEntity<Advertise> updateAdvertise(@PathVariable int adId,@PathVariable String messgae) throws IdNotFoundException{
		return new ResponseEntity<Advertise>(services.updateAdvertise(adId, messgae),HttpStatus.ACCEPTED);
	}
	@GetMapping(value="/advertise/{categoryId}")
	public ResponseEntity<List<Advertise>> getAllAdvertiseByCategory(@PathVariable int categoryId) throws IdNotFoundException  {
		return new ResponseEntity<List<Advertise>>(services.getAdvertiseByCategory(categoryId),HttpStatus.OK);
	}
}
