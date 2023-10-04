package com.cg.categories.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.categories.dto.CategoriesRequest;
import com.cg.categories.exception.DuplicateIdException;
import com.cg.categories.exception.InvalidCategoryException;
import com.cg.categories.exception.InvalidIdException;
import com.cg.categories.pojo.Category;
import com.cg.categories.service.CategoriesService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class CategoriesController {
	@Autowired CategoriesService services;
	private static final List<String> ALLOWED_CATEGORIES = Arrays.asList("house", "car", "electronic", "furniture");
	@PostMapping(value = "/category")
	public ResponseEntity<Category> add(@Valid @RequestBody CategoriesRequest category) throws DuplicateIdException, InvalidCategoryException{
		if (!ALLOWED_CATEGORIES.contains(category.getCategoryType())) {
	            throw new  InvalidCategoryException(category.getCategoryType()+" is invalid Catgeory");
	        }
		return new ResponseEntity<Category>(services.add(category),HttpStatus.CREATED);

	}
	
	@GetMapping(value = "/category/{id}")
	public ResponseEntity<Category> add(@Valid @PathVariable int id) throws InvalidIdException{
		return new ResponseEntity<Category>(services.getCategory(id),HttpStatus.OK);

	}
}
