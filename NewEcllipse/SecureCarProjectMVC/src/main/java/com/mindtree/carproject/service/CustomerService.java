package com.mindtree.carproject.service;

import com.mindtree.carproject.dto.CustomerDto;
import com.mindtree.carproject.entity.Customer;

public interface CustomerService {
	Customer createCustomer(CustomerDto customerDto);
	
}
