package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.daoexception.HotelDaoException;

public interface HotelDao {
	List<Hotel> getHotelsBasedOnCity(String city) throws HotelDaoException;
	boolean insertHotelIntoDB(String id , String name  , String location) throws HotelDaoException;
	boolean insertRoomIntoDB(String id , String type , int price , String hotelid) throws HotelDaoException; 
	List<Room> getRoomsBelongToHotel(String hotelId) throws HotelDaoException; 
}
