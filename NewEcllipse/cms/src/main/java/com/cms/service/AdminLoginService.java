package com.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.model.Admin;
import com.cms.model.Student;
import com.cms.repo.AdminRepo;
import com.cms.repo.StudentRepo;

@Service
@Transactional
public class AdminLoginService{
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	StudentRepo srepo;
	
	public Admin getAdminByAdmin(String username) {
		return adminRepo.findByAusername(username);
	}

	public List<Student> getAllStudent() {
		return srepo.findAll();
	}
	
	public Student addNewStudent(Student student) {
		return srepo.save(student);
	}
	

	public void removeStudentDetails(Student student)
	{
		srepo.deleteBySusername(student.getSusername());
	}
	
	
}