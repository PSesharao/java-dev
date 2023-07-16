package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Student;
import com.cms.repo.StudentRepo;


@Service
public class StudentLoginService {

	@Autowired
	StudentRepo studentRepo;
	
	public Student getStudentByStudent(String username) {
		return studentRepo.findBySusername(username);
	}

	
}
