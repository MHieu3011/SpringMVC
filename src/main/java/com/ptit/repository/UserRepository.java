package com.ptit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUserNameAndStatus(String userName, Integer status);
}
