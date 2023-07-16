package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.Student;
import com.cms.service.StudentLoginService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	private StudentLoginService repo;

	@PostMapping("/login")
	public ResponseEntity<?> studentLogin(@RequestBody Student studentData) {

		Student student = repo.getStudentByStudent(studentData.getSusername());
		if (student.getSpassword().equals(studentData.getSpassword()))
			return ResponseEntity.ok(student);

		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}


}
