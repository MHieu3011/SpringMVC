package com.ptit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptit.dto.NewDTO;
import com.ptit.entity.NewEntity;
import com.ptit.repository.NewRepository;
import com.ptit.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> newDTOs = new ArrayList<>();
		List<NewEntity> newEntities = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : newEntities) {
			NewDTO newDTO = new NewDTO();
			newDTO.setTitle(newEntity.getTitle());
			newDTO.setShortDescription(newEntity.getShortDescription());
			newDTOs.add(newDTO);
		}
		return newDTOs;
	}

	@Override
	public Integer getTotalItem() {
		return (int) newRepository.count();
	}

}
