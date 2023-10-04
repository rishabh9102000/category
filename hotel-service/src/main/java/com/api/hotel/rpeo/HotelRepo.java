package com.api.hotel.rpeo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.hotel.models.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
	boolean existsByHotelName(String hotelName);
}
