package com.mindtree.passenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CityController {
	@RequestMapping(value = "/city")
	public String country()
	{
		return "city";
	}
}
