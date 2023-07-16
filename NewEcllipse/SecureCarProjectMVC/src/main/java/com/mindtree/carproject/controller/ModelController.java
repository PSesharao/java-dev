package com.mindtree.carproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.carproject.dto.ModelDto;
import com.mindtree.carproject.entity.Brand;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.exception.daoexception.ResourceNotFoundException;
import com.mindtree.carproject.exception.globalexception.ModelException;
import com.mindtree.carproject.repository.BrandRepository;
import com.mindtree.carproject.service.ModelColorPriceService;
import com.mindtree.carproject.service.ModelService;

@Controller
public class ModelController {
	@Autowired
	private ModelService modelService;
	@Autowired
	
	private BrandRepository brandRepository;

	

	/*
	 * try { modelColorPriceService.assignColorAndPrice(modelColorDto); } catch
	 * (ModelColorPriceServiceException e) { throw new
	 * ModelException(e.getLocalizedMessage()); } return model;
	 */
	

	@ResponseBody
	@RequestMapping(value = "/addModel/{brandName}")
	public Model addModel(ModelDto modelDto, @PathVariable(value = "brandName") String brandName)
			throws ModelException {
		//return new Model();
		return modelService.addModels(modelDto, brandName);
	}

	@ResponseBody
	@RequestMapping(value = "/getModelsByBrand/{brandName}")
	public List<Model> getModelsByBrand(@PathVariable(value = "brandName") String brandName) throws ModelException {
		Brand brand;
		try {
			brand = brandRepository.findByName(brandName)
					.orElseThrow(() -> new ResourceNotFoundException("No Brand Exists with name " + brandName));
		} catch (ResourceNotFoundException e) {
			throw new ModelException(e.getLocalizedMessage());
		}
		return brand.getModelList();
	}
}
