package com.mindtree.springJpa1toMany.service;

import com.mindtree.springJpa1toMany.dto.StudentDto;
import com.mindtree.springJpa1toMany.entity.Student;
import com.mindtree.springJpa1toMany.exception.serviceexception.StudentServiceException;

public interface StudentService {
	public Student createStudent(StudentDto studentDto, long deptId) throws StudentServiceException;

	public Student updateStudent(StudentDto studentDto, long studentId) throws StudentServiceException;

	public Student getStudentById(long studentId) throws StudentServiceException;
	
	public Student updateStudentAge(long studentId , int age) throws StudentServiceException;
}
