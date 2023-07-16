package com.mindtree.jsonmvc.service;


import com.mindtree.jsonmvc.entity.Employee;

public interface EmployeeService {
	void createEmployee();
	Employee getEmployeeById(long employeeId);
	String getEmployeeInJsonFormat(Employee employee);
}
