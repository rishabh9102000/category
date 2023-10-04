package com.cg.ad.pojo;

import com.cg.ad.DTO.CategoryDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int aid;
private int categoryId;
private String AdType;
private String message;

}
