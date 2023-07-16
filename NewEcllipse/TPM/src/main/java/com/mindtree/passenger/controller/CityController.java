package com.mindtree.passenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.passenger.dto.CityDto;
import com.mindtree.passenger.entity.City;
import com.mindtree.passenger.repository.CityRepository;

@Controller
public class CityController {
	@Autowired
	private CityRepository cityRepository;

	@ResponseBody
	@RequestMapping("/createCity")
	public City registeruser(CityDto cityDto) {
		City city = new City();
		city.setCity(cityDto.getCity());
		return cityRepository.save(city);

	}
	
	@ResponseBody
	@RequestMapping("/getCities")
	public List<City> getCities() {
		
		return cityRepository.findAll();

	}
}
