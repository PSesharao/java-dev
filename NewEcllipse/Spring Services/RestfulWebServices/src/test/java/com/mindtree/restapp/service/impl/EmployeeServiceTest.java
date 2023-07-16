package com.mindtree.restapp.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.restapp.converter.EmployeeConverter;
import com.mindtree.restapp.dto.EmployeeDto;
import com.mindtree.restapp.entity.Employee;
import com.mindtree.restapp.exception.daoexception.EmployeeNotFoundException;
import com.mindtree.restapp.exception.serviceexception.EmployeeServiceException;
import com.mindtree.restapp.repository.EmployeeRepository;
import com.mindtree.restapp.service.EmployeeService;

@SpringBootTest
class EmployeeServiceTest {
	@MockBean
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Test
	public void testGetAllEmployees() throws EmployeeServiceException {
		List<Employee> employeeList = new ArrayList<>();
		List<Employee> expectedEmployeeList;
		employeeList.add(new Employee(101, "Seshu", "Rao", "Java EE", 25000, "pari@gmail.com"));
		employeeList.add(new Employee(102, "Seshu1", "Rao1", "Java EE1", 25000, "pari@gmail1.com"));
		employeeList.add(new Employee(103, "Seshu2", "Rao2", "Java EE2", 25000, "pari@gmail2.com"));

		doReturn(employeeList).when(employeeRepository).findAll();
		expectedEmployeeList = employeeService.getAllEmployees();
		Assertions.assertEquals(expectedEmployeeList, employeeList, "The expected employeeList is different");
	}

	@Test
	public void testGetEmployeeById() throws EmployeeServiceException, EmployeeNotFoundException {
		long mockId = 101;
		Optional<Employee> employee = Optional
				.of(new Employee(mockId, "Seshu", "Rao", "Java EE", 25000, "pari@gmail.com"));

		doReturn(employee).when(employeeRepository).findById(mockId);
		Optional<Employee> employeeExpected = Optional.of(employeeService.getEmployeeById(mockId));
		Assertions.assertEquals(employeeExpected, employee, "The expected employee is different");
	}

	@Test
	public void testAddNewEmployee() throws EmployeeServiceException {
		EmployeeDto employeeDto = new EmployeeDto("Seshu", "Rao", "Java EE", 25000, "pari@gmail.com");
		Employee employee = employeeConverter.dtoToEntity(employeeDto);
		doReturn(employee).when(employeeRepository).save(any());
		Employee employeeExpected = employeeService.addNewEmployee(employeeDto);
		Assertions.assertNotNull(employeeExpected, "The saved employee should not be null");
	}

	@Test
	public void testDeleteEmployee() throws EmployeeServiceException, EmployeeNotFoundException {

		long employeeId = 101;
		Optional<Employee> employee = Optional
				.of(new Employee(employeeId, "Seshu", "Rao", "Java EE", 25000, "pari@gmail.com"));

		doReturn(employee).when(employeeRepository).findById(employeeId);
		doNothing().when(employeeRepository).deleteById(employeeId);
		employeeService.deleteEmployeeById(employeeId);

		verify(employeeRepository, times(1)).findById(employeeId);

		verify(employeeRepository, times(1)).deleteById(employeeId);
	}
}
