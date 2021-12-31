package com.ptit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.converter.CategoryConverter;
import com.ptit.dto.CategoryDTO;
import com.ptit.entity.CategoryEntity;
import com.ptit.repository.CategoryRepository;
import com.ptit.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		for (CategoryEntity entity : categoryEntities) {
			results.add(categoryConverter.toDTO(entity));
		}
		return results;
	}

}
