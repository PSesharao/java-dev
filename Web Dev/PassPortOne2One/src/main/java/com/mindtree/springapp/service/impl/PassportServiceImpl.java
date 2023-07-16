package com.mindtree.springapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springapp.entity.Passport;
import com.mindtree.springapp.repository.PassportRepository;
import com.mindtree.springapp.service.PassportService;

@Service
public class PassportServiceImpl implements PassportService {
	@Autowired
	private PassportRepository passportRepository;

	@Override
	public Passport addpassport(Passport passport) {

		return passportRepository.save(passport);
	}

	@Override
	public Passport getPassportById(String passId) {

		return passportRepository.findById(passId)
				.orElse(null);
				//.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + passId));
	}

	@Override
	public Passport updatePassport(String passId) {

		return null;
	}

}
