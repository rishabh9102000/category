package com.cg.adminclassified.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.adminclassified.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
