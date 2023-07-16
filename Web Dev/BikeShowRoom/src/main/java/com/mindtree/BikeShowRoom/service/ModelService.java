package com.mindtree.BikeShowRoom.service;

import java.util.List;

import com.mindtree.BikeShowRoom.dto.ModelDto;
import com.mindtree.BikeShowRoom.entity.Model;
import com.mindtree.BikeShowRoom.exception.serviceexception.ModelServiceException;

public interface ModelService {

	public Model createModel(ModelDto modelDto, String brandName) throws ModelServiceException;

	public List<Model> getModelsByBrand(String brandName) throws ModelServiceException;
	
	public double getTotalRevenueOfBrand(String brandName) throws ModelServiceException;
	
	public List<Model> sortmodelsByPrice(List<Model> modelList ) throws ModelServiceException;
	
	public int findCountOfModel(String modelName) throws ModelServiceException ;
	
}
