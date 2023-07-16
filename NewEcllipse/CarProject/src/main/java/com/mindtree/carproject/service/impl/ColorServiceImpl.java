package com.mindtree.carproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.carproject.dto.ColorDto;
import com.mindtree.carproject.entity.Color;
import com.mindtree.carproject.exception.daoexception.ColorAlreadyExistsException;
import com.mindtree.carproject.exception.serviceexception.ColorServiceException;
import com.mindtree.carproject.repository.ColorRepository;
import com.mindtree.carproject.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public Color createColor(ColorDto colorDto) throws ColorServiceException {
		if (colorRepository.findById(colorDto.getName()).orElse(null) != null)
			throw new ColorAlreadyExistsException(
					"The color " + colorDto.getName() +  " already exists in the database");
		Color color = new Color();
		color.setName(colorDto.getName());
		return colorRepository.save(color);
	}

}
