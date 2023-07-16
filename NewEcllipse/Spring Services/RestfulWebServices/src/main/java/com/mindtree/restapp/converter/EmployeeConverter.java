package com.mindtree.restapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.restapp.dto.EmployeeDto;
import com.mindtree.restapp.entity.Employee;

@Component
public class EmployeeConverter {
	
	public Employee dtoToEntity(EmployeeDto employeeDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(employeeDto, Employee.class);

	}
}
