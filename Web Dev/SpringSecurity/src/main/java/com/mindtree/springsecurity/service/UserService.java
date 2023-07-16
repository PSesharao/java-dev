package com.mindtree.springsecurity.service;

import com.mindtree.springsecurity.entity.UserRegister;

public interface UserService {
	UserRegister registerUser(UserRegister userRegister);
}
