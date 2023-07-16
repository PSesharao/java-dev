package com.mindtree.springmvcapp.service;

import com.mindtree.springmvcapp.dto.StudentDto;
import com.mindtree.springmvcapp.entity.Student;
import com.mindtree.springmvcapp.exception.serviceexception.StudentServiceException;

public interface StudentService {
	public Student createStudent(StudentDto studentDto , long deptId) throws StudentServiceException;
	
	public Student updateStudent(StudentDto studentDto , long studentId) throws StudentServiceException;
	
	public Student getStudentById( long studentId) throws StudentServiceException;
}
