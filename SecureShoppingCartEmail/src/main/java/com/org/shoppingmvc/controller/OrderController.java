package com.org.shoppingmvc.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.shoppingmvc.dto.OrderDto;
import com.org.shoppingmvc.entity.Order;
import com.org.shoppingmvc.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping(value = "/placeOrder")
	public Order addCategory(OrderDto orderDto) throws AddressException, MessagingException, IOException {

		/*
		 * System.out.println(orderDto.getCustomer());
		 * System.out.println(orderDto.getCartList());
		 * 
		 * return null;
		 */
		Order order = orderService.placeOrder(orderDto);
		orderService.sendMail(order);
		return order;
	}
	
	
	
}
