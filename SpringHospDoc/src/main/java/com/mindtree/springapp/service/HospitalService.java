package com.mindtree.springapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mindtree.springapp.entity.Hospital;
import com.mindtree.springapp.exception.serviceexception.HospitalServiceException;

public interface HospitalService {
	public List<Hospital> getAllHospitals() throws HospitalServiceException;

	public Hospital getHospitalByID(int hospitalId) throws HospitalServiceException;

	public Hospital createHospital(Hospital hospital) throws HospitalServiceException;

	public Hospital updateHospital(String hospitalId) throws HospitalServiceException;

	public ResponseEntity<Hospital> deleteHospital(String hospitalId) throws HospitalServiceException;
}
