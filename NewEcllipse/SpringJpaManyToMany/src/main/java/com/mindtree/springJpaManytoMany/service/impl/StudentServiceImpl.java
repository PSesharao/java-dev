package com.mindtree.springJpaManytoMany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springJpaManytoMany.converter.StudentConverter;
import com.mindtree.springJpaManytoMany.dto.StudentDto;
import com.mindtree.springJpaManytoMany.entity.Student;
import com.mindtree.springJpaManytoMany.entity.Subject;
import com.mindtree.springJpaManytoMany.exception.daoexception.ResourceNotFoundException;
import com.mindtree.springJpaManytoMany.exception.serviceexception.StudentServiceException;
import com.mindtree.springJpaManytoMany.exception.serviceexception.SubjectServiceException;
import com.mindtree.springJpaManytoMany.repository.StudentRepository;
import com.mindtree.springJpaManytoMany.repository.SubjectRepository;
import com.mindtree.springJpaManytoMany.service.StudentService;
import com.mindtree.springJpaManytoMany.service.SubjectService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentConverter studentConverter;
	
	@Autowired
	private SubjectService subjectService;

	@Override
	public Student createStudent(StudentDto studentDto) throws StudentServiceException {

		return studentRepository.save(studentConverter.dtoToEntity(studentDto));
	}

	@Override
	public StudentDto assignStudentToSubjects(long studentId, long subjectId , float securedMarks) throws StudentServiceException {
		
		//List<Subject> subjects = new ArrayList<>();
		
		Student student = getStudentById(studentId);
		
		Subject  subject = null;
		
			try {
				subject = subjectService.getSubjectById(subjectId);
			} catch (SubjectServiceException e) {
				throw new StudentServiceException(e.getLocalizedMessage());
			}
			subject.setSecuredMarks(securedMarks);
			student.getSubjectList().add(subject);
			subject.getStudentList().add(student);
			studentRepository.save(student);
			try {
				subjectService.saveSubject(subject);
			} catch (SubjectServiceException e) {
			
				throw new StudentServiceException(e.getLocalizedMessage());
			}
		
		return studentConverter.entityToDto(student);
	}

	@Override
	public Student getStudentById(long studentId) throws StudentServiceException {

		try {
			return studentRepository.findById(studentId)
					.orElseThrow(() -> new ResourceNotFoundException("No student Found With Id " + studentId));
		} catch (ResourceNotFoundException e) {

			throw new StudentServiceException(e.getLocalizedMessage());
		}
	}

}
