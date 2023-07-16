package com.mindtree.shoppingmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.shoppingmvc.dto.OrderDto;
import com.mindtree.shoppingmvc.entity.Order;
import com.mindtree.shoppingmvc.service.OrderService;



@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@ResponseBody
	@RequestMapping(value = "/placeOrder")
	public Order addCategory(OrderDto orderDto)
	{
		
		/*
		 * System.out.println(orderDto.getCustomer());
		 * System.out.println(orderDto.getCartList());
		 * 
		 * return null;
		 */
		 
		return orderService.placeOrder(orderDto);
	}
}
