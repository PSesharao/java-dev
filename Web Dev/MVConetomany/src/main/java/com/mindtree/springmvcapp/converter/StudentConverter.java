package com.mindtree.springmvcapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springmvcapp.dto.StudentDto;
import com.mindtree.springmvcapp.entity.Student;
@Component
public class StudentConverter {
	public StudentDto entityToDto(Student student)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(student , StudentDto.class);
	}
	
	public Student dtoToEntity(StudentDto studentDto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(studentDto , Student.class);
		
	}
}
