package com.cg.adminclassified;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.adminclassified.exceptions.IdNotFoundException;
import com.cg.adminclassified.exceptions.InvalidCategoryException;
import com.cg.adminclassified.models.Category;
import com.cg.adminclassified.repository.CategoryRepo;
import com.cg.adminclassified.services.AdminServiceImpl;
import com.cg.adminclassified.services.AdminServices;

@ExtendWith(MockitoExtension.class)
class AdminclassifiedApplicationTests {
	@Mock CategoryRepo repo;
	@InjectMocks AdminServices services = new AdminServiceImpl();
	
	@Test
	void addcategory() throws  InvalidCategoryException {
		Category c =new Category(1,"house");
		when(repo.save(c)).thenReturn(c);
		 assertEquals(c,services.addCatgeory(c));
	}

}
