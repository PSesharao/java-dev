package com.mindtree.springJpaManytoMany.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springJpaManytoMany.dto.SubjectDto;
import com.mindtree.springJpaManytoMany.entity.Subject;

@Component
public class SubjectConverter {
	public SubjectDto entityToDto(Subject subject) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(subject, SubjectDto.class);
	}

	public Subject dtoToEntity(SubjectDto subjectDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(subjectDto, Subject.class);
	}
}
