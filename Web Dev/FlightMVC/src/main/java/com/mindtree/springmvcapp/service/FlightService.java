package com.mindtree.springmvcapp.service;

import java.util.List;

import com.mindtree.springmvcapp.dto.FlightDto;
import com.mindtree.springmvcapp.entity.Flight;



public interface FlightService {
	public Flight createFlight(FlightDto flightDto) ;
	
	public Flight getDeptById(long flightId);
	
	public void bookFlight( String flightname , long customerId) ;
}
