package com.mindtree.passenger.service;

import com.mindtree.passenger.dto.UserDto;
import com.mindtree.passenger.entity.UserRegister;

public interface UserService {
	UserRegister registerUser(UserDto userDto);
}
