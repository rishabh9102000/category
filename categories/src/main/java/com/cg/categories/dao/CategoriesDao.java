package com.cg.categories.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.categories.pojo.Category;

public interface CategoriesDao extends JpaRepository<Category, Integer>{
boolean existsByCategoryType(String categoryType);
}
