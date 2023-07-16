package com.mindtree.springmvcapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springmvcapp.converter.CustomerConverter;
import com.mindtree.springmvcapp.dto.CustomerDto;
import com.mindtree.springmvcapp.entity.Customer;
import com.mindtree.springmvcapp.exception.serviceexception.CustomerServiceException;
import com.mindtree.springmvcapp.repository.CustomerRepository;
import com.mindtree.springmvcapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public Customer createCustomer(CustomerDto customerDto) throws CustomerServiceException {
		// TODO Auto-generated method stub
		return customerRepository.save(customerConverter.dtoToEntity(customerDto));
	}

	@Override
	public Customer getCustomerById(long customerId) throws CustomerServiceException {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).get();
	}

}
