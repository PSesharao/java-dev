package com.mindtree.shoppingmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingmvc.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
