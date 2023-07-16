package com.mindtree.carproject.service;

import java.util.List;

import com.mindtree.carproject.dto.ModelColorDto;
import com.mindtree.carproject.entity.ModelColor;
import com.mindtree.carproject.exception.serviceexception.ModelColorPriceServiceException;

public interface ModelColorPriceService {
	ModelColor assignColorAndPrice(ModelColorDto modelColorDto) throws ModelColorPriceServiceException;
}
