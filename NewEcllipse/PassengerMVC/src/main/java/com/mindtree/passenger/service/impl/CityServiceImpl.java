package com.mindtree.passenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.passenger.dto.CityDto;
import com.mindtree.passenger.entity.City;
import com.mindtree.passenger.entity.Country;
import com.mindtree.passenger.exception.daoexception.CityAlreadyExistsException;
import com.mindtree.passenger.exception.serviceexception.CityServiceException;
import com.mindtree.passenger.repository.CityRepository;
import com.mindtree.passenger.repository.CountryRepository;
import com.mindtree.passenger.service.CityService;

public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public City addCity(CityDto cityDto) throws CityServiceException {
		if (cityRepository.findById(cityDto.getName()).orElse(null) != null)
			throw new CityAlreadyExistsException(
					"The city " + "'" + cityDto.getName() + "'" + " already exists in database");
		City city = new City();
		city.setName(cityDto.getName());
		Country country = countryRepository.findById(cityDto.getCountryname()).orElse(null);
		country.getCityList().add(city);
		city.setCountry(country);
		return cityRepository.save(city);
	}

}
