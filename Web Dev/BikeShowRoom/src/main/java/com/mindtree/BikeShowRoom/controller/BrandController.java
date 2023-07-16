package com.mindtree.BikeShowRoom.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.BikeShowRoom.dto.BrandDto;
import com.mindtree.BikeShowRoom.exception.BrandException;
import com.mindtree.BikeShowRoom.service.BrandService;

@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@PostMapping("/addbrand")
	public ResponseEntity<Map<String, Object>> addBrand(@RequestBody BrandDto brandDto) throws BrandException
	{
		Map<String, Object> response = new LinkedHashMap<>();
		brandService.createBrand(brandDto);
		response.put("Header", "BikeShowRoomProject");
		response.put("Error", false);
		response.put("message :", brandDto);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);	
	}
	
	
}
