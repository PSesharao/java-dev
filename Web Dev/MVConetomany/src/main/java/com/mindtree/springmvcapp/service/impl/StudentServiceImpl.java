package com.mindtree.springmvcapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springmvcapp.converter.StudentConverter;
import com.mindtree.springmvcapp.dto.StudentDto;
import com.mindtree.springmvcapp.entity.Department;
import com.mindtree.springmvcapp.entity.Student;
import com.mindtree.springmvcapp.exception.daoexception.DepartmentStrengthExceedException;
import com.mindtree.springmvcapp.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springmvcapp.exception.serviceexception.StudentServiceException;
import com.mindtree.springmvcapp.repository.StudentRepository;
import com.mindtree.springmvcapp.service.DepartmentService;
import com.mindtree.springmvcapp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentConverter studentConverter;

	@Autowired
	private DepartmentService departmentService;

	@Override
	public Student createStudent(StudentDto studentDto, long deptId) throws StudentServiceException {
		Department department = null;
		try {
			department = departmentService.getDeptById(deptId);
		} catch (DepartmentServiceException e) {
			throw new StudentServiceException(e.getLocalizedMessage());
		}
		if (department.getStudents().size() >= department.getStrength()) {
			try {
				throw new DepartmentStrengthExceedException(
						"The department " +"'"+department.getName() +"'"+ " strength is only " + department.getStrength());
			} catch (DepartmentStrengthExceedException e) {
				throw new StudentServiceException(e.getLocalizedMessage());
			}
		}
		Student student = studentConverter.dtoToEntity(studentDto);
		student.setDepartment(department);
		department.getStudents().add(student);
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(StudentDto studentDto, long studentId) throws StudentServiceException {
		Student existingStudent = getStudentById(studentId);

		existingStudent.setName(studentDto.getName());

		existingStudent.setAge(studentDto.getAge());

		existingStudent.setGender(studentDto.getGender());

		existingStudent.setHobbies(studentDto.getHobbies());
		return studentRepository.save(existingStudent);
	}

	@Override
	public Student getStudentById(long studentId) throws StudentServiceException {

		return studentRepository.findById(studentId).orElse(null);
	}

}
