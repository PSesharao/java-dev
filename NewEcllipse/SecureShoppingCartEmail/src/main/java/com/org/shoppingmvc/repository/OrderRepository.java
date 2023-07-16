package com.org.shoppingmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.shoppingmvc.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
