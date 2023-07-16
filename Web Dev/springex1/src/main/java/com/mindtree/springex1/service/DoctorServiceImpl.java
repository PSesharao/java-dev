package com.mindtree.springex1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springex1.entity.Doctor;
import com.mindtree.springex1.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctorByName(String doctorname) {
		
		return doctorRepository.findByName(doctorname);
	}

}
