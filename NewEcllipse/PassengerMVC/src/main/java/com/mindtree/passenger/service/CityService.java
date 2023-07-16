package com.mindtree.passenger.service;

import com.mindtree.passenger.dto.CityDto;
import com.mindtree.passenger.entity.City;
import com.mindtree.passenger.exception.serviceexception.CityServiceException;

public interface CityService {
	City addCity(CityDto cityDto) throws CityServiceException;
}
