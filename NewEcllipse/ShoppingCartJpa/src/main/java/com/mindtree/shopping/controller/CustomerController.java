package com.mindtree.shopping.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shopping.converter.CustomerConverter;
import com.mindtree.shopping.dto.CustomerDto;
import com.mindtree.shopping.exception.globalexception.CustomerException;
import com.mindtree.shopping.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	/*
	 * @Autowired private CustomerConverter customerConverter;
	 */

	@PostMapping("/createcustomer")
	public ResponseEntity<Map<String, Object>> addCustomer(@RequestBody CustomerDto customerDto) throws CustomerException{
		customerService.createCustomer(customerDto);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", false);
		response.put("message :", customerDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerInfo/{phoneNumber}")
	public ResponseEntity<Map<String, Object>> getCustomerInfo(@PathVariable(value = "phoneNumber") String phoneNumber) throws CustomerException{
		List<Map<String, Object>> allOrderinfo = customerService.getCustomerInfo(phoneNumber);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "ShoppingCartProject");
		response.put("Error", false);
		response.put("message ", allOrderinfo);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
