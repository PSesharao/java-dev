package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.Flight;
import com.mindtree.entity.Passenger;
import com.mindtree.exception.clientexception.SameSourceAndDestinationException;
import com.mindtree.exception.serviceexception.AirlineServiceException;
import com.mindtree.service.AirlineService;
import com.mindtree.service.impl.AirlineServiceImpl;

public class AirlineApp {
	private static Scanner input = new Scanner(System.in);
	private static AirlineService airSer = new AirlineServiceImpl();

	public static void main(String[] args) {
		AirlineApp app = new AirlineApp();
		List<Flight> flightList = new ArrayList<Flight>();
		int choice;
		do {
			choice = app.createMenu();
			switch (choice) {
			case 1:
				System.out.println(app.enterNewFlight(flightList));
				break;
			case 2:
				System.out.println("Enter passenger age :");
				int age = app.getValidatedInteger("age");
				System.out.println("Enter passenger gender :");
				String gender = app.getValidatedInput("gender");
				List<Passenger> passList = null;
				try {
					passList = airSer.getPassengersByGenderAndAge(age, gender);
				} catch (AirlineServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (passList != null)
					app.displayPassengers(passList);
				else
					System.out.println("Passenger list is empty.");
				break;
			case 3:
				List<Flight> flightL = null;
				System.out.println("Enter destination :");
				String destination = app.getValidatedInput("city");
				try {
					flightL = airSer.getFlightsByDestination( destination);
				} catch (AirlineServiceException e) {
					e.printStackTrace();
				}
				if (flightL != null)
					app.displayFlights(flightL);
				else
					System.out.println("Flight list is empty.");
				break;
			case 4:
				System.out.println("Exiting !!");
				break;
			default:
				System.out.println("Wrong choice,Try again");
			}
		} while (choice != 4);
	}

	private String enterNewFlight(List<Flight> flightList)
	{
		Flight flight = getFlightDetails();
		Passenger passenger = null;
		boolean insertToFlight = false;
		boolean insertToPassenger = false;
		flight.setPassengerList(new ArrayList<>());
		try {
			insertToFlight = airSer.insertIntoFlightDB(flight);
		} catch (AirlineServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (insertToFlight) {
			System.out.println("Flight got inserted into DB successfully ");
			System.out.println("Enter no of passengers :");
			int noOfPass = getValidatedInteger("no");
			for (int i = 0; i < noOfPass; i++) {
				System.out.println("Enter passenger " + (i + 1) + " details ");
				passenger = getPassengerDetails();
				passenger.setFlight(flight);
				try {
					insertToPassenger = airSer.insertIntoPassengerDB(passenger);
				} catch (AirlineServiceException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (insertToPassenger) {
					flight.getPassengerList().add(passenger);
					System.out.println("passenger data " + (i + 1) + " got inserted successfully ");

				} else {
					System.out.println("passenger data " + (i + 1) + " did not get inserted successfully ");
				}
			}
			flightList.add(flight);
			return "New flight has been added successfully";
		} else {
			System.out.println("Flight did not get inserted into DB successfully ");
		}
		return "New flight insertion not successfull";
	}
	
	private void displayFlights(List<Flight> flightL) {
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%10s|%10s|%10s|\n", "Id", "Name", "Source", "Destination");
		flightL.forEach(flight -> {
			for (int i = 0; i < 45; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%10s|%10s|%10s|\n", flight.getId(), flight.getName(), flight.getSource(), flight.getDestination());
		});
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
	}

	private void displayPassengers(List<Passenger> passList) {
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();
		System.out.printf("|%10s|%10s|%10s|%10s|\n", "Id", "Name", "Age", "Gender");
		passList.forEach(pass -> {
			for (int i = 0; i < 45; i++)
				System.out.printf("-");
			System.out.println();
			System.out.printf("|%10s|%10s|%10s|%10s|\n", pass.getId(), pass.getName(), pass.getAge(), pass.getGender());
		});
		for (int i = 0; i < 45; i++)
			System.out.print("-");
		System.out.println();

	}
	
	private int createMenu() {
		int choice;
		System.out.println("\n--------------------------AIRLINE APPLICATION------------------------------------");
		System.out.println("Enter your choice:");
		System.out.println("1. Add new Flight");
		System.out.println("2. get Passengers By Gender And Age ");
		System.out.println("3. get Flights By Destination");
		System.out.println("4. Exit\n");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			// System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "age":
			do {
				isValid = true;
				// System.out.println("Enter artist age :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 150) {
					isValid = false;
					System.out.println("The age is invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "no":
			do {
				isValid = true;
				// System.out.println("Enter size :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 50) {
					isValid = false;
					System.out.println("The size invalid try again!!");
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}

	private Flight getFlightDetails() {
		boolean isValid = true;
		System.out.println("Enter flight Id :");
		String id = getValidatedInput("id");
		System.out.println("Enter flight name :");
		String name = getValidatedInput("airline");
		String source;
		String destination;
		do {
			isValid = true;
			System.out.println("Enter source :");
			source = getValidatedInput("city");
			System.out.println("Enter destination :");
			destination = getValidatedInput("city");
			try {
				if (source.compareTo(destination) == 0) {
					isValid = false;
					throw new SameSourceAndDestinationException("The source and destination are same");
				}
			} catch (SameSourceAndDestinationException e) {
				e.printStackTrace();
			}
		} while (!isValid);
		return new Flight(id, name, source, destination);

	}

	private Passenger getPassengerDetails() {
		System.out.println("Enter passenger Id :");
		String id = getValidatedInput("id");
		System.out.println("Enter passenger name :");
		String name = getValidatedInput("name");
		System.out.println("Enter passenger age :");
		int age = getValidatedInteger("age");
		System.out.println("Enter passenger gender :");
		String gender = getValidatedInput("gender");
		return new Passenger(id, name, age, gender);
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "name":
			do {
				isValid = true;
				// System.out.println("Enter name in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		case "gender":
			do {
				isValid = true;
				// System.out.println("Enter your gender:");
				System.out.println("1.Male");
				System.out.println("2.Female");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Male";
				else if (inputChoice == 2)
					inputString = "Female";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "id":
			do {
				isValid = true;
				// System.out.println("Enter the id:");
				inputString = input.next();
				if (inputString.length() > 10) {
					System.out.println("The id should not be more than 10 character long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')
								&& !(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
								&& !(inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')) {
							isValid = false;
							System.out.println("id should be alphanumeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		case "city":
			do {
				isValid = true;
				// System.out.println("Choose the destination:");
				System.out.println("1. Newyork");
				System.out.println("2. Singapore");
				System.out.println("3. Malaysia");
				System.out.println("4. London");
				System.out.println("5. Germany");
				System.out.println("6. Australia");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Newyork";
				else if (inputChoice == 2)
					inputString = "Singapore";
				else if (inputChoice == 3)
					inputString = "Malaysia";
				else if (inputChoice == 4)
					inputString = "London";
				else if (inputChoice == 5)
					inputString = "Germany";
				else if (inputChoice == 6)
					inputString = "Australia";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again");
				}
			} while (!isValid);
			return inputString;
		case "airline":
			do {
				isValid = true;
				System.out.println("Choose the airline:");
				System.out.println("1. Qatar Airlines");
				System.out.println("2. Cathey Pacific Airlines");
				System.out.println("3. Emirates Airlines");
				System.out.println("4. Hainan Airlines");
				System.out.println("5. Qantas Airlines");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Qatar";
				else if (inputChoice == 2)
					inputString = "Cathey";
				else if (inputChoice == 3)
					inputString = "Emirates";
				else if (inputChoice == 4)
					inputString = "Hainan";
				else if (inputChoice == 5)
					inputString = "Qantas";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again");
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}

}
