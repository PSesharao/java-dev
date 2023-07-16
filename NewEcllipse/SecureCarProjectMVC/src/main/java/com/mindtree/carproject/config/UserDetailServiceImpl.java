package com.mindtree.carproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.carproject.entity.Customer;
import com.mindtree.carproject.repository.CustomerRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Customer userRegister = userRepository.findByName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		return new MyUserDetails(userRegister);
	}

}
