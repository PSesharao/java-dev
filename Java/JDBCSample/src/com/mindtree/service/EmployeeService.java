package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Employee;
import com.mindtree.exception.serviceexception.EmployeeServiceException;

public interface EmployeeService {
	boolean insertEmployeeIntoDB(Employee empl) throws EmployeeServiceException;

	List<Employee> getAllEmployees() throws EmployeeServiceException;
}
