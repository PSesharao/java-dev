package com.mindtree.restapp.service;

import java.util.List;

import com.mindtree.restapp.dto.EmployeeDto;
import com.mindtree.restapp.entity.Employee;
import com.mindtree.restapp.exception.daoexception.EmployeeNotFoundException;
import com.mindtree.restapp.exception.serviceexception.EmployeeServiceException;

public interface EmployeeService {
	Employee getEmployeeById(long employeeId) throws EmployeeServiceException, EmployeeNotFoundException;

	List<Employee> getAllEmployees() throws EmployeeServiceException;

	Employee addNewEmployee(EmployeeDto employeeDto) throws EmployeeServiceException;

	void deleteEmployeeById(long employeeId) throws EmployeeServiceException, EmployeeNotFoundException;
}
