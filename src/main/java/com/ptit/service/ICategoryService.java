package com.ptit.service;

import java.util.List;

import com.ptit.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAll();
}
