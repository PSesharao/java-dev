
package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.daoexception.AirlineDaoException;
import com.mindtree.exception.serviceexception.AirlineServiceException;

public interface AirlineDao {
	boolean insertIntoFlightDB(Flight flight) throws AirlineDaoException;

	boolean insertIntoPassengerDB(Passenger passenger) throws AirlineDaoException;

	List<Flight> getFlightsByDestination(String destination) throws AirlineDaoException;

	List<Passenger> getPassengersByGenderAndAge(int age, String gender) throws AirlineDaoException;
}
