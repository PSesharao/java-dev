package com.mindtree.carproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.carproject.dto.BrandDto;
import com.mindtree.carproject.dto.SoldModel;
import com.mindtree.carproject.entity.Brand;
import com.mindtree.carproject.exception.globalexception.BrandException;
import com.mindtree.carproject.repository.BrandRepository;
import com.mindtree.carproject.service.BrandService;

@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private BrandRepository brandRepository;

	@ResponseBody
	@RequestMapping(value = "/createbrand")
	public Brand addCategory(BrandDto brandDto) throws BrandException {
		return brandService.createBrand(brandDto);
	}

	@ResponseBody
	@RequestMapping(value = "/getBrands")
	public List<Brand> getBrands() throws BrandException {
		return brandRepository.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/getSoldItems/{brandName}/{model}/{color}")
	public List<SoldModel> getSoldItemsByBrand(@PathVariable(value = "brandName") String brandName,
			@PathVariable(value = "model") String model, @PathVariable(value = "color") String color)
			throws BrandException {
		List<SoldModel> list = brandRepository.findByName(brandName).get().getSoldModels();
		list = list
		.stream().
		filter(item -> item.getModelColorKey().getColor().equals(color) && item.getModelColorKey().getModel().equals(model))
		.collect(Collectors.toList());
		return list;
		 
	}

}
