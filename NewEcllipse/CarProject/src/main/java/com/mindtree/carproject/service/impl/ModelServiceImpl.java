package com.mindtree.carproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.carproject.converter.ModelConverter;
import com.mindtree.carproject.dto.ModelDto;
import com.mindtree.carproject.entity.Brand;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.exception.daoexception.ModelAlreadyExistsException;
import com.mindtree.carproject.exception.daoexception.ResourceNotFoundException;
import com.mindtree.carproject.exception.serviceexception.ModelServiceException;
import com.mindtree.carproject.repository.BrandRepository;
import com.mindtree.carproject.repository.ModelRepository;
import com.mindtree.carproject.service.ModelService;
@Service
public class ModelServiceImpl implements ModelService{
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private BrandRepository brandRepository;	
	@Autowired
	private ModelConverter modelConverter;
	@Override
	public List<Model> addModels(List<ModelDto> modelList, String brandName) throws ModelServiceException{
		List<Model> modelsAdded = new ArrayList<>();
		Brand brand;
		try {
			brand = brandRepository.findByName(brandName)
					.orElseThrow(() -> new ResourceNotFoundException("No Brand Exists with name " + brandName));
		} catch (ResourceNotFoundException e) {
			throw new ModelServiceException(e.getLocalizedMessage());
		}
		for(ModelDto modelDto : modelList)
		{
			if(modelRepository.findById(modelDto.getName()).orElse(null) != null)
			{
				throw new ModelAlreadyExistsException("The model "+modelDto.getName()+" already exists in the database");
			}
			Model model = modelConverter.dtoToEntity(modelDto);
			brand.getModelList().add(model);
			model.setBrand(brand);
			modelsAdded.add(modelRepository.save(model));
		}
		return modelsAdded;
	}

}
