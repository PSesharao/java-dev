package com.mindtree.challenge.controller;

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

import com.mindtree.challenge.converter.MindConverter;
import com.mindtree.challenge.dto.MindDto;
import com.mindtree.challenge.entity.Mind;
import com.mindtree.challenge.exception.ResourceNotFoundException;
import com.mindtree.challenge.service.MindService;

@RestController
public class MindController {
	@Autowired
	private MindConverter mindConverter;

	@Autowired
	private MindService mindService;

	

	/*
	 * @PostMapping public ResponseEntity<Map<String, Object>>
	 * addMind(@RequestBody MindDto mindDto) { Mind mind =
	 * mindConverter.dtoToEntity(mindDto); mindService.createMind(mind); Laptop
	 * laptop = mind.getLaptop(); laptop.setMind(mind);
	 * laptopService.createLaptop(laptop); Map<String, Object> response = new
	 * LinkedHashMap<>(); response.put("Header", "LaptopProject");
	 * response.put("Error", false); response.put("message :",
	 * mindConverter.entityToDto(mind)); response.put("HttpRequest ",
	 * HttpStatus.ACCEPTED); return new ResponseEntity<Map<String,
	 * Object>>(response, HttpStatus.OK);
	 * 
	 * }
	 */

	@GetMapping("/get/{id}")
	public ResponseEntity<Map<String, Object>> getMindById(@PathVariable(value = "id") int mid) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "LaptopProject");

		Mind mind = mindService.findMindById(mid);

		if (mind == null) {
			response.put("message :", new ResourceNotFoundException("Mind not found with id :" + mid).getLocalizedMessage());
					
			response.put("Error", true);
			response.put("HttpRequest ", HttpStatus.BAD_REQUEST);
		} else {
			response.put("Error", false);
			response.put("message :", mindConverter.entityToDto(mind));
			response.put("HttpRequest ", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/addmind")
	public ResponseEntity<Map<String, Object>> addMind(@RequestBody MindDto mindDto) {
		Mind mind = mindConverter.dtoToEntity(mindDto);
		mindService.createMind(mind);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("Header", "LaptopProject");
		response.put("Error", false);
		response.put("message :", mindConverter.entityToDto(mind));
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
