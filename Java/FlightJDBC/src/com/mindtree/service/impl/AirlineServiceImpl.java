package com.mindtree.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mindtree.dao.AirlineDao;
import com.mindtree.dao.impl.AirlineDaoImpl;
import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.daoexception.AirlineDaoException;
import com.mindtree.exception.serviceexception.AirlineServiceException;
import com.mindtree.service.AirlineService;

class SortDescending implements Comparator<Flight> 
{

	@Override
	public int compare(Flight flight1, Flight flight2) {
		return -flight1.getName().compareTo(flight2.getName());
	}
	
}
public class AirlineServiceImpl implements AirlineService {
	private static AirlineDao airDao = new AirlineDaoImpl();
	@Override
	public List<Flight> getFlightsByDestination(List<Flight> flightList, String destination)
			throws AirlineServiceException {

		return
		flightList.
		stream(). 
		filter(flight -> flight.getDestination().compareTo(destination)==0).
		sorted(new SortDescending()).
		collect(Collectors.toList());
		
	}

	
	@Override
	public List<Passenger> getPassengersByGenderAndAge(int age, String gender , List<Flight> flightList) throws AirlineServiceException {
		
		List<Passenger> passList = new ArrayList<Passenger>();
		/*flightList.stream().forEach(flight -> {
			flight.getPassengerList().
			stream().
			filter(passenger-> passenger.getGender().compareTo(gender)==0 && passenger.getAge()>age).
			forEach(passenger -> System.out.println(passenger.getName()));	
			;
		});*/
		flightList.stream().forEach(flight ->
		{
			flight.getPassengerList().
			stream().
			filter(passenger-> passenger.getGender().compareTo(gender)==0 && passenger.getAge()>age).
			forEach(passenger -> passList.add(passenger));
		});
		return passList;
	}
	
	@Override
	public boolean insertIntoFlightDB(String id, String name, String source, String destination)
			throws AirlineServiceException {
		try {
			return airDao.insertIntoFlightDB(id, name, source, destination);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in FlightDB",e);
			//e.printStackTrace();
		}
	}

	@Override
	public boolean insertIntoPassengerDB(String id, String name, int age, String gender)
			throws AirlineServiceException {
		
		try {
			return airDao.insertIntoPassengerDB(id, name, age, gender);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in PassengerDB",e);
			
		}
	}

	@Override
	public boolean insertIntoFlightPassengerDB(String flightId, String passengerId) throws AirlineServiceException {
		
		try {
			return airDao.insertIntoFlightPassengerDB(flightId, passengerId);
		} catch (AirlineDaoException e) {
			throw new AirlineServiceException("Something went wrong in FlightPassengerDB",e);	
		}
	}

	@Override
	public List<Passenger> getPassengersByGenderAndAgeFromDB(int age, String gender) throws AirlineServiceException {
		
		return null;
	}

}
