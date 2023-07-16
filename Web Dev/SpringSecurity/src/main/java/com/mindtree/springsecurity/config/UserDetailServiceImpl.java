package com.mindtree.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.springsecurity.entity.UserRegister;
import com.mindtree.springsecurity.repository.UserRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserRegister userRegister = userRepository.findByName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		/*
		 * System.out.println(userRegister.getName());
		 * System.out.println(userRegister.getPassword());
		 * System.out.println(userRegister.getRoles());
		 */
		return new MyUserDetails(userRegister);
	}
	
	public UserRegister getUserRegister()
	{
		return null;
		
	}

}
