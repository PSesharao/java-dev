package com.mindtree.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.Car;
import com.mindtree.exception.serviceexception.CarServiceException;
import com.mindtree.service.CarService;
import com.mindtree.service.impl.CarServiceImpl;

public class CarJDBCApplication {
	private static Scanner input = new Scanner(System.in);
	private static CarService carSer = new CarServiceImpl();

	public static void main(String[] args) {
		CarJDBCApplication app = new CarJDBCApplication();
		app.driverMethod();
	}

	private void driverMethod() {
		int choice;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				boolean isInsertedSuccessfully = false;
				try {
					isInsertedSuccessfully = carSer.insertCarIntoDB(getCarDetails());
				} catch (CarServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (isInsertedSuccessfully)
					System.out.println("Car got inserted successfully");
				else
					System.out.println("Something went wrong");
				break;
			case 2:
				System.out.println("Enter lower limit price :");
				double price1 = input.nextDouble();
				System.out.println("Enter upper limit price :");
				double price2 = input.nextDouble();
				System.out.println("Enter color :");
				String color = input.next();
				List<Car> carRec = null;
				try {
					carRec = carSer.getCarsByPriceAndColor(price1, price2, color);
				} catch (CarServiceException e) {

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (carRec != null)
					displayCars(carRec);
				else
					System.out.println("The car Record is empty ");
				break;
			case 3:
				final String PATH = "C:\\Users\\RR COMPUTERS\\Desktop\\carsOutput.txt";
				List<Car> carList = null;
				try {
					carList = carSer.getAllCars();
				} catch (CarServiceException e) {

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (carList != null)
					try {
						System.out.println(carSer.writeCarsToFile(carList, PATH));
					} catch (CarServiceException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				else
					System.out.println("The car Record is empty ");
				break;
			case 4:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Wrong choice try again");
			}
		} while (choice != 4);
	}

	private void displayCars(List<Car> carRec) {
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%10s|%10s|%10s|\n", "Id", "Name", "Price", "Color");
		carRec.forEach(car -> {
			for (int i = 0; i < 45; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%10s|%10s|%10s|\n", car.getId(), car.getName(), car.getPrice(), car.getColor());
		});
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
	}

	private int createMenu() {
		int choice;
		System.out.println("\nEnter your choice:");
		System.out.println("1. Enter car details:");
		System.out.println("2. Get cars based on price and color :");
		System.out.println("3. Write all cars to a file");
		System.out.println("4. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private int getValidatedInteger(String validationType) {
		int number;
		// boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		}
		return -1;
	}

	private Car getCarDetails() {
		System.out.println("Enter the car Id :");
		int id = input.nextInt();
		System.out.println("Enter car name :");
		String name = input.next();
		System.out.println("Enter car price");
		double price = input.nextDouble();
		System.out.println("Enter car color");
		String color = input.next();
		return new Car(id, name, price, color);
	}

}
