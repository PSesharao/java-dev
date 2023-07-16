package com.org.shoppingmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.shoppingmvc.dto.CustomerDto;
import com.org.shoppingmvc.entity.Customer;
import com.org.shoppingmvc.entity.Order;
import com.org.shoppingmvc.repository.CustomerRepository;
import com.org.shoppingmvc.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerRepository customerRepository;
	@ResponseBody
	@RequestMapping(value = "/createCustomer")
	public Customer createCustomer(CustomerDto customerDto) {
		/*
		 * System.out.println(customerDto.getName());
		 * System.out.println(customerDto.getGender());
		 * System.out.println(customerDto.getAddress());
		 * System.out.println(customerDto.getHobbyList()); return customerDto;
		 */
		/*
		 * Customer customer = new Customer(); customer.setId(1000);
		 * customer.setName("Sesharao"); customer.setGender("male");
		 * customer.setEmail("s@gmail.com"); return customer;
		 */
		return customerService.createCustomer(customerDto);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCustomers")
	public List<Customer> getCustomers()
	{
		return customerRepository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCustomer/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") long customerId)
	{
		return customerRepository.findById(customerId).orElse(null);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCustomerOrders/{customerId}")
	public List<Order> getCustomerOrders(@PathVariable("customerId") long customerId)
	{
		return customerRepository.findById(customerId).get().getOrderList();
	}
	
	
}
