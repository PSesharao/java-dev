package com.mindtree.carproject.service;

import com.mindtree.carproject.dto.ColorDto;
import com.mindtree.carproject.entity.Color;
import com.mindtree.carproject.exception.serviceexception.ColorServiceException;

public interface ColorService {
	Color createColor(ColorDto colorDto) throws ColorServiceException;
}
