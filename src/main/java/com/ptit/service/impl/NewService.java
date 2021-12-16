package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.entity.NewEntity;
import com.ptit.repository.NewRepository;
import com.ptit.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Override
	public List<NewEntity> findAll() {
		return newRepository.findAll();
	}

}
