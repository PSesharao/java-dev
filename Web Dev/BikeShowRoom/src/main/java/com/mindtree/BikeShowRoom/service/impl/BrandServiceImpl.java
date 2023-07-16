package com.mindtree.BikeShowRoom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.BikeShowRoom.converter.BrandConverter;
import com.mindtree.BikeShowRoom.dto.BrandDto;
import com.mindtree.BikeShowRoom.entity.Brand;
import com.mindtree.BikeShowRoom.exception.daoexception.ResourceNotFoundException;
import com.mindtree.BikeShowRoom.exception.serviceexception.BrandServiceException;
import com.mindtree.BikeShowRoom.repository.BrandRepository;
import com.mindtree.BikeShowRoom.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private BrandConverter brandConverter;

	@Override
	public Brand createBrand(BrandDto brandDto) throws BrandServiceException {

		return this.brandRepository.save(brandConverter.dtoToEntity(brandDto));
	}

	@Override
	public Brand getBrandByName(String brandName) throws BrandServiceException {

		try {
			return this.brandRepository.findById(brandName)
					.orElseThrow(() -> new ResourceNotFoundException("No Brand Found with name " + brandName));
		} catch (ResourceNotFoundException e) {
			throw new BrandServiceException(e.getLocalizedMessage());
		}
	}

}
