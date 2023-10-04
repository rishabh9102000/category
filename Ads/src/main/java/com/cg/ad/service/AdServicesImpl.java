package com.cg.ad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.ad.DTO.AdRequest;
import com.cg.ad.DTO.CategoryDTO;
import com.cg.ad.dao.AdDao;
import com.cg.ad.exception.InvalidIdException;
import com.cg.ad.pojo.Ad;

@Component
public class AdServicesImpl implements AdService{
	@Autowired AdDao repo;
	
	@Autowired RestTemplate restTemplate;
	
	
	@Override
	public Ad add(AdRequest ad) throws InvalidIdException {
		getDetails(ad.getCategoryId());
		Ad ads=new Ad();
		BeanUtils.copyProperties(ad, ads);
		return repo.save(ads);
	}
	
	public CategoryDTO getDetails(int categoryId)throws InvalidIdException {
		try {
			return restTemplate.getForEntity("http://localhost:1111/v1/category/"+ categoryId, CategoryDTO.class).getBody();}
			catch(HttpClientErrorException e) {
				throw new  InvalidIdException( categoryId+ "Id not Found in category");
			}
	}


	@Override
	public Ad update(int aid, String newType)throws InvalidIdException {
		Ad ad =repo.findById(aid).orElseThrow(()->new InvalidIdException(aid+ " not present"));
		ad.setAdType(newType);
		return repo.save(ad);
	}

	@Override
	public String delete(int aid)throws InvalidIdException {
		Ad ad =repo.findById(aid).orElseThrow(()->new InvalidIdException(aid +" id not present"));
		repo.delete(ad);
		return "SUCCESSFULLY DELETED";
	}

	@Override
		public List<Ad> getAllAdvertise(){
			return repo.findAll();
		}
	@Override
	public List<Ad> getAds(int categoryId) {
		List<Ad> ad = getAllAdvertise();
		List<Ad> alladds = new ArrayList<>();
		for(Ad i : ad) {
			if(i.getCategoryId()==categoryId) {
				alladds.add(i);

			}
	}
			return alladds;

		}



}
