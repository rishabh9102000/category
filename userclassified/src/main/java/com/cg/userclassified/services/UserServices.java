package com.cg.userclassified.services;

import java.util.List;

import com.cg.userclassified.exceptions.IdNotFoundException;
import com.cg.userclassified.models.Advertise;

public interface UserServices {
	public Advertise addAdvertise(Advertise advertise) throws IdNotFoundException;
	public String removeAdvertise(int id) throws IdNotFoundException;
	public Advertise updateAdvertise(int id,String newMessage) throws IdNotFoundException;
	public List<Advertise> getAllAdvertise();
	public List<Advertise> getAdvertiseByCategory(int categoryId) throws IdNotFoundException;
}
