package com.cg.adminclassified.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.adminclassified.exceptions.IdNotFoundException;
import com.cg.adminclassified.exceptions.InvalidCategoryException;
import com.cg.adminclassified.models.Category;
import com.cg.adminclassified.services.AdminServices;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	@Autowired AdminServices services;
	private static final List<String> ALLOWED_CATEGORIES = Arrays.asList("house", "car", "electronic", "furniture");
	@PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws InvalidCategoryException{
		
		if (!ALLOWED_CATEGORIES.contains(category.getCategoryName())) {
	            throw new  InvalidCategoryException("Invalid Catgeory");
	        }
		return new ResponseEntity<Category>(services.addCatgeory(category),HttpStatus.CREATED);
	}
	@GetMapping(value ="/category/{categoryId}")
	public ResponseEntity<Category> getTheatre(@PathVariable int categoryId) throws IdNotFoundException{
		return new ResponseEntity<Category>(services.getCatgeory(categoryId),HttpStatus.OK);
	}
	
}
