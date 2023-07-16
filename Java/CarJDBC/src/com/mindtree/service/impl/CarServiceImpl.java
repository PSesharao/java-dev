package com.mindtree.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.mindtree.dao.CarDoa;
import com.mindtree.dao.impl.CarDaoImpl;
import com.mindtree.entity.Car;
import com.mindtree.exception.daoexception.CarDaoException;
import com.mindtree.exception.serviceexception.CarServiceException;
import com.mindtree.service.CarService;

public class CarServiceImpl implements CarService {
	private static CarDoa carDao = new CarDaoImpl();

	@Override
	public boolean insertCarIntoDB(Car car) throws CarServiceException {

		try {
			return carDao.insertCarIntoDB(car);
		} catch (CarDaoException e) {

			throw new CarServiceException("Something is wrong in DB", e);
		}
	}

	@Override
	public List<Car> getCarsByPriceAndColor(double price1, double price2, String color) throws CarServiceException {
		try {
			return carDao.getCarsByPriceAndColor(price1, price2, color);
		} catch (CarDaoException e) {
			throw new CarServiceException("Something is wrong in DB", e);
		}
	}

	@Override
	public String writeCarsToFile(List<Car> carList, String path) throws CarServiceException {
		FileWriter writeFile = null;
		 //= null;
		try {
			writeFile = new FileWriter(path);
			final PrintWriter printWriter = new PrintWriter(writeFile);
			for (int i = 0; i < 45; i++)
				printWriter.print("-");
			printWriter.println();
			printWriter.printf("|%10s|%10s|%10s|%10s|\n", "Id", "Name", "Price", "Color");
			carList.forEach(car -> {
				for (int i = 0; i < 45; i++)
					printWriter.printf("-");
				printWriter.println();
				printWriter.printf("|%10s|%10s|%10s|%10s|\n", car.getId(), car.getName(), car.getPrice(),
						car.getColor());
			});
			for (int i = 0; i < 45; i++)
				printWriter.print("-");
			printWriter.println();
			printWriter.close();
		} catch (IOException e) {
			throw new CarServiceException(e);
		}
		finally {
			try {
				writeFile.close();
			} catch (IOException e) {
				throw new CarServiceException(e);
			}
		}
		return "Successfully written to the file";
	}

	@Override
	public List<Car> getAllCars() throws CarServiceException {
		
		try {
			return carDao.getAllCars();
		} catch (CarDaoException e) {
			throw new CarServiceException("Something is wrong in DB", e);
		}
	}

}
