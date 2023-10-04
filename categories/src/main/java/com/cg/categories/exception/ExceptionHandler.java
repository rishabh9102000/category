package com.cg.categories.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import com.cg.categories.dto.CustomException;


@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidIdException.class)
public ResponseEntity<CustomException>handleInvalidId(InvalidIdException e){
	CustomException custom=new CustomException();
	custom.setStatusCode(HttpStatus.NOT_FOUND.name());
	custom.setUserMessage(e.getMessage());
	custom.setDeveloperMessage(e.getLocalizedMessage());
	return new ResponseEntity<>(custom, HttpStatus.NOT_FOUND);
}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidCategoryException.class)
public ResponseEntity<CustomException>handleInvalidCategoryId(InvalidCategoryException e){
	CustomException custom=new CustomException();
	custom.setStatusCode(HttpStatus.NOT_FOUND.name());
	custom.setUserMessage(e.getMessage());
	custom.setDeveloperMessage(e.getLocalizedMessage());
	return new ResponseEntity<>(custom, HttpStatus.NOT_FOUND);
}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(DuplicateIdException.class)
public ResponseEntity<CustomException>handleDuplicateId(DuplicateIdException e){
	CustomException custom=new CustomException();
	custom.setStatusCode(HttpStatus.CONFLICT.name());
	custom.setUserMessage(e.getMessage());
	custom.setDeveloperMessage(e.getLocalizedMessage());
	return new ResponseEntity<>(custom, HttpStatus.CONFLICT);
}
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
    	 Map<String, String> resp = new HashMap<> () ;
    	 ex.getBindingResult().getAllErrors().forEach((error) ->{
    		 System.out.println(error.toString());
	    	 String fieldName = ((FieldError) error).getField();
	    	 String message = error.getDefaultMessage () ;
	    	 resp.put (fieldName, message);
    	 });
    	 return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);}
	
}
