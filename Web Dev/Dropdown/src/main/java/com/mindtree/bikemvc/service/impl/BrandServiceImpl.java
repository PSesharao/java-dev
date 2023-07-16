package com.mindtree.bikemvc.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bikemvc.converter.BrandConverter;
import com.mindtree.bikemvc.dto.BrandDto;
import com.mindtree.bikemvc.entity.Brand;
import com.mindtree.bikemvc.exception.daoexception.ResourceNotFoundException;
import com.mindtree.bikemvc.exception.serviceexception.BrandServiceException;
import com.mindtree.bikemvc.repository.BrandRepository;
import com.mindtree.bikemvc.service.BrandService;




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
		Brand brand = null;
		try {
			brand = this.brandRepository.findByName(brandName);
				if(brand == null)
					throw new ResourceNotFoundException("No Brand Found with name " + brandName);
		} catch (ResourceNotFoundException e) {
			throw new BrandServiceException(e.getLocalizedMessage());
		}
		return brand;
	}

	@Override
	public List<Brand> getAllBrands() throws BrandServiceException {
		
		return this.brandRepository.findAll();
	}

}
