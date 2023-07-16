package com.mindtree.shopping.service;

import com.mindtree.shopping.dto.OrderDto;
import com.mindtree.shopping.entity.Order;
import com.mindtree.shopping.exception.serviceexception.OrderServiceException;

public interface OrderService {
	Order createOrder(OrderDto orderDto) throws OrderServiceException;
	
}
