package com.mindtree.springmvcapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.springmvcapp.dto.CustomerDto;
import com.mindtree.springmvcapp.exception.serviceexception.CustomerServiceException;
import com.mindtree.springmvcapp.service.CustomerService;

@Controller
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/frame")
	public String hmf()
	{
		return "frame";
	}
	
	@RequestMapping("/navtabs")
	public String navtabs()
	{
		return "navtabs";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/customer")
	public String welcome()
	{
		return "customer";
	}
	
	
	@RequestMapping("/addcustomer")
	public String addCustomer(CustomerDto customerDto) 
	{
		try {
			customerService.createCustomer(customerDto);
		} catch (CustomerServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
	
}
