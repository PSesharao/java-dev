package com.mindtree.carproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.carproject.dto.ColorDto;
import com.mindtree.carproject.entity.Color;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.entity.ModelColor;
import com.mindtree.carproject.exception.globalexception.ColorException;
import com.mindtree.carproject.repository.ColorRepository;
import com.mindtree.carproject.repository.ModelRepository;
import com.mindtree.carproject.service.ColorService;

@Controller
public class ColorController {
	@Autowired
	private ColorService colorService;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private ModelRepository modelRepository;

	

	@ResponseBody

	@RequestMapping(value = "/createcolor")

	public Color addColor(ColorDto colorDto) throws ColorException {

		return colorService.createColor(colorDto);
	}

	@ResponseBody
	@RequestMapping(value = "/getColors")
	public List<Color> getColors() throws ColorException {
		return colorRepository.findAll();
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/getColorsByModel/{modelName}") public List<Color>
	 * getColorsByModel(@PathVariable(value = "modelName") String modelName) { Model
	 * model = modelRepository.findById(modelName).orElse(null); List<Color>
	 * colorList = new ArrayList<>(); for (ModelColor modelColor :
	 * model.getColourList()) { colorList.add(modelColor.getColor()); } return
	 * colorList;
	 * 
	 * }
	 */

	@ResponseBody
	@RequestMapping(value = "/getColorsByModel/{modelName}")
	public List<ModelColor> getColorsByModel(@PathVariable(value = "modelName") String modelName) {
		Model model = modelRepository.findById(modelName).orElse(null);
		return model.getColourList();

	}

}
