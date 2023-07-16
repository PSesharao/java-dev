package com.mindtree.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.mindtree.dao.AirlineDao;
import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.daoexception.AirlineDaoException;
import com.mindtree.exception.daoexception.DataBaseEmptyException;
import com.mindtree.exception.daoexception.DatabaseConnectionFailedException;
import com.mindtree.utility.SessionUtil;

public class AirlineDaoImpl implements AirlineDao {
	private static SessionUtil hbutil = new SessionUtil();
	@Override
	public boolean insertIntoFlightDB(Flight flight)
			throws AirlineDaoException {
		boolean isInserted = false;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(flight);
			sessionObj.getTransaction().commit();
			isInserted = true;
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

		}  catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoPassengerDB(Passenger passenger) throws AirlineDaoException {
		boolean isInserted = false;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(passenger);
			sessionObj.getTransaction().commit();
			isInserted = true;
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

		}  catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		return isInserted;
	}


	@Override
	public List<Flight> getFlightsByDestination(String destination) throws AirlineDaoException {
		List<Flight> flightList = null;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select distinct flight from"
					+ " Flight flight"
					+ " where flight.destination = :d";
			@SuppressWarnings("unchecked")
			Query<Flight> query = sessionObj.createQuery(queryString);
			query.setParameter("d", destination );
			flightList =  query.list();
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		if(flightList.size()==0)
			throw new DataBaseEmptyException("The flight list is empty");
		return flightList;
	}

	@Override
	public List<Passenger> getPassengersByGenderAndAge(int age, String gender) throws AirlineDaoException {
		List<Passenger> passList = null;
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			String queryString = "select distinct flight.passengerList from"
					+ " Flight flight join flight.passengerList pass"
					+ " where pass.age > :a and pass.gender = :g";
			@SuppressWarnings("unchecked")
			Query<Passenger> query = sessionObj.createQuery(queryString);
			query.setParameter("a", age );
			query.setParameter("g", gender );
			passList = query.list();
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			throw new DatabaseConnectionFailedException("Could not establish a session", e);
		} finally {
			hbutil.closeResource(sessionObj);
		}
		if(passList.size()==0)
			throw new DataBaseEmptyException("The passenger list is empty");
		return passList;
	}

}
