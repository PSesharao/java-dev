package com.mindtree.bikemvc.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.bikemvc.dto.ModelDto;
import com.mindtree.bikemvc.entity.Model;


@Component
public class ModelConverter {
	public ModelDto entityToDto(Model model) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(model, ModelDto.class);
	}

	public Model dtoToEntity(ModelDto modelDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(modelDto, Model.class);

	}
}
