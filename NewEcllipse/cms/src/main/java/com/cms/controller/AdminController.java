package com.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.Admin;
import com.cms.model.Student;
import com.cms.service.AdminLoginService;
import com.cms.service.StudentLoginService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {

	@Autowired
	private AdminLoginService repo;

	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestBody Admin adminData) {

		Admin admin = repo.getAdminByAdmin(adminData.getAusername());
		if (admin.getApassword().equals(adminData.getApassword()))
			return ResponseEntity.ok(admin);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();

	}
	
//	R view list of all the students 
	@GetMapping("/student-list")
	public List<Student> listStudents()
	{
		return repo.getAllStudent();
	}
	
//	C add student
	@PostMapping("/add-student")
	public Student addStudent(@RequestBody Student student)
	{
		return repo.addNewStudent(student);
	}
	
//	D delete student
	@PutMapping("/delete-student")
	public void removeStudent(@RequestBody Student student)
	{
		repo.removeStudentDetails(student);
	}

}
