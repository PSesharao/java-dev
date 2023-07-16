package com.mindtree.bikemvc.service;

import java.util.List;

import com.mindtree.bikemvc.dto.ModelDto;
import com.mindtree.bikemvc.entity.Model;
import com.mindtree.bikemvc.exception.serviceexception.ModelServiceException;



public interface ModelService {

	public Model createModel(ModelDto modelDto, String brandName) throws ModelServiceException;

	public List<Model> getModelsByBrand(String brandName) throws ModelServiceException;
	
	public double getTotalRevenueOfBrand(String brandName) throws ModelServiceException;
	
	public List<Model> sortmodelsByPrice(List<Model> modelList ) throws ModelServiceException;
	
	public int findCountOfModel(String modelName) throws ModelServiceException ;
	
}
