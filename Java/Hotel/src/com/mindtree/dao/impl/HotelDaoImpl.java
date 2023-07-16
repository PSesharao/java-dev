package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.HotelDao;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.daoexception.DataBaseEmptyException;
import com.mindtree.exception.daoexception.DatabaseConnectionFailedException;
import com.mindtree.exception.daoexception.HotelDaoException;
import com.mindtree.util.DBUtil;

public class HotelDaoImpl implements HotelDao {
	private DBUtil dbUtil = new DBUtil();
	@Override
	public boolean insertHotelIntoDB(String id , String name  , String location) throws HotelDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();
			String insertQuery = "call inserttoHotel(?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, location);
			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			throw new HotelDaoException("Insertion failed into Hotel DB", e);
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	
	@Override
	public List<Hotel> getHotelsBasedOnCity(String city) throws HotelDaoException {
		List<Hotel> hotelList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "call getHotelsFromCity('"+city+"')";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Hotel hotel = new Hotel( rs.getString(1),rs.getString(2),rs.getString(3));
				hotelList.add(hotel);
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Unable to fetch the Hotel records ", e);
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		if (hotelList.size() == 0) {
			throw new DataBaseEmptyException("No hotel found for given city " + city);
		}
		return hotelList;
	}


	@Override
	public boolean insertRoomIntoDB(String id, String type, int price, String hotelid) throws HotelDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();
			String insertQuery = "call inserttoRoom(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setString(1, id);
			ps.setString(2, type);
			ps.setInt(3, price);
			ps.setString(4, hotelid);
			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			throw new HotelDaoException("Insertion failed into room DB", e);
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}


	@Override
	public List<Room> getRoomsBelongToHotel(String hotelId) throws HotelDaoException {
		
		List<Room> roomList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getMyConnection();
			String selectQuery = "call getRoomFromHotel('"+hotelId+"')";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				Room room = new Room( rs.getString(1),rs.getString(2),rs.getInt(3));
				roomList.add(room);
			}

		} catch (SQLException e) {
			throw new DatabaseConnectionFailedException("Unable to fetch the room records ", e);
		} finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(stmt);
			dbUtil.closeResource(con);
		}
		if (roomList.size() == 0) {
			throw new DataBaseEmptyException("No room found for given hotel ");
		}
		return roomList;
	}
}
