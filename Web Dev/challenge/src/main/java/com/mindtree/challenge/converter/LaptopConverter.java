package com.mindtree.challenge.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.challenge.dto.LaptopDto;
import com.mindtree.challenge.entity.Laptop;


@Component
public class LaptopConverter {
	public LaptopDto entityToDto (Laptop laptop)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(laptop, LaptopDto.class);
	}
	
	public Laptop dtoToEntity(LaptopDto laptopdto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(laptopdto, Laptop.class);
	}
	
}
