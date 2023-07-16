package com.mindtree.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shopping.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
