package com.mindtree.springmvcapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springmvcapp.dto.CustomerDto;
import com.mindtree.springmvcapp.entity.Customer;

@Component
public class CustomerConverter {
	public CustomerDto entityToDto(Customer customer)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(customer ,CustomerDto.class );
	}
	
	public Customer dtoToEntity(CustomerDto customerDto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(customerDto , Customer.class);
	}
}
