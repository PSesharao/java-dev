package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.CarDoa;
import com.mindtree.entity.Car;
import com.mindtree.exception.daoexception.CarDaoException;
import com.mindtree.exception.daoexception.DataBaseEmptyException;
import com.mindtree.exception.daoexception.DatabaseConnectionFailedException;
import com.mindtree.util.DBUtil;

public class CarDaoImpl implements CarDoa {
	private DBUtil dbUtil = new DBUtil();
	@Override
	public boolean insertCarIntoDB(Car car) throws CarDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();
			String insertQuery = "insert into car values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1, car.getId());
			ps.setString(2, car.getName());
			ps.setDouble(3, car.getPrice());
			ps.setString(4, car.getColor());

			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			throw new CarDaoException("Database not connected ", e);
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public List<Car> getCarsByPriceAndColor(double price1 ,double price2, String color) throws CarDaoException {
		List<Car> carList = new ArrayList<Car>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			//String selectQuery = "select * from car where car.price >= "+"\'"+(price1)+"\'"+" and car.price <= "+"\'"+(price2)+"\'"+" and car.color = "+"\'"+(color)+"\'"+";";
			String selectQuery = "CALL GetAllcarsByPriceAndColor("+ price1 +","+ price2 +"," +"'"+color+"'"+");";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Car employee = new Car(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getString(4));
				carList.add(employee);
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Database not connected ", e);
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		if (carList.size() == 0) {
			throw new DataBaseEmptyException("No car found for given price and color ");
		}

		return carList;
	}

	@Override
	public List<Car> getAllCars() throws CarDaoException {
		
		List<Car> carList = new ArrayList<Car>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "CALL GetAllcars()";
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Car employee = new Car(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getString(4));
				carList.add(employee);
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Database not connected ", e);
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		if (carList.size() == 0) {
			throw new DataBaseEmptyException("No cars found ");
		}

		return carList;
	}
	
}
