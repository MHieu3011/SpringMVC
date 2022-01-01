package com.ptit.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ptit.dto.NewDTO;

public interface INewService {

	List<NewDTO> findAll(Pageable pageable);

	Integer getTotalItem();

	NewDTO findOne(Long id);

//	NewDTO insert(NewDTO newDTO);
//
//	NewDTO update(NewDTO newDTO);

	NewDTO save(NewDTO newDTO);

	void delete(long[] ids);
}
