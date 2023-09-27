package com.cg.adminclassified.Dto;


import java.util.List;

import lombok.Data;

@Data
public class AdvertiseDto  {
	
	private Integer adId;
	private Integer categoryId;
	private String addFor;
	
	private String message;
}
