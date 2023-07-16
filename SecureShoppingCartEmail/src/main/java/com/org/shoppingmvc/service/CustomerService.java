package com.org.shoppingmvc.service;

import com.org.shoppingmvc.dto.CustomerDto;
import com.org.shoppingmvc.entity.Customer;

public interface CustomerService {
	Customer createCustomer(CustomerDto customerDto);
	
}
