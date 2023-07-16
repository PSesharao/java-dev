package com.mindtree.challenge.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.challenge.converter.LaptopConverter;
import com.mindtree.challenge.dto.LaptopDto;
import com.mindtree.challenge.entity.Laptop;
import com.mindtree.challenge.entity.Mind;
import com.mindtree.challenge.exception.ResourceNotFoundException;
import com.mindtree.challenge.service.LaptopService;
import com.mindtree.challenge.service.MindService;

@RestController
public class LaptopController {

	@Autowired
	private LaptopService laptopService;

	@Autowired
	private MindService mindService;

	@Autowired
	private LaptopConverter laptopConverter;

	@PutMapping("updatelap/{id},{name}")
	public ResponseEntity<Map<String, Object>> updateLaptop(@PathVariable(value = "id") long serno,
			@PathVariable(value = "name") String bname) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "LaptopProject");
		Laptop laptop = laptopService.updateLaptop(serno, bname);
		if (laptop == null) {
			response.put("message :",
					new ResourceNotFoundException("No laptop found with  :" + serno).getLocalizedMessage());
			response.put("Error", true);
			response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		} else {
			response.put("Error", false);
			response.put("message :",  laptopConverter.entityToDto(laptop));
			response.put("HttpRequest ", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/addlap/{mid}")
	public ResponseEntity<Map<String, Object>> addLaptop(@PathVariable(value = "mid") int mid,
			@RequestBody LaptopDto lapDto) {
		Laptop laptop = laptopConverter.dtoToEntity(lapDto);
		Mind mind = mindService.findMindById(mid);
		Map<String, Object> response = new LinkedHashMap<>();
		if (mind == null) {
			response.put("message :",
					new ResourceNotFoundException("Mind not found with id :" + mid).getLocalizedMessage());
			response.put("Error", true);
			response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		} else {
			laptop.setMind(mind);
			laptopService.createLaptop(laptop);
			mind.setLaptop(laptop);
			response.put("Error", false);
			response.put("message :", laptopConverter.entityToDto(laptop));
			response.put("HttpRequest ", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
