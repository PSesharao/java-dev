package com.mindtree.passenger.service;

import com.mindtree.passenger.dto.PassengerDto;
import com.mindtree.passenger.entity.Passenger;

public interface PassengerService {
	
	Passenger registerPassenger(PassengerDto passengerDto);
}
