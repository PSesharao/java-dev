package com.mindtree.shoppingmvc.service;

import com.mindtree.shoppingmvc.dto.CustomerDto;
import com.mindtree.shoppingmvc.entity.Customer;

public interface CustomerService {
	Customer createCustomer(CustomerDto customerDto);
}
