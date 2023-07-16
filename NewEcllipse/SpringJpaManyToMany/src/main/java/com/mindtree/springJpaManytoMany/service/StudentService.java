package com.mindtree.springJpaManytoMany.service;
import com.mindtree.springJpaManytoMany.dto.StudentDto;
import com.mindtree.springJpaManytoMany.entity.Student;
import com.mindtree.springJpaManytoMany.exception.serviceexception.StudentServiceException;

public interface StudentService {
	  
	 Student createStudent(StudentDto studentDto) throws StudentServiceException; 
	 StudentDto assignStudentToSubjects(long studentId , long subjectId , float securedMarks) throws StudentServiceException;
	 Student getStudentById(long studentId)  throws StudentServiceException;
	 
}
