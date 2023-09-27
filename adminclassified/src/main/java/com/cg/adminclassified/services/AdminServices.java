package com.cg.adminclassified.services;

import java.util.List;

import com.cg.adminclassified.Dto.AdvertiseDto;
import com.cg.adminclassified.exceptions.IdNotFoundException;
import com.cg.adminclassified.exceptions.InvalidCategoryException;
import com.cg.adminclassified.models.Category;

public interface AdminServices {

	public Category addCatgeory(Category category) throws InvalidCategoryException;
	public Category getCatgeory(int categoryId) throws IdNotFoundException;
	
}
