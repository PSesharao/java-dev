package com.mindtree.passenger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.passenger.entity.UserRegister;

public interface UserRepository extends JpaRepository<UserRegister, Long> {

	Optional<UserRegister> findByEmail(String email);

	Optional<UserRegister> findByName(String username);

}
