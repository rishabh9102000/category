package com.cg.ad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ad.pojo.Ad;

public interface AdDao extends JpaRepository<Ad, Integer>{
	
}
