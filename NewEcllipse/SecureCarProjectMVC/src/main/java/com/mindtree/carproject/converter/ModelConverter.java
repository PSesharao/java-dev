package com.mindtree.carproject.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.carproject.dto.ModelDto;
import com.mindtree.carproject.entity.Model;

@Component
public class ModelConverter {
	public ModelDto entityToDto( Model brand) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brand, ModelDto.class);
	}

	public  Model dtoToEntity(ModelDto brandDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(brandDto,  Model.class);

	}
}
