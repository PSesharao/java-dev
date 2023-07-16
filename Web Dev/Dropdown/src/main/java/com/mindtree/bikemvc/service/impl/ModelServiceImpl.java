package com.mindtree.bikemvc.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.bikemvc.converter.ModelConverter;
import com.mindtree.bikemvc.dto.ModelDto;
import com.mindtree.bikemvc.entity.Brand;
import com.mindtree.bikemvc.entity.Model;
import com.mindtree.bikemvc.exception.daoexception.NoOfModelsExceedException;
import com.mindtree.bikemvc.exception.serviceexception.BrandServiceException;
import com.mindtree.bikemvc.exception.serviceexception.ModelServiceException;
import com.mindtree.bikemvc.repository.ModelRepository;
import com.mindtree.bikemvc.service.BrandService;
import com.mindtree.bikemvc.service.ModelService;



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

		if (modelDto.getQuantity() > 4)
			try {
				throw new NoOfModelsExceedException(
						"The quantity of model " + modelDto.getName() + " exceeded it's capacity");
			} catch (NoOfModelsExceedException e) {
				throw new ModelServiceException(e.getLocalizedMessage());
			}
		Model model = modelConverter.dtoToEntity(modelDto);
		model.setBrand(brand);
		brand.getModelList().add(model);
		
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
			totalRevenue += model.getPrice()*model.getQuantity();
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
