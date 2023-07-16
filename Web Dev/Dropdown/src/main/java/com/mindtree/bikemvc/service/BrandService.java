package com.mindtree.bikemvc.service;

import java.util.List;

import com.mindtree.bikemvc.dto.BrandDto;
import com.mindtree.bikemvc.entity.Brand;
import com.mindtree.bikemvc.exception.serviceexception.BrandServiceException;

public interface BrandService {
	
	public Brand createBrand(BrandDto brandDto) throws BrandServiceException;
	
	public Brand getBrandByName(String brandName)throws BrandServiceException;
	
	public List<Brand> getAllBrands() throws BrandServiceException;

}
