package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Faculty;
import com.cms.repo.FacultyRepo;

@Service
public class FacultyLoginService {

	
	@Autowired
	FacultyRepo facultyRepo;
	
	public Faculty getFacultyByFaculty(String username) {
		return facultyRepo.findByFusername(username);
	}
}
