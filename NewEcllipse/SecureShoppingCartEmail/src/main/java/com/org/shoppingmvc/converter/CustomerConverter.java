
package com.org.shoppingmvc.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.org.shoppingmvc.dto.CustomerDto;
import com.org.shoppingmvc.entity.Customer;



@Component
public class CustomerConverter {
	public CustomerDto entityToDto(Customer customer) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(customer, CustomerDto.class);
	}

	public Customer dtoToEntity(CustomerDto customerDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(customerDto, Customer.class);
	}
}
