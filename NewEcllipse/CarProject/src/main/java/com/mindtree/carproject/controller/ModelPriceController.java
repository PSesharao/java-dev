package com.mindtree.carproject.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.carproject.dto.ModelColorDto;
import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.exception.globalexception.ModelColorException;
import com.mindtree.carproject.repository.ModelColorRepository;
import com.mindtree.carproject.service.ModelColorPriceService;

@RestController
public class ModelPriceController {
	@Autowired
	private ModelColorPriceService modelColorPriceService;
	@Autowired
	private ModelColorRepository modelColorRepository;
	@PostMapping("/assignColorAndPrice")
	public ResponseEntity<Map<String, Object>> assignColorAndPrice(@RequestBody List<ModelColorDto> modelColorDtoList)
			throws ModelColorException {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", modelColorPriceService.assignColorAndPrice(modelColorDtoList));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getModelColorPricePair")
	public  ResponseEntity<Map<String, Object>> getModelColorPricePair(@RequestBody ModelColorKey modelColorKey) throws ModelColorException
	{
		System.out.println(modelColorKey);
		ModelColorKey key = new ModelColorKey();
		key.setColor(modelColorKey.getColor());
		key.setModel(modelColorKey.getModel());
		System.out.println(key);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		System.out.println(modelColorRepository.findById(key).get());
		response.put("message :", modelColorRepository.findById(key));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
