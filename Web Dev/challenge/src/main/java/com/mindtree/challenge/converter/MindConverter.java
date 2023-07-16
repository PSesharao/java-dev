package com.mindtree.challenge.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.challenge.dto.MindDto;
import com.mindtree.challenge.entity.Mind;

@Component
public class MindConverter {
	public MindDto entityToDto (Mind mind)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(mind, MindDto.class);
	}
	
	public Mind dtoToEntity(MindDto minddto)
	{
		ModelMapper mapper = new ModelMapper();
		return mapper.map(minddto, Mind.class);
	}
	
	
}
