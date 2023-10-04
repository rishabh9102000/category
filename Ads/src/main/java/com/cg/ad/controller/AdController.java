package com.cg.ad.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ad.DTO.AdRequest;
import com.cg.ad.exception.InvalidIdException;
import com.cg.ad.pojo.Ad;
import com.cg.ad.service.AdService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class AdController {

@Autowired AdService service;
	
	@PostMapping(value= "/")
	public ResponseEntity<Ad> add(@Valid @RequestBody AdRequest ad) throws InvalidIdException{
		return new ResponseEntity<Ad>(service.add(ad),HttpStatus.CREATED);
	}
	
	@GetMapping(value= "/ads/{cid}")
	public ResponseEntity<List<Ad>> get(@Valid @PathVariable int cid) throws InvalidIdException{
		return new ResponseEntity<List<Ad>>(service.getAds(cid),HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/ads/{aid}")
	public ResponseEntity<String> delete(@Valid @PathVariable int aid) throws InvalidIdException{
		return new ResponseEntity<String>(service.delete(aid),HttpStatus.OK);
	}
	@PutMapping(value= "/ads/{aid}")
	public ResponseEntity<Ad> update(@Valid @PathVariable int aid,@PathVariable String message) throws InvalidIdException{
		return new ResponseEntity<Ad>(service.update(aid, message),HttpStatus.OK);
	}
}
