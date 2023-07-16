package com.mindtree.jsonmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mindtree.jsonmvc.entity.Employee;
import com.mindtree.jsonmvc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository ;
	
	@Override
	public void createEmployee() {
		Employee employee = new Employee();
    	employee.setFirstName("Todd");
    	employee.setLastName("Grover");
    	employee.setGender("Male");
    	employee.setSalary(5000);
    	employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		
		return employeeRepository.findById(employeeId).orElse(null);
	}

	@Override
	public String getEmployeeInJsonFormat(Employee employee) {
		Gson gson = new Gson();
		String employeeJson = gson.toJson(employee);
		//System.out.println(employeeJson);
		return employeeJson;
	}

}
