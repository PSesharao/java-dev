package com.mindtree.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springsecurity.entity.UserRegister;

@Repository
public interface UserRepository extends JpaRepository<UserRegister, Long> {
	Optional<UserRegister> findByName(String userName);
}
