package com.mindtree.shopping.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.shopping.converter.CustomerConverter;
import com.mindtree.shopping.dto.CustomerDto;
import com.mindtree.shopping.entity.Customer;
import com.mindtree.shopping.exception.serviceexception.CustomerServiceException;
import com.mindtree.shopping.repository.CustomerRepository;
import com.mindtree.shopping.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@MockBean
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerConverter customerConverter;

	@Test
	public void testCreateCustomer() throws CustomerServiceException {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("mockName");
		customerDto.setPhoneNumber("mockPhoneNumber");

		Customer customer = customerConverter.dtoToEntity(customerDto);

		doReturn(customer).when(customerRepository).save(any());

		Customer customerExpected = customerService.createCustomer(customerDto);

		Assertions.assertNotNull(customerExpected, "The saved customer should not be null");
	}

	@Test
	public void testgetCustomerInfo() throws CustomerServiceException {
		Optional<Customer> customer = Optional.of(new Customer());
		customer.get().setName("mockName");
		customer.get().setPhoneNumber("mockPhoneNumber");
		
		String phoneNumber = "mockPhoneNumber";
		//List<Map<String, Object>> allOrderinfo = new ArrayList<>();

		doReturn(customer).when(customerRepository).findByPhoneNumber("mockPhoneNumber");
		Optional<Customer> customerExpected = customerRepository.findByPhoneNumber(phoneNumber);
		Assertions.assertEquals(customerExpected, customer, "The expected customer is different");

	}

}
