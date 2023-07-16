package com.mindtree.springJpa1toMany.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springJpa1toMany.dto.DepartmentDto;
import com.mindtree.springJpa1toMany.exception.DepartmentException;
import com.mindtree.springJpa1toMany.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springJpa1toMany.service.DepartmentService;


@RestController
public class DepartmentController {
	

	@Autowired
	private DepartmentService departmentService ;
	
	@PostMapping("/adddepartment")
	public ResponseEntity<Map<String, Object>> addDept(@RequestBody DepartmentDto deptDto) throws DepartmentException
	{
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			departmentService.createDepartment(deptDto);
		} catch (DepartmentServiceException e) {
			throw new DepartmentException(e);
		}
		
		response.put("Header", "DepartmentStudentProject");
		response.put("Error", false);
		response.put("message :", deptDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
}
