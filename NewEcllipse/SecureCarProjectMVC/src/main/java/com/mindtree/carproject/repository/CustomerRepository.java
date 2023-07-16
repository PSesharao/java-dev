package com.mindtree.carproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Optional<Customer> findByName(String userName);
}
