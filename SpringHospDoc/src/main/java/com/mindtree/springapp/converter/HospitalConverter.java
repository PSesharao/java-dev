package com.mindtree.springapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springapp.dto.HospitalDto;
import com.mindtree.springapp.entity.Hospital;

@Component
public class HospitalConverter {
	public HospitalDto entityToDto (Hospital hospital)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(hospital, HospitalDto.class);
	}
	
	public Hospital dtoToEntity(HospitalDto hospitaldto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(hospitaldto, Hospital.class);
	}
	
}
