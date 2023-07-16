package com.mindtree.BikeShowRoom.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.BikeShowRoom.converter.ModelConverter;
import com.mindtree.BikeShowRoom.dto.ModelDto;
import com.mindtree.BikeShowRoom.entity.Model;
import com.mindtree.BikeShowRoom.exception.ModelException;
import com.mindtree.BikeShowRoom.exception.serviceexception.ModelServiceException;
import com.mindtree.BikeShowRoom.service.ModelService;

@Controller
public class ModelController {

	@Autowired
	private ModelConverter modelConverter;

	@Autowired
	private ModelService modelService;

	@PostMapping("/addmodel/{name}")
	public ResponseEntity<Map<String, Object>> addModel(@RequestBody List<ModelDto> modelDtoList,
			@PathVariable(value = "name") String brandName) throws ModelException {
		Map<String, Object> response = new LinkedHashMap<>();

		for (ModelDto modelDto : modelDtoList) {
			try {
				modelService.createModel(modelDto, brandName);
			} catch (ModelServiceException e) {
				throw new ModelException(e.getLocalizedMessage());
			}
		}
		response.put("Header", "BikeShowRoomProject");
		response.put("Error", false);
		response.put("message :", modelDtoList);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/getmodel/{name}")
	public ResponseEntity<Map<String, Object>> getModels(@PathVariable(value = "name") String brandName)
			throws ModelException {
		Map<String, Object> response = new LinkedHashMap<>();
		List<Model> modelList = modelService.getModelsByBrand(brandName);
		modelList = modelService.sortmodelsByPrice(modelList);
		double totalRevenue = modelService.getTotalRevenueOfBrand(brandName);
		
		Set<String> modelNameList = new LinkedHashSet<>();
		List<ModelDto> modelDtoList = new ArrayList<>();
		
		for (Model model : modelList){
			modelDtoList.add(modelConverter.entityToDto(model));
			modelNameList.add(model.getName());
		}
		
		Map<String, Integer> modelCountMap = new LinkedHashMap<>();
		
		for(String modelName : modelNameList)
		{
			modelCountMap.put(modelName, modelService.findCountOfModel(modelName));
		}
		
		response.put("Header", "BikeShowRoomProject");
		response.put("Error", false);
		response.put("modelList ", modelDtoList);
		response.put("modelCount ",modelCountMap);
		response.put("totalRevenue ", totalRevenue);
		response.put("HttpRequest ", HttpStatus.ACCEPTED);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
