package com.mindtree.shoppingmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingmvc.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
