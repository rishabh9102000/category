package com.cg.categories;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.categories.dao.CategoriesDao;
import com.cg.categories.dto.CategoriesRequest;
import com.cg.categories.exception.DuplicateIdException;
import com.cg.categories.exception.InvalidCategoryException;
import com.cg.categories.exception.InvalidIdException;
import com.cg.categories.pojo.Category;
import com.cg.categories.service.CategoriesService;
import com.cg.categories.service.CategoriesServiceImpl;


@ExtendWith(MockitoExtension.class)
class CategoriesApplicationTests {
	@Mock CategoriesDao repo;
	@InjectMocks CategoriesService services = new CategoriesServiceImpl();
	@Test
	void contextLoads() {
	}
	@Test
	void addTestSuccessfull() throws DuplicateIdException, InvalidCategoryException {
		CategoriesRequest cr = new CategoriesRequest("house");
		Category c = new Category(1,"house");
		when(repo.save(any())).thenReturn(c);
		assertEquals(c,services.add(cr));
		verify(repo,times(1)).save(any());
		
	}
	@Test
	public void createFailsDublicateEntry() {
		CategoriesRequest cr = new CategoriesRequest("ABC");
		when(repo.existsByCategoryType("ABC")).thenReturn(true);
		assertThrows(DuplicateIdException.class,()->services.add(cr));
		
	}
	
	@Test
	public void testGetByIdFailureInvalidIdExcpetion() {
		Category c= new Category(1,"car");
		when(repo.findById(2)).thenReturn(Optional.empty());
		assertThrows(InvalidIdException.class,()->services.getCategory(2));
		
	}

}
