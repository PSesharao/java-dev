package com.mindtree.springex1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springex1.entity.Doctor;
import com.mindtree.springex1.exception.DoctorNotFoundException;
import com.mindtree.springex1.exception.InvalidFieldException;
import com.mindtree.springex1.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
     @Autowired
     private DoctorService doctorService;

	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		if (doctor.getDesignation().isEmpty()) {
			throw new InvalidFieldException("Designation should be not null");
		}
		return doctorService.createDoctor(doctor);

	}

	@GetMapping("/{name}")
	public Doctor getDoctorByName(@PathVariable(value = "name") String name) {
		Doctor doctor = doctorService.getDoctorByName(name);
		if(doctor==null)
		{
			throw new DoctorNotFoundException("No doctors found for the given name");
		}
		
		return doctor;
	}
	
	
	/*
	 * @ExceptionHandler public String dealInvalidField(InvalidFieldException e)
	 * { return e.getMessage(); }
	 */

}
