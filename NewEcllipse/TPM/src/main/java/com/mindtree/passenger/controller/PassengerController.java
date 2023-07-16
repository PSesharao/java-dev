package com.mindtree.passenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.Passenger;
import com.mindtree.passenger.service.PassengerService;

@Controller
public class PassengerController {
	

	@Autowired
	private PassengerService passengerService;
	@RequestMapping("/registerPassenger")
	@ResponseBody
	public Passenger registerPassenger(PassengerDto passengerDto) {
		
		//return passengerRepository.save(passengerConverter.dtoToEntity(passengerDto));
		return passengerService.registerPassenger(passengerDto);
	}
}
