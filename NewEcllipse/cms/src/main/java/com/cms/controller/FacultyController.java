package com.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.Faculty;
import com.cms.service.FacultyLoginService;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {

	
	@Autowired
	private FacultyLoginService repo;
	
	@PostMapping("/login")
	public ResponseEntity<?> facultyLogin(@RequestBody Faculty facultyData) {

		Faculty faculty = repo.getFacultyByFaculty(facultyData.getFusername());
		if (faculty.getFpassword().equals(facultyData.getFpassword()))
			return ResponseEntity.ok(faculty);
     
		return (ResponseEntity<?>) ResponseEntity.internalServerError();

	}
}
