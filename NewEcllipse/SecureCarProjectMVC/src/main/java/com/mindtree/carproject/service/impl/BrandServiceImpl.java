package com.mindtree.carproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.carproject.converter.BrandConverter;
import com.mindtree.carproject.dto.BrandDto;
import com.mindtree.carproject.dto.SoldModel;
import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.entity.Brand;
import com.mindtree.carproject.entity.Color;
import com.mindtree.carproject.entity.Model;
import com.mindtree.carproject.entity.ModelColor;
import com.mindtree.carproject.exception.daoexception.BrandAlreadyExistsException;
import com.mindtree.carproject.exception.daoexception.ResourceNotFoundException;
import com.mindtree.carproject.exception.serviceexception.BrandServiceException;
import com.mindtree.carproject.repository.BrandRepository;
import com.mindtree.carproject.repository.ColorRepository;
import com.mindtree.carproject.repository.ModelColorRepository;
import com.mindtree.carproject.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandConverter brandConverter;
	@Autowired
	private ModelColorRepository modelColorRepository;
	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ColorRepository colorRepository;

	@Override
	public Brand createBrand(BrandDto brandDto) throws BrandServiceException {
		if(brandRepository.findByName(brandDto.getName()).orElse(null) != null) {
			throw new BrandAlreadyExistsException("The brand "+brandDto.getName()+ " already exists in the DataBase");
		}
		return brandRepository.save(brandConverter.dtoToEntity(brandDto));
	}

	@Override
	public SoldModel sellModel(ModelColorKey modelColorKey, String brandName) throws BrandServiceException {
		ModelColor modelColor;
		try {
			modelColor = modelColorRepository.findById(modelColorKey).orElseThrow(
					() -> new ResourceNotFoundException("No Model Color Pair Exists with the key " + modelColorKey));
		} catch (ResourceNotFoundException e) {
			throw new BrandServiceException(e.getLocalizedMessage());
		}
		Brand brand;
		try {
			brand = brandRepository.findByName(brandName)
					.orElseThrow(() -> new ResourceNotFoundException("No Brand Exists with name " + brandName));
		} catch (ResourceNotFoundException e) {
			throw new BrandServiceException(e.getLocalizedMessage());
		}
		boolean previousHistory = false;
		int previousIndex = -1;
		SoldModel soldModel;
		for (int i = 0; i < brand.getSoldModels().size(); i++) {
			SoldModel sold = brand.getSoldModels().get(i);

			if (sold.getModelColorKey().getColor().equals(modelColorKey.getColor())
					&& sold.getModelColorKey().getModel().equals(modelColorKey.getModel())) {
				previousHistory = true;
				previousIndex = i;
				break;
			}
		}

		if (!previousHistory) {
			soldModel = new SoldModel();
			soldModel.setModelColorKey(modelColorKey);
			soldModel.setFrequency(1);
			soldModel.setTotalPrice(modelColor.getPrice());
			brand.getSoldModels().add(soldModel);
		} else {
			brand.getSoldModels().get(previousIndex)
					.setFrequency(brand.getSoldModels().get(previousIndex).getFrequency() + 1);
			brand.getSoldModels().get(previousIndex)
					.setTotalPrice(modelColor.getPrice() * brand.getSoldModels().get(previousIndex).getFrequency());
			soldModel = brand.getSoldModels().get(previousIndex);
		}

		brand.setTotalRevenue(brand.getTotalRevenue() + modelColor.getPrice());
		brandRepository.save(brand);
		return soldModel;
	}

	@Override
	public List<Model> getModelsByBrand(String brandName) throws BrandServiceException {
		try {
			return brandRepository.findByName(brandName)
					.orElseThrow(() -> new ResourceNotFoundException("No Brand Exists with name " + brandName))
					.getModelList();
		} catch (ResourceNotFoundException e) {

			throw new BrandServiceException(e.getLocalizedMessage());
		}

	}

	@Override
	public List<Model> getModelsOnColor(String brandName, String color) throws BrandServiceException {
		Color color2;
		try {
			color2 = colorRepository.findById(color)
					.orElseThrow(() -> new ResourceNotFoundException("No Color Exists with name " + color));
		} catch (ResourceNotFoundException e) {
			throw new BrandServiceException(e.getLocalizedMessage());

		}
		List<Model> modelList = new ArrayList<>();
		for (ModelColor modelColor : color2.getModelList()) {
			if (modelColor.getModel().getBrand().getName().equals(brandName))
				modelList.add(modelColor.getModel());
		}
		return modelList;
	}

}
