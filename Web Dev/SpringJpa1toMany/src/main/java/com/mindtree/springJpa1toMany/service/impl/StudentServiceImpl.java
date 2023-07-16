package com.mindtree.springJpa1toMany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springJpa1toMany.converter.StudentConverter;
import com.mindtree.springJpa1toMany.dto.StudentDto;
import com.mindtree.springJpa1toMany.entity.Department;
import com.mindtree.springJpa1toMany.entity.Student;
import com.mindtree.springJpa1toMany.exception.daoexception.DepartmentStrengthExceedException;
import com.mindtree.springJpa1toMany.exception.daoexception.ResourceNotFoundException;
import com.mindtree.springJpa1toMany.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springJpa1toMany.exception.serviceexception.StudentServiceException;
import com.mindtree.springJpa1toMany.repository.StudentRepository;
import com.mindtree.springJpa1toMany.service.DepartmentService;
import com.mindtree.springJpa1toMany.service.StudentService;

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
			throw new StudentServiceException(e);
		}
		if (department.getStudents().size() >= department.getStrength()) {
			try {
				throw new DepartmentStrengthExceedException("The department " + "'" + department.getName() + "'"
						+ " strength is only " + department.getStrength());
			} catch (DepartmentStrengthExceedException e) {
				throw new StudentServiceException(e);
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
		Student student = null;
		try {
			student = studentRepository.findById(studentId)
					.orElseThrow(() -> new ResourceNotFoundException("Student not found with id :" + studentId));
		} catch (ResourceNotFoundException e) {
			throw new StudentServiceException(e);
		}
			return student;
	}

	@Override
	public Student updateStudentAge(long studentId, int age) throws StudentServiceException {
		Student existingStudent = getStudentById(studentId);
		existingStudent.setAge(age);
		return studentRepository.save(existingStudent);
	}

}
