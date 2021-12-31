package com.ptit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptit.converter.NewConverter;
import com.ptit.dto.NewDTO;
import com.ptit.entity.NewEntity;
import com.ptit.repository.NewRepository;
import com.ptit.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private NewConverter newConverter;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> newDTOs = new ArrayList<>();
		List<NewEntity> newEntities = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : newEntities) {
			newDTOs.add(newConverter.toDTO(newEntity));
		}
		return newDTOs;
	}

	@Override
	public Integer getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findOne(Long id) {
		return newConverter.toDTO(newRepository.findOne(id));
	}

}
