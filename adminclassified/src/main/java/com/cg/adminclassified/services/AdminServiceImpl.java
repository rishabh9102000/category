package com.cg.adminclassified.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.adminclassified.Dto.AdvertiseDto;
import com.cg.adminclassified.Dto.AdvertiseListDto;
import com.cg.adminclassified.exceptions.IdNotFoundException;
import com.cg.adminclassified.exceptions.InvalidCategoryException;
import com.cg.adminclassified.models.Category;
import com.cg.adminclassified.repository.CategoryRepo;


@Component
public class AdminServiceImpl implements AdminServices {
	
	@Autowired CategoryRepo categoryRepo;
	@Override
	public Category addCatgeory(Category category) throws InvalidCategoryException {
		
		return categoryRepo.save(category);
	}
	@Override
	public Category getCatgeory(int categoryId) throws IdNotFoundException {
		return categoryRepo.findById(categoryId).orElseThrow(()-> new IdNotFoundException(" CategoryId Not Found : " + categoryId));
	}


}
