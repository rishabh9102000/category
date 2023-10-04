package com.api.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.hotel.Dto.HotelRequest;
import com.api.hotel.exceptions.DuplicateEntryException;
import com.api.hotel.exceptions.IdNotFoundException;
import com.api.hotel.models.Hotel;
import com.api.hotel.service.HotelService;

import jakarta.validation.Valid;

@RestController
public class HotelController {
	@Autowired HotelService service;
	
	@PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
	public Hotel createHotel(@Valid @RequestBody HotelRequest request) throws DuplicateEntryException {
		return service.createHotel(request);
	}
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<Hotel> getAllHotels(){
//		System.out.println("hello");
		return service.getAllHotels();	}
	
	@PutMapping(value = "/{hotelId}/{rooms}")
	@ResponseStatus(HttpStatus.OK)
	public Hotel updateHotel(@PathVariable int hotelId, @PathVariable int rooms) throws  IdNotFoundException {
		System.out.println("hello");
		return service.updateHotel(hotelId, rooms);
	}
	
	@GetMapping("/hello/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Hotel getAvailibility(@PathVariable int id) throws IdNotFoundException{
		return service.getAvailibility(id);	}
	
	
}
