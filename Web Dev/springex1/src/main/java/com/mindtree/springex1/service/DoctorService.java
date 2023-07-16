package com.mindtree.springex1.service;

import com.mindtree.springex1.entity.Doctor;

public interface DoctorService {
	public Doctor createDoctor(Doctor doctor);
	public Doctor getDoctorByName(String doctorname);
}
