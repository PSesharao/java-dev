package com.mindtree.restapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.mindtree.restapp.converter.EmployeeConverter;
import com.mindtree.restapp.dto.EmployeeDto;
import com.mindtree.restapp.entity.Employee;
import com.mindtree.restapp.exception.daoexception.EmployeeNotFoundException;
import com.mindtree.restapp.repository.EmployeeRepository;
import com.mindtree.restapp.service.EmployeeService;

@Service
@ComponentScan("com.mindtree.restapp.converter")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeConverter employeeConverter;

	@Override
	public Employee getEmployeeById(long employeeId) throws EmployeeNotFoundException {

		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("The employee with id " + employeeId + " not found."));
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee addNewEmployee(EmployeeDto employeeDto) {

		return employeeRepository.save(employeeConverter.dtoToEntity(employeeDto));
	}

	

	@Override
	public void deleteEmployeeById(long employeeId) throws EmployeeNotFoundException {
		employeeRepository.findById(employeeId)
		.orElseThrow(() -> new EmployeeNotFoundException("The employee with id " + employeeId + " not found."));
		employeeRepository.deleteById(employeeId);

	}

}
