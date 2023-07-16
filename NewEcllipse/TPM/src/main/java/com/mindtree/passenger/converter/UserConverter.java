package com.mindtree.passenger.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.passenger.dto.UserDto;
import com.mindtree.passenger.entity.UserRegister;
@Component
public class UserConverter {
	public UserDto entityToDto(UserRegister userRegister) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(userRegister, UserDto.class);
	}

	public UserRegister dtoToEntity(UserDto userDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(userDto, UserRegister.class);

	}
}
