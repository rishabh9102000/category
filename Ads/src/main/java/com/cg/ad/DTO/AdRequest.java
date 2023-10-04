package com.cg.ad.DTO;

import com.cg.ad.DTO.CategoryDTO;
import com.cg.ad.pojo.Ad;

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


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdRequest {
private int categoryId;
@NotBlank(message="type never be blank")
private String AdType;
@Size(min=3)
private String message;

}
