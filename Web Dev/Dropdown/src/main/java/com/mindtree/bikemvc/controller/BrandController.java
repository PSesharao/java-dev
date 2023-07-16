package com.mindtree.bikemvc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.bikemvc.dto.BrandDto;
import com.mindtree.bikemvc.entity.Brand;
import com.mindtree.bikemvc.exception.BrandException;
import com.mindtree.bikemvc.exception.serviceexception.BrandServiceException;
import com.mindtree.bikemvc.service.BrandService;



@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/addbrand")
	public String addBrand(BrandDto brandDto) throws BrandException
	{
		brandService.createBrand(brandDto);
		return "welcome";
			
	}
	
	@RequestMapping("/home") 
	public String home() throws BrandException
	{
		return "htmlframes";
	}
	
	@RequestMapping("/welcome") 
	public String welcome() throws BrandException
	{
		return "welcome";
	}
	
	@RequestMapping("/bstltemplate")
	public String nav() throws BrandException
	{
		return "bstltemplate";
	}
	
	@RequestMapping("/brand")
	public String brand() throws BrandException
	{
		return "brand";
	}
	
	@RequestMapping("/middle")
	public String middle() throws BrandException
	{
		return "middle";
	}
	
	@RequestMapping("/bottom")
	public String bottom() throws BrandException
	{
		return "bottom";
	}
	
	@RequestMapping("/show")
	public ModelAndView show()  throws BrandException
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		List <Brand> brandList = null;
		try {
			brandList = brandService.getAllBrands();
		} catch (BrandServiceException e) {
			throw new BrandException(e.getLocalizedMessage());
		}
		mv.addObject("brandList", brandList);
		return mv;
	}
	
}
