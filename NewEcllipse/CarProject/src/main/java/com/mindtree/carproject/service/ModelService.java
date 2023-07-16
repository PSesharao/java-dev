package com.mindtree.carproject.service;

import java.util.List;

import com.mindtree.carproject.dto.ModelDto;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.exception.serviceexception.ModelServiceException;

public interface ModelService {
	List<Model> addModels(List<ModelDto> modelList , String brandName) throws ModelServiceException;
}
