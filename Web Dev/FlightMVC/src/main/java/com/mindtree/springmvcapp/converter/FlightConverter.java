package com.mindtree.springmvcapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springmvcapp.dto.FlightDto;
import com.mindtree.springmvcapp.entity.Flight;
@Component
public class FlightConverter {
	public FlightDto entityToDto(Flight flight)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(flight , FlightDto.class);
	}
	
	public Flight dtoToEntity(FlightDto flightDto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(flightDto , Flight.class);
		
	}
}
