package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.serviceexception.AirlineServiceException;

public interface AirlineService {
	List<Flight> getFlightsByDestination(List<Flight> flightList,String destination) throws AirlineServiceException;
	List<Passenger> getPassengersByGenderAndAge(int age ,String gender , List<Flight> flightList) throws AirlineServiceException;
	boolean insertIntoFlightDB(String id,String name,String source,String destination) throws AirlineServiceException;
	boolean insertIntoPassengerDB(String id , String name , int age ,String gender)throws AirlineServiceException;
	boolean insertIntoFlightPassengerDB(String flightId, String passengerId)throws AirlineServiceException;
	List<Passenger> getPassengersByGenderAndAgeFromDB(int age ,String gender ) throws AirlineServiceException;
}
