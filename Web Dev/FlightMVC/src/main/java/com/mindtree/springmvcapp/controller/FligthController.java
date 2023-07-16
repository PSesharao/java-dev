package com.mindtree.springmvcapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mindtree.springmvcapp.converter.CustomerConverter;
import com.mindtree.springmvcapp.dto.CustomerDto;
import com.mindtree.springmvcapp.dto.FlightDto;
import com.mindtree.springmvcapp.entity.Customer;
import com.mindtree.springmvcapp.entity.Flight;
import com.mindtree.springmvcapp.repository.CustomerRepository;
import com.mindtree.springmvcapp.repository.FlightRepository;
import com.mindtree.springmvcapp.service.FlightService;

@Controller
public class FligthController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private CustomerConverter customerConverter;

	@RequestMapping("/flight")
	public String flight() {
		return "flight";
	}

	@RequestMapping("/addflight")
	public String addFlight(FlightDto flightDto) {
		flightService.createFlight(flightDto);
		return "home";
	}

	@RequestMapping("/book")
	public ModelAndView book() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book");

		mv.addObject("flightList", flightRepository.findAll());
		mv.addObject("customerList", customerRepository.findAll());
		return mv;
	}
	
	
	@RequestMapping("/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		mv.addObject("flightList", flightRepository.findAll());
		return mv;
	}
	

	@RequestMapping("/bookflight")
	public String bookFlight(@RequestParam("flightname") String flightname,
			@RequestParam("customerId") long customerId) {
		flightService.bookFlight(flightname, customerId);
		return "success";
	}
	

	@ResponseBody
	@RequestMapping(value = "getCustomeresByFlight/{flightName}")
	public String getCustomeresByFlight(@PathVariable("flightName") String flightName)
	{
		 System.out.println(flightName);
		 Flight flight = flightRepository.findByName(flightName);
		 List<Customer> customerList = flight.getCustomerList(); 
		 System.out.println(customerList);
		 List<String > customerNames = new ArrayList<>();
		 Gson gson = new Gson();
		 List<CustomerDto> dtoList = new ArrayList<>();
		 for(Customer customer : customerList)
		 {
			 customerNames.add(customer.getName());
			 dtoList.add(customerConverter.entityToDto(customer));
		 }
		 System.out.println(gson.toJson(dtoList));
		 //System.out.println();
		 return gson.toJson(gson.toJson(dtoList));
	}

	

}
