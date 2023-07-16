package com.mindtree.carproject.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.carproject.dto.ModelDto;
import com.mindtree.carproject.exception.globalexception.ModelException;
import com.mindtree.carproject.service.ModelService;

@RestController
public class ModelController {
	@Autowired
	private ModelService modelService;

	@PostMapping("/addmodel/{brandName}")
	public ResponseEntity<Map<String, Object>> createModel(@RequestBody List<ModelDto> modelList,
			@PathVariable(value = "brandName") String brandName) throws ModelException {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", modelService.addModels(modelList, brandName));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
