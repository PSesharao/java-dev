package com.mindtree.springapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.springapp.entity.Hospital;
import com.mindtree.springapp.exception.ResourceNotFoundException;
import com.mindtree.springapp.exception.serviceexception.HospitalServiceException;
import com.mindtree.springapp.repository.HospitalRepository;
import com.mindtree.springapp.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

	public Hospital getHospitalByID(int hospitalId) throws HospitalServiceException{
		try {
			return this.hospitalRepository.findById(hospitalId).orElseThrow(() -> new ResourceNotFoundException("Hospital not found with id :" + hospitalId));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new HospitalServiceException(e);
		}
		//.orElseThrow(() -> new ResourceNotFoundException("Hospital not found with id :" + hospitalId));

	}

	public Hospital createHospital(Hospital hospital) {
		 return this.hospitalRepository.save(hospital);
	}

	public Hospital updateHospital(String hospitalId) {
		return null;
	}

	public ResponseEntity<Hospital> deleteHospital(String hospitalId) {
		return null;

	}

}
