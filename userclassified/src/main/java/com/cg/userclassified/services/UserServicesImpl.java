package com.cg.userclassified.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import com.cg.userclassified.Dto.CatgeoryDto;
import com.cg.userclassified.exceptions.IdNotFoundException;
import com.cg.userclassified.models.Advertise;
import com.cg.userclassified.repository.AdvertiseRepo;

@Component
public class UserServicesImpl implements UserServices {
	@Autowired RestTemplate restTemplate;
	@Autowired AdvertiseRepo repo;
	
	@Override
	public Advertise addAdvertise(Advertise advertise) throws IdNotFoundException {
		int id = advertise.getCategoryId();
		getCategory(id);
		return repo.save(advertise);
	}
	
	
	
	public CatgeoryDto getCategory(int categoryId) throws IdNotFoundException {
		try {
			return restTemplate.getForEntity("http://localhost:1002/admin/category/"+ categoryId, CatgeoryDto.class).getBody();}
			catch(HttpClientErrorException e) {
				throw new  IdNotFoundException("Id not Found");
			}
	}



	@Override
	public String removeAdvertise(int id) throws IdNotFoundException {
		Advertise ad =repo.findById(id).orElseThrow(()-> new IdNotFoundException("Invalid ad Id"));
		repo.delete(ad);
		return "Deleted Successfully";
	}



	@Override
	public Advertise updateAdvertise(int id, String newMessage) throws IdNotFoundException {
		Advertise ad =repo.findById(id).orElseThrow(()-> new IdNotFoundException("Invalid ad Id"));
		ad.setMessage(newMessage);
		return repo.save(ad);
	}
	@Override
	public List<Advertise> getAllAdvertise(){
		List<Advertise> ad =repo.findAll();
		return ad;
	}



	@Override
	public List<Advertise> getAdvertiseByCategory(int categoryId) throws IdNotFoundException {
		List<Advertise> ad = getAllAdvertise();
		List<Advertise> alladds = new ArrayList<>();
		for(Advertise i : ad) {
			if(i.getCategoryId()==categoryId) {
				alladds.add(i);
			}
		}
		return alladds;
	}

}
