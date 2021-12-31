package com.ptit.converter;

import org.springframework.stereotype.Component;

import com.ptit.dto.NewDTO;
import com.ptit.entity.NewEntity;

@Component
public class NewConverter {

	public NewDTO toDTO(NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		newDTO.setId(newEntity.getId());
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setThumbnail(newEntity.getThumbnail());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setContent(newEntity.getContent());
		newDTO.setCategoryId(newEntity.getCategory().getId());
		newDTO.setCategoryCode(newEntity.getCategory().getCode());
		return newDTO;
	}

	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setThumbnail(newDTO.getThumbnail());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setContent(newDTO.getContent());
		return newEntity;
	}

	public NewEntity toEntity(NewDTO newDTO, NewEntity newEntity) {
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setThumbnail(newDTO.getThumbnail());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setContent(newDTO.getContent());
		return newEntity;
	}
}
