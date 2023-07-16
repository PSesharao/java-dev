package com.mindtree.springapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springapp.Dto.PersonDto;
import com.mindtree.springapp.entity.Person;
@Component
public class PersonConverter {
	public PersonDto entityToDto(Person person) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(person, PersonDto.class);
	}

	public Person dtoToEntity(PersonDto personDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(personDto, Person.class);
	}
}
