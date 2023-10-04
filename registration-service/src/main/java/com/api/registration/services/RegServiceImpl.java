package com.api.registration.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.registration.dto.HotelDto;
import com.api.registration.dto.RegistrationRequest;
import com.api.registration.exceptions.DuplicateEntryException;
import com.api.registration.exceptions.IdNotFoundException;
import com.api.registration.exceptions.UnavailableException;
import com.api.registration.models.Registration;
import com.api.registration.repo.RegistrationRepo;

@Component
public class RegServiceImpl implements RegService {
	@Autowired RestTemplate restTemplate;
	@Autowired RegistrationRepo repo;
	@Override
	public Registration createReg(RegistrationRequest request) throws UnavailableException {
		int seats = getAvailibility(request.getHotelId()).getNumberOfRooms();
		if(seats<request.getReqSeats()) { throw new UnavailableException("romms unavialable");}
		Registration reg = new Registration();
		BeanUtils.copyProperties(request, reg);
		int newSeats = seats- request.getReqSeats();
		restTemplate.put("http://localhost:1001/v1/hotel/"+request.getHotelId()+"/" + newSeats , HotelDto.class);
		return repo.save(reg);
	}

	@Override
	public Registration getReg(int regId) throws IdNotFoundException {
		
		return repo.findById(regId).orElseThrow(()-> new IdNotFoundException("Id not found : " + regId));
	}
	public HotelDto getAvailibility(int id) {
		ResponseEntity<HotelDto> response= restTemplate.getForEntity("http://localhost:1001/v1/hotel/"+id, HotelDto.class);
		return response.getBody();
	}

}
