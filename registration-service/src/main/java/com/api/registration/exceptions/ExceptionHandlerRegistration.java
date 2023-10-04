package com.api.registration.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.registration.dto.CustomException;





@ControllerAdvice
public class ExceptionHandlerRegistration {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<CustomException>handleInvalidId(IdNotFoundException e){
		CustomException custom=new CustomException();
		custom.setStatusCode(HttpStatus.NOT_FOUND.name());
		custom.setUserMessage(e.getMessage());
		custom.setDeveloperMessage(e.getLocalizedMessage());
		return new ResponseEntity<>(custom, HttpStatus.NOT_FOUND);
	}
		
		
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<CustomException>handleDuplicateId(DuplicateEntryException e){
		CustomException custom=new CustomException();
		custom.setStatusCode(HttpStatus.CONFLICT.name());
		custom.setUserMessage(e.getMessage());
		custom.setDeveloperMessage(e.getLocalizedMessage());
		return new ResponseEntity<>(custom, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(UnavailableException.class)
	public ResponseEntity<CustomException>handleunavilable(UnavailableException e){
		CustomException custom=new CustomException();
		custom.setStatusCode(HttpStatus.CONFLICT.name());
		custom.setUserMessage(e.getMessage());
		custom.setDeveloperMessage(e.getLocalizedMessage());
		return new ResponseEntity<>(custom, HttpStatus.CONFLICT);
	}
		@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	    	 Map<String, String> resp = new HashMap<> () ;
	    	 ex.getBindingResult().getAllErrors().forEach((error) ->{
	    		 System.out.println(error.toString());
		    	 String fieldName = ((FieldError) error).getField();
		    	 String message = error.getDefaultMessage () ;
		    	 resp.put (fieldName, message);
	    	 });
	    	 return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
		}
}
