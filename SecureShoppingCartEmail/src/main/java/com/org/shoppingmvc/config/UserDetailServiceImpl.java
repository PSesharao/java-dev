package com.org.shoppingmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.shoppingmvc.entity.Customer;
import com.org.shoppingmvc.repository.CustomerRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer userRegister = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
		return new MyUserDetails(userRegister);
	}
	
	

}
