package com.cg.ad.service;

import java.util.List;

import com.cg.ad.DTO.AdRequest;
import com.cg.ad.exception.InvalidIdException;
import com.cg.ad.pojo.Ad;



public interface AdService {
	public Ad add(AdRequest ad)throws InvalidIdException;
	public Ad update(int aid,String newType)throws InvalidIdException;
	public String delete(int aid)throws InvalidIdException;
	public List<Ad> getAds(int categoryId);
	public List<Ad> getAllAdvertise();
}
