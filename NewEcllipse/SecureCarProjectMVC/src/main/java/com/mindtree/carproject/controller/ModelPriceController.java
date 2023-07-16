package com.mindtree.carproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.carproject.dto.ModelColorDto;
import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.entity.ModelColor;
import com.mindtree.carproject.exception.globalexception.ModelColorException;
import com.mindtree.carproject.exception.serviceexception.BrandServiceException;
import com.mindtree.carproject.repository.ModelColorRepository;
import com.mindtree.carproject.service.BrandService;
import com.mindtree.carproject.service.ModelColorPriceService;

@Controller
public class ModelPriceController {
	@Autowired
	private ModelColorPriceService modelColorPriceService;
	@Autowired
	private ModelColorRepository modelColorRepository;
	@Autowired
	private BrandService brandService;
	@ResponseBody
	@RequestMapping("/assignColorAndPrice")
	public ModelColor assignColorAndPrice(ModelColorDto modelColorDto) throws ModelColorException {

		/*
		 * System.out.println(modelColorDto.getColor());
		 * System.out.println(modelColorDto.getModel());
		 * System.out.println(modelColorDto.getPrice()); return null;
		 */

		 return modelColorPriceService.assignColorAndPrice(modelColorDto);
	}

	@ResponseBody
	@RequestMapping("/getModelAndColor/{model}/{color}")
	public ModelColor getModelAndColor(@PathVariable(value = "model") String model,
			@PathVariable(value = "color") String color) {
		ModelColorKey key = new ModelColorKey(color, model);
		return modelColorRepository.findById(key).orElse(null);
	}
	
	@ResponseBody
	@RequestMapping("/deleteModelAndColor/{model}/{color}")
	public ModelColor deleteModelAndColor(@PathVariable(value = "model") String model,
			@PathVariable(value = "color") String color) {
		ModelColorKey key = new ModelColorKey(color, model);
		ModelColor modelColor = modelColorRepository.findById(key).orElse(null);
	    modelColorRepository.deleteById(key);
		return modelColor;
	}
	
	@ResponseBody
	@RequestMapping("/getModelAndColorList/{modelList}/{colorList}")
	public List<ModelColor> getModelAndColorList(@PathVariable(value = "modelList") List<String> modelList,
			@PathVariable(value = "colorList") List<String> colorList) {
		//System.out.println(modelList);
		//System.out.println(colorList);
		 List<ModelColor> list = new ArrayList<>();
		for(int i=0;i<modelList.size();i++) {
		ModelColorKey key = new ModelColorKey(colorList.get(i), modelList.get(i));
		list.add(modelColorRepository.findById(key).orElse(null));
		}
		//return modelColorRepository.findById(key).orElse(null);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/sell/{modelList}/{colorList}/{brandName}")
	public List<ModelColor> sell(@PathVariable(value = "modelList") List<String> modelList,
			@PathVariable(value = "colorList") List<String> colorList , @PathVariable(value = "brandName") String brandName) throws  BrandServiceException{
		System.out.println(modelList);
		System.out.println(colorList);
		System.out.println(brandName);
		List<ModelColor> list = new ArrayList<>();
		for(int i=0;i<modelList.size();i++) {
		ModelColorKey key = new ModelColorKey(colorList.get(i), modelList.get(i));
		brandService.sellModel(key, brandName);
		list.add(modelColorRepository.findById(key).orElse(null));
		}
		//return modelColorRepository.findById(key).orElse(null);
		return list;
	}

}
