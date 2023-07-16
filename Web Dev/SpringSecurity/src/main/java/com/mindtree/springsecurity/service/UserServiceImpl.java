package com.mindtree.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springsecurity.entity.UserRegister;
import com.mindtree.springsecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository ;
	public UserRegister registerUser(UserRegister userRegister)
	{
		return userRepository.save(userRegister);
	}
}
