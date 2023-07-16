package com.mindtree.passenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.passenger.dto.CountryDto;
import com.mindtree.passenger.entity.Country;
import com.mindtree.passenger.exception.globalexception.CountryException;
import com.mindtree.passenger.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	@ResponseBody
	@RequestMapping(value = "/createCountry")
	public Country createCountry(CountryDto countryDto) throws CountryException
	{
		return countryService.createCountry(countryDto);
	}
	
	@RequestMapping(value = "/country")
	public String country()
	{
		return "country";
	}
}
