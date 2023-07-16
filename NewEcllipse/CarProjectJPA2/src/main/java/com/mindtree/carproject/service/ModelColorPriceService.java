package com.mindtree.carproject.service;

import java.util.List;

import com.mindtree.carproject.dto.ModelColorDto;
import com.mindtree.carproject.entity.ModelColor;
import com.mindtree.carproject.exception.serviceexception.ModelColorPriceServiceException;

public interface ModelColorPriceService {
	List<ModelColor> assignColorAndPrice(List<ModelColorDto> modelColorDtoList) throws ModelColorPriceServiceException;
}
