package com.mindtree.springexception.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springexception.entity.Doctor;
import com.mindtree.springexception.exception.InvalidFieldException;
import com.mindtree.springexception.repository.DoctorRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorRepository doctorRepository;

	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody Doctor doctor) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "DoctorProject");
		if (doctor.getDesignation().isEmpty()) {
			response.put("Error", true);
			response.put("message :", new InvalidFieldException("Designation should not be empty").getLocalizedMessage());
			response.put("HttpRequest ", HttpStatus.EXPECTATION_FAILED);
		} else {
			response.put("Error", false);
			response.put("message :", doctorRepository.findAll());
			response.put("HttpRequest ", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public Doctor getDoctorByName(@PathVariable(value = "name") String name)
	{
		return doctorRepository.findByName(name);
	}
	/*@ExceptionHandler
	public String dealInvalidField(InvalidFieldException e)
	{
		return e.getMessage();
	}*/
	
	
}
