package com.mindtree.service.impl;

import java.util.List;

import com.mindtree.dao.AirlineDao;
import com.mindtree.dao.impl.AirlineDaoImpl;
import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.daoexception.AirlineDaoException;
import com.mindtree.exception.serviceexception.AirlineServiceException;
import com.mindtree.service.AirlineService;

public class AirlineServiceImpl implements AirlineService {
	private static AirlineDao airDao = new AirlineDaoImpl();
	

	
	@Override
	public boolean insertIntoFlightDB(Flight flight)
			throws AirlineServiceException {
		try {
			return airDao.insertIntoFlightDB(flight);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in FlightDB",e);
			//e.printStackTrace();
		}
	}

	@Override
	public boolean insertIntoPassengerDB(Passenger passenger)
			throws AirlineServiceException {
		
		try {
			return airDao.insertIntoPassengerDB(passenger);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in PassengerDB",e);
			
		}
	}


	@Override
	public List<Flight> getFlightsByDestination(String destination) throws AirlineServiceException {
		
		try {
			return airDao.getFlightsByDestination(destination);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in DB",e);
		}
	}


	@Override
	public List<Passenger> getPassengersByGenderAndAge(int age, String gender) throws AirlineServiceException {
		
		try {
			return airDao.getPassengersByGenderAndAge(age, gender);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in DB",e);
		}
	}

}
