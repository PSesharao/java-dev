package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.serviceexception.HotelServiceException;

public interface HotelService {
	boolean insertHotelIntoDB(String id , String name  , String location) throws HotelServiceException;
	boolean insertRoomIntoDB(String id , String type , int price , String hotelid)  throws HotelServiceException;
	List<Hotel> getHotelsBasedOnCity(String city) throws HotelServiceException;
	List<Room> getRoomsBelongToHotel(String hotelId) throws HotelServiceException;
}
