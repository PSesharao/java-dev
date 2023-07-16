package com.mindtree.springJpaManytoMany.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springJpaManytoMany.dto.StudentDto;
import com.mindtree.springJpaManytoMany.entity.Student;
import com.mindtree.springJpaManytoMany.exception.StudentException;
import com.mindtree.springJpaManytoMany.exception.serviceexception.SubjectServiceException;
import com.mindtree.springJpaManytoMany.service.StudentService;
import com.mindtree.springJpaManytoMany.service.SubjectService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SubjectService subjectService;

	@PostMapping("/addstudent")
	public ResponseEntity<Map<String, Object>> addStud(@RequestBody StudentDto studDto) throws StudentException {

		studentService.createStudent(studDto);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", false);
		response.put("message :", studDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/assignstudent/{id},{subId},{securedMarks}")
	public ResponseEntity<Map<String, Object>> assignStudentToSubject(@PathVariable(value = "subId") long subjectId,
			@PathVariable(value = "id") long studentId, @PathVariable(value = "securedMarks") float securedMarks)
			throws StudentException {

		StudentDto studentDto = studentService.assignStudentToSubjects(studentId, subjectId, securedMarks);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", false);
		response.put("message :", studentDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/getstudentinfo/{id}")
	public ResponseEntity<Map<String, Object>> getStudent(@PathVariable(value = "id") long studentId)
			throws StudentException {

		Map<String, Object> message = new LinkedHashMap<>();
		Student student = studentService.getStudentById(studentId);

		message.put("name", student.getName());
		try {
			message.put("subject Info", subjectService.getSubjectDtoList(student.getSubjectList()));
			float totatSecuredMarks = subjectService.getTotalSecuredMarks(student.getSubjectList());
			int totalMarks = subjectService.getTotalMarks(student.getSubjectList());
			message.put("marks report", totatSecuredMarks + "/" + totalMarks);
		} catch (SubjectServiceException e) {
			throw new StudentException(e.getLocalizedMessage());
		}

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", false);
		response.put("message :", message);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
