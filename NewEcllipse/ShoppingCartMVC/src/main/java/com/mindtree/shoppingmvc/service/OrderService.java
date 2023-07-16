package com.mindtree.shoppingmvc.service;

import com.mindtree.shoppingmvc.dto.OrderDto;
import com.mindtree.shoppingmvc.entity.Order;

public interface OrderService {
	Order placeOrder(OrderDto orderDto);
}
