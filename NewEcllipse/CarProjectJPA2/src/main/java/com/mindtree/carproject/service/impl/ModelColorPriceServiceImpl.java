package com.mindtree.carproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.carproject.dto.ModelColorDto;
import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.entity.Color;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.entity.ModelColor;
import com.mindtree.carproject.exception.daoexception.ModelColorPairAlreadyExistsException;
import com.mindtree.carproject.exception.daoexception.ResourceNotFoundException;
import com.mindtree.carproject.exception.serviceexception.ModelColorPriceServiceException;
import com.mindtree.carproject.repository.ColorRepository;
import com.mindtree.carproject.repository.ModelColorRepository;
//import com.mindtree.carproject.repository.ModelColorRepository;
import com.mindtree.carproject.repository.ModelRepository;
import com.mindtree.carproject.service.ModelColorPriceService;

@Service
public class ModelColorPriceServiceImpl implements ModelColorPriceService {
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private ColorRepository colorRepository;

	@Autowired
	private ModelColorRepository modelColorRepository;

	@Override
	public List<ModelColor> assignColorAndPrice(List<ModelColorDto> modelColorDtoList)
			throws ModelColorPriceServiceException {
		List<ModelColor> modelColorList = new ArrayList<>();
		for (ModelColorDto modelColorDto : modelColorDtoList) {

			Model model;
			try {
				model = modelRepository.findById(modelColorDto.getModel()).orElseThrow(
						() -> new ResourceNotFoundException("No Model Exists with name " + modelColorDto.getModel()));
			} catch (ResourceNotFoundException e1) {
				throw new ModelColorPriceServiceException(e1.getLocalizedMessage());
			}
			Color color;
			try {
				color = colorRepository.findById(modelColorDto.getColor()).orElseThrow(
						() -> new ResourceNotFoundException("No Color Exists with name " + modelColorDto.getColor()));
			} catch (ResourceNotFoundException e) {
				throw new ModelColorPriceServiceException(e.getLocalizedMessage());
			}

			ModelColorKey key = new ModelColorKey();
			key.setColor(modelColorDto.getColor());
			key.setModel(modelColorDto.getModel());

			if (modelColorRepository.findById(key).orElse(null) != null) {
				//System.out.println(modelColorRepository.findById(key));
				throw new ModelColorPairAlreadyExistsException(
						"The Model Color key Pair " + key+" already exists in database ");
			}
			double price = modelColorDto.getPrice();
			ModelColor modelColor = new ModelColor();
			modelColor.setKey(key);
			modelColor.setColor(color);
			modelColor.setModel(model);
			modelColor.setPrice(price);
			modelColorList.add(modelColor);
			model.getColourList().add(modelColor);
			color.getModelList().add(modelColor);
			colorRepository.save(color);
			modelRepository.save(model);
			modelColorRepository.save(modelColor);
		}
		return modelColorList;
	}

}
