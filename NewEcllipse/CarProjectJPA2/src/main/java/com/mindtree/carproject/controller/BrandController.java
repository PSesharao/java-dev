package com.mindtree.carproject.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.carproject.dto.BrandDto;
import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.exception.globalexception.BrandException;
import com.mindtree.carproject.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	private BrandService brandService;

	@PostMapping("/createbrand")
	public ResponseEntity<Map<String, Object>> createBrand(@RequestBody BrandDto brandDto) throws BrandException{
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", brandService.createBrand(brandDto));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/soldModels/{brandName}")
	public ResponseEntity<Map<String, Object>> soldModels(@RequestBody ModelColorKey modelColorKey,
			@PathVariable(value = "brandName") String brandName) throws BrandException{
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", brandService.sellModel(modelColorKey, brandName));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getModels/{brandName}")
	public ResponseEntity<Map<String, Object>> getModels(
			@PathVariable(value = "brandName") String brandName) throws BrandException{
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", brandService.getModelsByBrand( brandName));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getModels/{brandName}/{color}")
	public ResponseEntity<Map<String, Object>> getModelsOnColor(
			@PathVariable(value = "brandName") String brandName,@PathVariable(value = "color") String color) throws BrandException{
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", brandService.getModelsOnColor( brandName,color));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	

}
