package com.mindtree.shopping.service;

import java.util.List;
import java.util.Map;

import com.mindtree.shopping.dto.CustomerDto;
import com.mindtree.shopping.entity.Customer;
import com.mindtree.shopping.exception.serviceexception.CustomerServiceException;

public interface CustomerService {
	Customer createCustomer(CustomerDto customerDto) throws CustomerServiceException;

	List<Map<String, Object>> getCustomerInfo(String phoneNumber) throws CustomerServiceException;
}
