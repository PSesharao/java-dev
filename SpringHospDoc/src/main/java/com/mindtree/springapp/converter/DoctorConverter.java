package com.mindtree.springapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springapp.dto.DoctorDto;
import com.mindtree.springapp.entity.Doctor;
@Component
public class DoctorConverter {
	public DoctorDto entityToDto(Doctor doctor) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(doctor, DoctorDto.class);
	}

	public Doctor dtoToEntity(DoctorDto doctordto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(doctordto, Doctor.class);
	}
}
