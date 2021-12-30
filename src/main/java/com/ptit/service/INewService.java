package com.ptit.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ptit.dto.NewDTO;

public interface INewService {

	List<NewDTO> findAll(Pageable pageable);

	Integer getTotalItem();
}
