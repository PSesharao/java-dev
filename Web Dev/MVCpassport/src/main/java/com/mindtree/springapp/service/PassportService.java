package com.mindtree.springapp.service;

import com.mindtree.springapp.entity.Passport;

public interface PassportService {
	Passport addpassport(Passport passport);
	
	Passport getPassportById(String passId);
	
	Passport updatePassport(String passId);
	
}
