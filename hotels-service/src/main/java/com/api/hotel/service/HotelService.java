package com.api.hotel.service;

import java.util.List;

import com.api.hotel.Dto.HotelRequest;
import com.api.hotel.exceptions.DuplicateEntryException;
import com.api.hotel.exceptions.IdNotFoundException;
import com.api.hotel.models.Hotel;

public interface HotelService {
	public Hotel createHotel(HotelRequest request) throws DuplicateEntryException ;
	public List<Hotel> getAllHotels();
	public Hotel updateHotel(int hotelId,int rooms) throws  IdNotFoundException;
	public Hotel getAvailibility(int hotelId) throws IdNotFoundException;
	

}
