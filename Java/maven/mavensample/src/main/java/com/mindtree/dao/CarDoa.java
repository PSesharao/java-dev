package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Car;
import com.mindtree.exception.daoexception.CarDaoException;

public interface CarDoa {
	boolean insertCarIntoDB(Car car) throws CarDaoException ;
	List<Car> getCarsByPriceAndColor(double price1, double price2 , String color ) throws CarDaoException ;
	List<Car> getAllCars() throws CarDaoException ;
}
