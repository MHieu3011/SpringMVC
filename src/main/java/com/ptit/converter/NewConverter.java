package com.ptit.converter;

import org.springframework.stereotype.Component;

import com.ptit.dto.NewDTO;
import com.ptit.entity.NewEntity;

@Component
public class NewConverter {

	public NewDTO toDTO(NewEntity entity) {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setThumbnail(entity.getThumbnail());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setCategoryId(entity.getCategory().getId());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}

	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setThumbnail(dto.getThumbnail());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		return result;
	}
}
