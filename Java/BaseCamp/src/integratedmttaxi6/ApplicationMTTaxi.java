package integratedmttaxi6;

import java.util.Scanner;

public class ApplicationMTTaxi {
	private static Scanner input = new Scanner(System.in);
	private static ApplicationMTTaxi appTaxi = new ApplicationMTTaxi();
	public static void main(String[] args) {
		appTaxi.driverMethod();
	}
	
	private void driverMethod() {
		String firstName;
	    int age,choice;
	    String gender;
	    String mobileNumber;
	    int passengerDistance;
	    final int noOfTaxi = 10;
	    Passenger passengerRecord[] = new Passenger[0];
	    Passenger passengerEntry;
	    Taxi taxiRecord[] = new Taxi[noOfTaxi];
	    taxiRecord[0] = new Taxi("MTree001", "Ramesh", 1001, 175);
	    taxiRecord[1] = new Taxi("MTree002", "Paramesh", 1002, 40);
	    taxiRecord[2] = new Taxi("MTree003", "Gopal", 1003, 75);
	    taxiRecord[3] = new Taxi("MTree004", "Shivaji", 1004, 10);
	    taxiRecord[4] = new Taxi("MTree005", "Nagesh", 1005, 130);
	    taxiRecord[5] = new Taxi("MTree006", "Mahesh", 1006, 80);
	    taxiRecord[6] = new Taxi("MTree007", "Ramu", 1007, 150);
	    taxiRecord[7] = new Taxi("MTree008", "Ashish", 1008, 25);
	    taxiRecord[8] = new Taxi("MTree009", "Chandrashekhar", 1009, 100);
	    taxiRecord[9] = new Taxi("MTree0010", "Varma", 1010, 115);
	    insertionSort(taxiRecord);
	    do {
			choice = createMenu();
			switch (choice) {
			case 1:
				firstName = getValidatedInput("firstName");
				age = getValidatedInteger("age");
				gender = getValidatedInput("gender");
				mobileNumber = getValidatedInput("mobileNumber");
				passengerDistance = getValidatedInteger("passengerDistance");
				passengerEntry = new Passenger(firstName, age, gender, mobileNumber, passengerDistance);
				passengerRecord = addEntry(passengerRecord, passengerEntry);
				break;
			case 2:
				System.out.println("Finding nearest taxi for given passenger based on mobile number ");
				mobileNumber = getValidatedInput("mobileNumber");
				int prevHist = getPassenger(passengerRecord, mobileNumber);
				if(prevHist==-1)
				{
					System.out.println("The passenger with mobile number " + mobileNumber + " has not been registered");
				}
				else
				{
					int nearest=getNearestTaxi(passengerRecord[prevHist], taxiRecord);
					taxiRecord[nearest].displayTaxi();
				}
				break;

			case 3:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 3);
	}
	
	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Enter passenger details:");
		System.out.println("2. Find the nearest taxi:");
		System.out.println("3. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}
	
	private Passenger[] addEntry(Passenger passengerRecord[], Passenger passengerEntry) {
		int currLen = passengerRecord.length;
		Passenger temp[] = new Passenger[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = passengerRecord[i];
		temp[currLen] = passengerEntry;
		return temp;
	}
	
	private int getPassenger(Passenger passengerRecord[], String mobileNumber) {
		int prevHist = -1;
		for (int i = 0; i < passengerRecord.length; i++) {
			if (passengerRecord[i].getMobileNumber().compareTo(mobileNumber) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}
	
	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "age":
			do
			{
				isValid = true;
				System.out.println("Enter your age :");
				number =  getValidatedInteger("Integer");
				if(number < 0 || number > 150)
				{
					isValid = false;
					System.out.println("The age is invalid try again!!");
				}
			}while(!isValid);
			return number;
		case "passengerDistance":
			do
			{
				isValid = true;
				System.out.println("Enter the distance of passenger from point X :");
				number =  getValidatedInteger("Integer");
				if(number < 0 || number > 220)
				{
					isValid = false;
					System.out.println("The distance should be in range of 220 !!");
				}
			}while(!isValid);
			return number;
		}
		return -1;
	}
	
	private void insertionSort(Taxi[] theArray) {
		int arraySize = theArray.length;
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			Taxi toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1].getTaxiDistance()>toInsert.getTaxiDistance())) {
				theArray[j] = theArray[j - 1];
				j--;
			}
			theArray[j] = toInsert;
		}
	}
	
	private int getNearestTaxi(Passenger passengerEntry,Taxi taxiRecord[])
	{
		int nearestTaxi=-1,passngDist=passengerEntry.getPassengerDistance();
		int taxiDis1,taxiDis2;
		for(int i=0;i<=taxiRecord.length-2;i++)
		{
			taxiDis1 = taxiRecord[i].getTaxiDistance();
			taxiDis2 = taxiRecord[i+1].getTaxiDistance();
			if(passngDist>= taxiDis1 && passngDist<=taxiDis2)
			{
				if(taxiDis2-passngDist < passngDist-taxiDis1)
					nearestTaxi = i+1;
				else
					nearestTaxi = i;
			}
		}
		if(nearestTaxi == -1) {
			if((taxiRecord[0].getTaxiDistance()-passngDist)>0)
				nearestTaxi = 0;
			else
				nearestTaxi = 9;
		}	
		return nearestTaxi;
	}
	
	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "mobileNumber":
			do {
				isValid = true;
				System.out.println("Enter the mobile number:");
				inputString = input.next();
				if (inputString.length() != 10) {
					System.out.println("The mobile number should be 10 digit long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')) {
							isValid = false;
							System.out.println("Mobile number should be numeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter your name in alphastring :");
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
				System.out.println("Enter your gender:");
				System.out.println("1.Male");
				System.out.println("2.Female");
				inputChoice = getValidatedInteger("Integer");
				if(inputChoice == 1)
					inputString = "Male";
				else if(inputChoice == 2)
					inputString = "Female";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}

}
