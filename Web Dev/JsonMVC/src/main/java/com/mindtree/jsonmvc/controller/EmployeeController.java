package com.mindtree.jsonmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.jsonmvc.entity.Employee;
import com.mindtree.jsonmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// normal part

	/*
	 * @RequestMapping("/jsonMVC") public ModelAndView home() { ModelAndView mv =
	 * new ModelAndView("show"); employeeService.createEmployee(); Employee employee
	 * = employeeService.getEmployeeById(12000);
	 * 
	 * mv.addObject("employee", employee);
	 * 
	 * return mv; }
	 */

	// ajax call

	@RequestMapping("/jsonMVC")
	public String home() {
		return "show";
	}

	@ResponseBody

	@RequestMapping(value = "getEmployee")
	public String getEmployee() {
		Employee employee = employeeService.getEmployeeById(12000);

		return employeeService.getEmployeeInJsonFormat(employee);
	}

}
