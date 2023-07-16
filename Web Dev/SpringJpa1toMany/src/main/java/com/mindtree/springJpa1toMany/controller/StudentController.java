package com.mindtree.springJpa1toMany.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springJpa1toMany.converter.StudentConverter;
import com.mindtree.springJpa1toMany.dto.StudentDto;
import com.mindtree.springJpa1toMany.entity.Department;
import com.mindtree.springJpa1toMany.entity.Student;
import com.mindtree.springJpa1toMany.exception.StudentException;
import com.mindtree.springJpa1toMany.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;


	@Autowired
	private StudentConverter studentConverter;
	
	@PostMapping("/dummy")
	public ResponseEntity<Map<String, Object>> dummy(@RequestBody List<Integer> list
			) throws StudentException {

		System.out.println(list);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "DepartmentStudentProject");
		response.put("Error", false);
		response.put("message :", list);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	@PostMapping("/addstudent/{id}")
	public ResponseEntity<Map<String, Object>> addStud(@RequestBody List<StudentDto> studDtoList,
			@PathVariable(value = "id") long deptId) throws StudentException {

		for (StudentDto studDto : studDtoList) {
			studentService.createStudent(studDto, deptId);
		}

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "DepartmentStudentProject");
		response.put("Error", false);
		response.put("message :", studDtoList);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PutMapping("/updatestudent/{id}") 
	public ResponseEntity<Map<String, Object>> saveStd(@PathVariable(value = "id") long studId,
			@RequestBody StudentDto studDto) throws StudentException {
		Student updatedStudent = studentService.updateStudent(studDto, studId);
		Department department = updatedStudent.getDepartment();
		department.getStudents().forEach(student -> {
			if (student.getId() == studId) {
				student = updatedStudent;
			}
		});
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "DepartmentStudentProject");
		response.put("Error", false);
		response.put("message :", studDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/updatestudentage/{id},{age}")
	public ResponseEntity<Map<String, Object>> updateAge(@PathVariable(value = "id") long studId,
			@PathVariable(value = "age") int age) throws StudentException {
		Student updatedStudent = studentService.updateStudentAge(studId, age);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "DepartmentStudentProject");
		response.put("Error", false);
		response.put("message :", studentConverter.entityToDto(updatedStudent));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
