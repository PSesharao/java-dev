package com.mindtree.dropdownmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mindtree.dropdownmvc.entity.City;
import com.mindtree.dropdownmvc.entity.Country;
import com.mindtree.dropdownmvc.repository.CityRepository;
import com.mindtree.dropdownmvc.repository.CountryRepository;

@Controller

public class CityController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository ;
	
	@RequestMapping("/home")
	public String home() {
		return "frame";
	}
	
	@RequestMapping("/bottom")
	public String bottom() {
		return "bottom";
	}

	@RequestMapping("/navtabs")
	public String navtabs() {
		return "navtabs";
	}

	@RequestMapping("/country")
	public String country() {
		return "country";
	}

	
	/*
	 * @RequestMapping("/addcountry") public String addcountry(Country country) {
	 * countryRepository.save(country); return "bottom"; }
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "addcountry" , method = RequestMethod.POST, produces = "application/json")
	public String addcountry(@RequestBody Country country) {
		//Country country1 = new Country();
		//country1.setCountryName(country.getCountryName());
		countryRepository.save(country);
		return "bottom";
	}
	
	
	@RequestMapping("/city")
	public ModelAndView city() {
		
		ModelAndView mv = new ModelAndView("city");
		mv.addObject("countryList", countryRepository.findAll());
		return mv;
		
	}
	
	
	@RequestMapping("/addcity")
	public String addcity(City city , @RequestParam("countryName") String countryName) {
		Country country = countryRepository.findById(countryName).orElse(null);
		city.setCountry(country);
		country.getCityList().add(city);
		cityRepository.save(city);
		return "bottom";
	}
	


	
	@RequestMapping("/show")
	public ModelAndView show() {
		
		ModelAndView mv = new ModelAndView("show");
		mv.addObject("countryList", countryRepository.findAll());
		//mv.addObject("cityList", cityRepository.findAll());
		return mv;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "loadCitiesByState/{countryName}")
	public String getCitiesByCountry(@PathVariable("countryName") String countryName)
	{
		 
		 Country country= countryRepository.findById(countryName).orElse(null);
		 List<City> cityList = country.getCityList();
		 List<String> cityNames = new ArrayList<>();
		
		 for(City city : cityList)
		 {
			 cityNames.add(city.getCityName());
		 }
		 Gson gson = new Gson();
		 return gson.toJson(cityNames);
	}

}
