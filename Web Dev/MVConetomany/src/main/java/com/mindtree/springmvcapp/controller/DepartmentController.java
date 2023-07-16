package com.mindtree.springmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mindtree.springmvcapp.dto.DepartmentDto;
import com.mindtree.springmvcapp.exception.DepartmentException;
import com.mindtree.springmvcapp.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springmvcapp.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/hmf")
	public String hmf() {
		return "htmlframes";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/department")
	public String department() {
		return "department";
	}

	
	@ResponseBody
	@RequestMapping(value = "/adddepartment" )
	public DepartmentDto addDept( @RequestBody  DepartmentDto deptDto) throws DepartmentException {
		//System.out.println(deptDto);
		try {
			departmentService.createDepartment(deptDto);
		} catch (DepartmentServiceException e) {
			throw new DepartmentException(e.getLocalizedMessage());
		} 
	   //return "home";
		//AjaxResponseBody result = new AjaxResponseBody();
		//ModelAndView mv =  new ModelAndView("home");
		//Gson gson = new Gson(); return gson.toJson(deptDto);
		return deptDto;
		// return mv;
		//return "done";
	}
	
	/*
	 * @RequestMapping("/adddepartment") public String addDept1(DepartmentDto
	 * deptDto) throws DepartmentException {
	 * 
	 * try { departmentService.createDepartment(deptDto); } catch
	 * (DepartmentServiceException e) { throw new
	 * DepartmentException(e.getLocalizedMessage()); }
	 * 
	 * return "home";
	 * 
	 * }
	 */

}
