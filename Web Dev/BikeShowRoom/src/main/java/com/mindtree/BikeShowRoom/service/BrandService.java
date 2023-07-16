package com.mindtree.BikeShowRoom.service;

import com.mindtree.BikeShowRoom.dto.BrandDto;
import com.mindtree.BikeShowRoom.entity.Brand;
import com.mindtree.BikeShowRoom.exception.serviceexception.BrandServiceException;

public interface BrandService {
	
	public Brand createBrand(BrandDto brandDto) throws BrandServiceException;
	
	public Brand getBrandByName(String brandName)throws BrandServiceException;

}
