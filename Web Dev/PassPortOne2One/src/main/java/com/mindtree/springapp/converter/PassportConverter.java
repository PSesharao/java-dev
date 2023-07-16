package com.mindtree.springapp.converter;

import org.modelmapper.ModelMapper;

import com.mindtree.springapp.Dto.PassportDto;
import com.mindtree.springapp.entity.Passport;

public class PassportConverter {
	public PassportDto entityToDto(Passport passport) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(passport, PassportDto.class);
	}

	public Passport dtoToEntity(PassportDto passportDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(passportDto, Passport.class);
	}
}
