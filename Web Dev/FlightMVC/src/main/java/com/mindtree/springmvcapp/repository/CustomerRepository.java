package com.mindtree.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springmvcapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
