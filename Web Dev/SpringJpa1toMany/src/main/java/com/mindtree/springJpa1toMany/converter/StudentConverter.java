package com.mindtree.springJpa1toMany.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springJpa1toMany.dto.StudentDto;
import com.mindtree.springJpa1toMany.entity.Student;

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
