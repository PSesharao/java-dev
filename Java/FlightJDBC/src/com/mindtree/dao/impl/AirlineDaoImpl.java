package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mindtree.dao.AirlineDao;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.daoexception.AirlineDaoException;
import com.mindtree.utility.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class AirlineDaoImpl implements AirlineDao {
	private DBUtil dbUtil = new DBUtil();
	@Override
	public boolean insertIntoFlightDB(String id, String name, String source, String destination)
			throws AirlineDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into Flight (id ,name , source , destination ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, source);
			ps.setString(4, destination);
			ps.execute();
			isInserted = true;

		} catch (MySQLIntegrityConstraintViolationException e) {
			//e.printStackTrace();
			throw new AirlineDaoException("Integrity constarint violated during insertion of Flight",e);
		}catch (SQLException e) {
			throw new AirlineDaoException("SQL error Fligt could not be inserted",e);
		}
		finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoPassengerDB(String id, String name, int age, String gender) throws AirlineDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into Passenger (id , name , age , gender ) values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.execute();
			isInserted = true;

		} catch (MySQLIntegrityConstraintViolationException e) {
			//e.printStackTrace();
			throw new AirlineDaoException("Integrity constarint violated during insertion of Passenger",e);
		}catch (SQLException e) {
			throw new AirlineDaoException("SQL error Passenger could not be inserted",e);
		}finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public boolean insertIntoFlightPassengerDB(String flightId, String passengerId) throws AirlineDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();

			String insertQuery = "insert into FlightPassenger (flightId ,passengerId ) values(?,?);";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, flightId);
			ps.setString(2, passengerId);
			ps.execute();
			isInserted = true;
		} catch (MySQLIntegrityConstraintViolationException e) {
			//e.printStackTrace();
			throw new AirlineDaoException("Integrity constarint violated during insertion of FlightPassenger",e);
		}catch (SQLException e) {
			throw new AirlineDaoException("SQL error FlightPassenger could not be inserted",e);
		}finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public List<Passenger> getPassengersByGenderAndAgeFromDB(int age, String gender) throws AirlineDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
