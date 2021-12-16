package com.ptit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

}
