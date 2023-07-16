package com.mindtree.jspapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.jspapp.repository.UserLogRepository;

@Service
public class UserLogServiceImpl {
	@Autowired
	private UserLogRepository userLogRepository;
	
	
}
