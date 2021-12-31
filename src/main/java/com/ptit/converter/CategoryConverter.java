package com.ptit.converter;

import org.springframework.stereotype.Component;

import com.ptit.dto.CategoryDTO;
import com.ptit.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setCode(categoryEntity.getCode());
		categoryDTO.setName(categoryEntity.getName());
		return categoryDTO;
	}

	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCode(categoryDTO.getCode());
		categoryEntity.setName(categoryDTO.getName());
		return categoryEntity;
	}
}
