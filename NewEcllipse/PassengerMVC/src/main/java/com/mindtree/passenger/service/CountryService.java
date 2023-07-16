package com.mindtree.passenger.service;

import com.mindtree.passenger.dto.CountryDto;
import com.mindtree.passenger.entity.Country;
import com.mindtree.passenger.exception.serviceexception.CountryServiceException;

public interface CountryService {
	Country createCountry(CountryDto countryDto) throws CountryServiceException;
}
