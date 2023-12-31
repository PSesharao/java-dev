package com.mindtree.springsecurity.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mindtree.springsecurity.entity.UserRegister;

public class MyUserDetails implements UserDetails{

	private String name ;
	private String password;
	private List<GrantedAuthority> authorities;
	
	  public MyUserDetails(UserRegister user) {
	        this.name = user.getName();
	        this.password = user.getPassword();
	        this.authorities = user.getRoles().
	        		stream().
	        		//map(SimpleGrantedAuthority::new)
	        		map(role -> new SimpleGrantedAuthority("ROLE_"+role))
	        		.collect(Collectors.toList());	
	       // System.out.println(authorities);
	    }
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
