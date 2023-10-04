package com.cg.categories.service;

import com.cg.categories.dto.CategoriesRequest;
import com.cg.categories.exception.DuplicateIdException;
import com.cg.categories.exception.InvalidCategoryException;
import com.cg.categories.exception.InvalidIdException;
import com.cg.categories.pojo.Category;

public interface CategoriesService {
public Category getCategory(int categoryId)throws InvalidIdException;
public Category add(CategoriesRequest categoryRequest)throws DuplicateIdException,InvalidCategoryException;
}
