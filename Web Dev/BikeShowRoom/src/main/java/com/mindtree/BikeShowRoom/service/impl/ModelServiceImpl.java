package com.mindtree.BikeShowRoom.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.BikeShowRoom.converter.ModelConverter;
import com.mindtree.BikeShowRoom.dto.ModelDto;
import com.mindtree.BikeShowRoom.entity.Brand;
import com.mindtree.BikeShowRoom.entity.Model;
import com.mindtree.BikeShowRoom.exception.daoexception.NoOfModelsExceedException;
import com.mindtree.BikeShowRoom.exception.serviceexception.BrandServiceException;
import com.mindtree.BikeShowRoom.exception.serviceexception.ModelServiceException;
import com.mindtree.BikeShowRoom.repository.ModelRepository;
import com.mindtree.BikeShowRoom.service.BrandService;
import com.mindtree.BikeShowRoom.service.ModelService;

class SortDescending implements Comparator<Model> {

	@Override
	public int compare(Model model1, Model model2) {
		return (int) (model2.getPrice() - model1.getPrice());
	}

}

@Component
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelRepository modelRepository;

	@Autowired
	private BrandService brandService;

	@Autowired
	private ModelConverter modelConverter;

	@Override
	public Model createModel(ModelDto modelDto, String brandName) throws ModelServiceException {
		Brand brand = null;
		try {
			brand = brandService.getBrandByName(brandName);
		} catch (BrandServiceException e) {
			throw new ModelServiceException(e.getLocalizedMessage());
		}

		if (brand.getModelList().size() >= 4)
			try {
				throw new NoOfModelsExceedException(
						"The no of models of brand " + brandName + " exceeded it's capacity");
			} catch (NoOfModelsExceedException e) {
				throw new ModelServiceException(e.getLocalizedMessage());
			}
		Model model = modelConverter.dtoToEntity(modelDto);
		model.setBrand(brand);
		brand.getModelList().add(model);
		//modelRepository.fi
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getModelsByBrand(String brandName) throws ModelServiceException {
		Brand brand = null;
		try {
			brand = brandService.getBrandByName(brandName);
		} catch (BrandServiceException e) {
			throw new ModelServiceException(e.getLocalizedMessage());
		}

		return brand.getModelList();
	}

	@Override
	public double getTotalRevenueOfBrand(String brandName) throws ModelServiceException {

		double totalRevenue = 0;
		List<Model> modelList = getModelsByBrand(brandName);

		for (Model model : modelList) {
			totalRevenue += model.getPrice();
		}

		return totalRevenue;
	}

	@Override
	public List<Model> sortmodelsByPrice(List<Model> modelList) throws ModelServiceException {
		
		return 
				
		modelList.
		stream().
		sorted(new SortDescending()).
		collect(Collectors.toList());
		 
	}

	@Override
	public int findCountOfModel(String modelName) throws ModelServiceException {
		
		return modelRepository.findAllByName(modelName).size();
		
	}
	
	

}
