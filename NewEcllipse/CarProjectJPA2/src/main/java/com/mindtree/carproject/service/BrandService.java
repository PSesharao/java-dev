package com.mindtree.carproject.service;

import java.util.List;

import com.mindtree.carproject.dto.BrandDto;
import com.mindtree.carproject.dto.SoldModel;
import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.entity.Brand;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.exception.serviceexception.BrandServiceException;

public interface BrandService {
	Brand createBrand(BrandDto brandDto) throws BrandServiceException;

	SoldModel sellModel(ModelColorKey modelColorKey ,  String brandName) throws BrandServiceException;
	
	List<Model> getModelsByBrand(String brandName)throws BrandServiceException;
	
	List<Model> getModelsOnColor( String brandName, String color) throws BrandServiceException;
}
