
package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Passenger;
import com.mindtree.exception.daoexception.AirlineDaoException;

public interface AirlineDao {
	boolean insertIntoFlightDB(String id,String name,String source,String destination) throws AirlineDaoException;
	boolean insertIntoPassengerDB(String id , String name , int age ,String gender)throws AirlineDaoException;
	boolean insertIntoFlightPassengerDB(String flightId, String passengerId)throws AirlineDaoException;
	List<Passenger> getPassengersByGenderAndAgeFromDB(int age ,String gender ) throws AirlineDaoException;
}
