package com.mindtree.shopping.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shopping.dto.OrderDto;
import com.mindtree.shopping.exception.globalexception.OrderException;
import com.mindtree.shopping.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/createorder")
	public ResponseEntity<Map<String, Object>> addOrder(@RequestBody OrderDto orderDto) throws OrderException{
		orderService.createOrder(orderDto);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", false);
		response.put("message :", orderDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
