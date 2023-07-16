package com.mindtree.passenger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.passenger.entity.UserRegister;
import com.mindtree.passenger.repository.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserRegister userRegister = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
		return new MyUserDetails(userRegister);
	}
	
	

}
