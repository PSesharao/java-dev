package com.mindtree.service;

import java.util.List;
import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.serviceexception.AirlineServiceException;

public interface AirlineService {
	List<Flight> getFlightsByDestination(String destination) throws AirlineServiceException;

	List<Passenger> getPassengersByGenderAndAge(int age, String gender) throws AirlineServiceException;

	boolean insertIntoFlightDB(Flight flight) throws AirlineServiceException;

	boolean insertIntoPassengerDB(Passenger passenger) throws AirlineServiceException;

}
