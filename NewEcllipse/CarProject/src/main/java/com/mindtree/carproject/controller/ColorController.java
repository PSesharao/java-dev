package com.mindtree.carproject.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.carproject.dto.ColorDto;
import com.mindtree.carproject.exception.globalexception.ColorException;
import com.mindtree.carproject.service.ColorService;

@RestController
public class ColorController {
	@Autowired
	private ColorService colorService;

	@PostMapping("/createcolor")
	public ResponseEntity<Map<String, Object>> createcolor(@RequestBody ColorDto colorDto) throws ColorException{
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "CarProject");
		response.put("Error", false);
		response.put("message :", colorService.createColor(colorDto));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
