package com.api.hotel.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.hotel.Dto.HotelRequest;
import com.api.hotel.exceptions.DuplicateEntryException;
import com.api.hotel.exceptions.IdNotFoundException;
import com.api.hotel.models.Hotel;
import com.api.hotel.rpeo.HotelRepo;

@Component
public class HotelServiceImpl implements HotelService {
	@Autowired HotelRepo repo;
	@Override
	public Hotel createHotel(HotelRequest request) throws DuplicateEntryException {
		if(repo.existsByHotelName(request.getHotelName())) {throw new DuplicateEntryException ("Duplicate Entry");}
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(request, hotel);
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return repo.findAll();
	}

	@Override
	public Hotel updateHotel(int hotelId, int rooms) throws  IdNotFoundException {
		System.out.println("start");
		Hotel hotel = repo.findById(hotelId).orElseThrow(()-> new IdNotFoundException("id not gound : " + hotelId));
//		HotelRequest
		hotel.setNumberOfRooms(rooms);
		return repo.save(hotel);
	}

	@Override
	public Hotel getAvailibility(int hotelId) throws IdNotFoundException {
		return repo.findById(hotelId).orElseThrow(()-> new IdNotFoundException("id not gound : " + hotelId));
		
	}

}
