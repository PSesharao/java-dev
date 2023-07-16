package com.mindtree.restapp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.restapp.dto.EmployeeDto;
import com.mindtree.restapp.exception.daoexception.EmployeeNotFoundException;
import com.mindtree.restapp.exception.globalexception.EmployeeException;
import com.mindtree.restapp.exception.serviceexception.EmployeeServiceException;
import com.mindtree.restapp.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public ResponseEntity<Map<String, Object>> getAllEmployees()
			throws EmployeeServiceException, EmployeeException, Exception {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", false);
		response.put("HttpStatus ", HttpStatus.OK);
		response.put("message ", employeeService.getAllEmployees());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Map<String, Object>> getEmployee(@PathVariable(value = "id") long employeeId)
			throws EmployeeServiceException, EmployeeNotFoundException {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", false);
		response.put("HttpStatus ", HttpStatus.OK);
		response.put("message ", employeeService.getEmployeeById(employeeId));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Map<String, Object>> addEmployee(@Valid @RequestBody EmployeeDto employeeDto)
			throws EmployeeServiceException, EmployeeNotFoundException {
		;
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", false);
		response.put("HttpStatus ", HttpStatus.CREATED);
		response.put("message ",
				"New Employee with id " + employeeService.addNewEmployee(employeeDto).getId() + " is created");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable(value = "id") long employeeId)
			throws EmployeeServiceException, EmployeeNotFoundException {
		employeeService.deleteEmployeeById(employeeId);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header ", "EmployeeProject");
		response.put("Error ", false);
		response.put("HttpStatus ", HttpStatus.NO_CONTENT);
		response.put("message ", "Employee with id " + employeeId + " has been deleted");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
	}

}
