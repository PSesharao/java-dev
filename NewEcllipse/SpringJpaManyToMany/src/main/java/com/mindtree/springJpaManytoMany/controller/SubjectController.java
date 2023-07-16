package com.mindtree.springJpaManytoMany.controller;

import java.util.LinkedHashMap;
import java.util.List;
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
import com.mindtree.springJpaManytoMany.dto.SubjectDto;
import com.mindtree.springJpaManytoMany.exception.SubjectException;
import com.mindtree.springJpaManytoMany.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	

	@PostMapping("/addsubject")
	public ResponseEntity<Map<String, Object>> addSubject(@RequestBody SubjectDto subjectDto) throws SubjectException {
		Map<String, Object> response = new LinkedHashMap<>();

		subjectService.createSubject(subjectDto);
		response.put("Header", "StudentSubjectProject");
		response.put("Error", false);
		response.put("message :", subjectDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	
	@GetMapping("/getstudents/{subjectname}")
	public ResponseEntity<Map<String, Object>> getStudentsBySubject(@PathVariable(value = "subjectname")String subjectName)
			throws SubjectException {
		
		 List<Map<String, Object>> info = subjectService.getStudentsBySubject(subjectName);

	
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "StudentSubjectProject");
		response.put("Error", false);
		response.put("message :", info);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
