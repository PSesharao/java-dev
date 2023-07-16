package com.mindtree.shoppingmvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingmvc.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Optional<Customer> findByName(String userName);
	Optional<Customer> findByEmail(String email);
}
