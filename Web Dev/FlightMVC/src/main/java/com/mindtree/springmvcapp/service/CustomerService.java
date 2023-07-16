package com.mindtree.springmvcapp.service;

import com.mindtree.springmvcapp.dto.CustomerDto;
import com.mindtree.springmvcapp.entity.Customer;
import com.mindtree.springmvcapp.exception.serviceexception.CustomerServiceException;


public interface CustomerService {
	
	public Customer  createCustomer(CustomerDto customerDto ) throws CustomerServiceException;
	
	public Customer getCustomerById( long customerId) throws CustomerServiceException;
}
