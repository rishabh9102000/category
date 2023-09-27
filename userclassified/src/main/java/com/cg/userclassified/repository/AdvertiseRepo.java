package com.cg.userclassified.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.userclassified.models.Advertise;

@Repository
public interface AdvertiseRepo extends JpaRepository<Advertise,Integer> {
	
}
