package com.mindtree.springapp.service;

import java.util.List;

import com.mindtree.springapp.entity.Doctor;
import com.mindtree.springapp.exception.serviceexception.DoctorServiceException;

public interface DoctorService {
	
	
	public Doctor createDoctor(Doctor doctor) throws DoctorServiceException;
	
	public Doctor getDoctorOnDocId(int doctorId) throws DoctorServiceException;
	
	public List<Doctor> getAllDoctors() throws DoctorServiceException;
	
}
