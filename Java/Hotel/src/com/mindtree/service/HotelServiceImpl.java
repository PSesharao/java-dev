package com.mindtree.service;

import java.util.List;

import com.mindtree.dao.HotelDao;
import com.mindtree.dao.impl.HotelDaoImpl;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.daoexception.HotelDaoException;
import com.mindtree.exception.serviceexception.HotelServiceException;

public class HotelServiceImpl implements HotelService {
	private static HotelDao hotelDao = new HotelDaoImpl();

	@Override
	public List<Hotel> getHotelsBasedOnCity(String city) throws HotelServiceException {

		try {
			return hotelDao.getHotelsBasedOnCity(city);
		} catch (HotelDaoException e) {
			throw new HotelServiceException(e);
		}
	}

	@Override
	public List<Room> getRoomsBelongToHotel(String hotelId) throws HotelServiceException {

		try {
			return hotelDao.getRoomsBelongToHotel(hotelId);
		} catch (HotelDaoException e) {
			throw new HotelServiceException(e);
		}
	}

	@Override
	public boolean insertHotelIntoDB(String id, String name, String location) throws HotelServiceException {

		try {
			return hotelDao.insertHotelIntoDB(id, name, location);
		} catch (HotelDaoException e) {
			throw new HotelServiceException(e);
		}
	}

	@Override
	public boolean insertRoomIntoDB(String id, String type, int price, String hotelid) throws HotelServiceException {

		try {
			return hotelDao.insertRoomIntoDB(id, type, price, hotelid);
		} catch (HotelDaoException e) {
			throw new HotelServiceException(e);
		}
	}

}
