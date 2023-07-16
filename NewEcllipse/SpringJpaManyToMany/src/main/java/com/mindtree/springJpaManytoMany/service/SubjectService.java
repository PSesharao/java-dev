package com.mindtree.springJpaManytoMany.service;

import java.util.List;
import java.util.Map;

import com.mindtree.springJpaManytoMany.dto.StudentDto;
import com.mindtree.springJpaManytoMany.dto.SubjectDto;
import com.mindtree.springJpaManytoMany.entity.Subject;
import com.mindtree.springJpaManytoMany.exception.serviceexception.SubjectServiceException;

public interface SubjectService {
	Subject createSubject(SubjectDto subjectDto) throws SubjectServiceException;

	List<Subject> getSubjectsByName(String subjectName) throws SubjectServiceException;

	Subject getSubjectById(long subjectId) throws SubjectServiceException;

	Subject saveSubject(Subject subject) throws SubjectServiceException;

	List<Map<String, Object>>  getStudentsBySubject(String subjectName) throws SubjectServiceException;

	List<Subject> sortSubjectsByMarks(List<Subject> subjectList) throws SubjectServiceException;

	List<SubjectDto> getSubjectDtoList(List<Subject> subjectList) throws SubjectServiceException;

	float getTotalSecuredMarks(List<Subject> subjectList) throws SubjectServiceException;

	int getTotalMarks(List<Subject> subjectList) throws SubjectServiceException;
}
