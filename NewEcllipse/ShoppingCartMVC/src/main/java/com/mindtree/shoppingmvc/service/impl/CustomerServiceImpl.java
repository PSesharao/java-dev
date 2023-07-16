package com.mindtree.shoppingmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingmvc.converter.CustomerConverter;
import com.mindtree.shoppingmvc.dto.CustomerDto;
import com.mindtree.shoppingmvc.entity.Customer;
import com.mindtree.shoppingmvc.repository.CustomerRepository;
import com.mindtree.shoppingmvc.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;
	@Override
	public Customer createCustomer(CustomerDto customerDto) {
		
		return customerRepository.save(customerConverter.dtoToEntity(customerDto));
	}

}
