package com.cg.categories.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.categories.dao.CategoriesDao;
import com.cg.categories.dto.CategoriesRequest;
import com.cg.categories.exception.DuplicateIdException;
import com.cg.categories.exception.InvalidCategoryException;
import com.cg.categories.exception.InvalidIdException;
import com.cg.categories.pojo.Category;

@Component
public class CategoriesServiceImpl implements CategoriesService{

	@Autowired CategoriesDao repo;
	@Override
	public Category getCategory(int categoryId) throws InvalidIdException {
    return repo.findById(categoryId).orElseThrow(()-> new InvalidIdException(categoryId +"id does not exists"));
	}

	@Override
	public Category add(CategoriesRequest categoryRequest) throws DuplicateIdException,InvalidCategoryException {
	if(repo.existsByCategoryType(categoryRequest.getCategoryType()))throw new DuplicateIdException("Category type already exists: " + categoryRequest.getCategoryType());
	Category category=new Category();
	BeanUtils.copyProperties(categoryRequest, category);
	return repo.save(category);
	}



}
