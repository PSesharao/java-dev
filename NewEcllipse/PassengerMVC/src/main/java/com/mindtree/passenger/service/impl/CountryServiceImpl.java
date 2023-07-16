package com.mindtree.passenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.passenger.dto.CountryDto;
import com.mindtree.passenger.entity.Country;
import com.mindtree.passenger.exception.daoexception.CountryAlreadyExistsException;
import com.mindtree.passenger.exception.serviceexception.CountryServiceException;
import com.mindtree.passenger.repository.CountryRepository;
import com.mindtree.passenger.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country createCountry(CountryDto countryDto) throws CountryServiceException {
		if (countryRepository.findById(countryDto.getName()).orElse(null) != null)
			throw new CountryAlreadyExistsException(
					"The country " + "'" + countryDto.getName() + "'" + " already exists in database");
		Country country = new Country();
		country.setName(countryDto.getName());
		return countryRepository.save(country);
	}

}
