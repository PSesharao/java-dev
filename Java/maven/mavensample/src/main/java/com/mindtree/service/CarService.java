package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Car;
import com.mindtree.exception.serviceexception.CarServiceException;

public interface CarService {
	boolean insertCarIntoDB(Car car) throws CarServiceException;
	List<Car> getCarsByPriceAndColor(double price1,double price2 , String color ) throws CarServiceException;
	String writeCarsToFile(List<Car> carList , String path)throws CarServiceException;
	List<Car> getAllCars() throws CarServiceException;
}
