package com.mindtree.passenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.passenger.converter.PassengerConverter;
import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.Passenger;
import com.mindtree.passenger.repository.PassengerRepository;

@Controller
public class PassengerController {
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private PassengerConverter passengerConverter;

	@RequestMapping("/passenger")
	public String passenger() {
		return "passenger";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}


	@RequestMapping("/registerPassenger")
	@ResponseBody
	public Passenger registerPassenger(PassengerDto passengerDto) {
		return passengerRepository.save(passengerConverter.dtoToEntity(passengerDto));
	}
}
