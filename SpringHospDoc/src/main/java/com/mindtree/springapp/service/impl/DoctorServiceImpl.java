package com.mindtree.springapp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.springapp.entity.Doctor;
import com.mindtree.springapp.exception.ResourceNotFoundException;
import com.mindtree.springapp.exception.serviceexception.DoctorServiceException;
import com.mindtree.springapp.repository.DoctorRepository;
import com.mindtree.springapp.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctors() throws DoctorServiceException {
		return this.doctorRepository.findAll();
	}

	public Doctor getDoctorOnDocId(int doctorId) throws DoctorServiceException {
		try {
			return this.doctorRepository.findById(doctorId)
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id :" + doctorId));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new DoctorServiceException(e);
		}
		
		
		// .orElseThrow(() -> new ResourceNotFoundException("Doctor not found
		// with id :" + doctorId));
	}

	public Doctor createDoctor(Doctor doctor) throws DoctorServiceException {

		return this.doctorRepository.save(doctor);
	}

}
