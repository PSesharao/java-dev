package com.mindtree.bikemvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.bikemvc.dto.ModelDto;
import com.mindtree.bikemvc.entity.Brand;
import com.mindtree.bikemvc.entity.Model;
import com.mindtree.bikemvc.exception.BrandException;
import com.mindtree.bikemvc.exception.ModelException;
import com.mindtree.bikemvc.exception.serviceexception.BrandServiceException;
import com.mindtree.bikemvc.exception.serviceexception.ModelServiceException;
import com.mindtree.bikemvc.service.BrandService;
import com.mindtree.bikemvc.service.ModelService;



@Controller
public class ModelController {


	@Autowired
	private ModelService modelService;
	
	@Autowired 
	private BrandService brandService;

	@RequestMapping("/addmodel")
	public String addModel(ModelDto modelDto,
			 @RequestParam("brand")  String brandName) throws ModelException {
	
			try {
				modelService.createModel(modelDto, brandName);
			} catch (ModelServiceException e) {
				throw new ModelException(e.getLocalizedMessage());
			}
			return "welcome";
		
	}
	
	@RequestMapping("/model")
	public ModelAndView model() throws ModelException
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("model");
		List <Brand> brandList = null;
		try {
			brandList = brandService.getAllBrands();
		} catch (BrandServiceException e) {
			throw new ModelException(e.getLocalizedMessage());
		}
		mv.addObject("brandList", brandList);
		return mv;
	}
	
	@RequestMapping("/showbrand")
	public ModelAndView showbrand( @RequestParam("brand")  String brandName)  throws BrandException
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		List <Model> ModelList = null;
		try {
			ModelList = modelService.getModelsByBrand(brandName);
		} catch (ModelServiceException e) {
			throw new BrandException(e.getLocalizedMessage());
		}
		
		List <Brand> brandList = null;
		try {
			brandList = brandService.getAllBrands();
		} catch (BrandServiceException e) {
			throw new BrandException(e.getLocalizedMessage());
		}
		
		try {
			mv.addObject("revenue", modelService.getTotalRevenueOfBrand(brandName));
		} catch (ModelServiceException e) {
			throw new BrandException(e.getLocalizedMessage());
		}
		mv.addObject("brandList", brandList);
		
		mv.addObject("modelList", ModelList);
		return mv;
	}
	

}
