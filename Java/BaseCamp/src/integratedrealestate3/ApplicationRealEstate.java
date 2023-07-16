package integratedrealestate3;

import java.util.Scanner;

public class ApplicationRealEstate {
	private static Scanner input = new Scanner(System.in);
	private static ApplicationRealEstate appRealEstate = new ApplicationRealEstate();

	public static void main(String[] args) {
		appRealEstate.driverMethod();
	}

	private void driverMethod() {
		int choice;
		int typeOfBHK;
		String accomodationType;
		String housingType;
		RealEstate realEstateArray[] = new RealEstate[0];
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				typeOfBHK = getValidatedInteger("typeOfBHK");
				accomodationType = getValidatedInput("accomodationType");
				housingType = getValidatedInput("housingType");
				RealEstate realEstateRecord = new RealEstate(typeOfBHK, accomodationType, housingType);
				realEstateArray = addEntry(realEstateArray, realEstateRecord);
				break;
			case 2:
				System.out.println("Enter the type of accommdation to fetch the records:");
				accomodationType = getValidatedInput("accomodationType");
				RealEstate[] accomArray = getAllRecordsOfAccomType(realEstateArray, accomodationType);
				if (accomArray.length == 0)
					System.out.println("No records available of type " + accomodationType);
				else {
					for (int i = 0; i < accomArray.length; i++)
						accomArray[i].displayRealEstateRecord();
				}
				break;
			case 3:
				System.out.println("Enter the type of BHK to fetch the records:");
				typeOfBHK = getValidatedInteger("typeOfBHK");
				RealEstate[] bHKArray = getAllRecordsOfBHKType(realEstateArray, typeOfBHK);
				if (bHKArray.length == 0)
					System.out.println("No records available of type " + typeOfBHK);
				else {
					for (int i = 0; i < bHKArray.length; i++)
						bHKArray[i].displayRealEstateRecord();
				}
				break;
			case 4:
				System.out.println("Enter the type of housing to fetch the records:");
				housingType = getValidatedInput("housingType");
				RealEstate[] housingArray = getAllRecordsOfAccomType(realEstateArray, housingType);
				if (housingArray.length == 0)
					System.out.println("No records available of type " + housingType);
				else {
					for (int i = 0; i < housingArray.length; i++)
						housingArray[i].displayRealEstateRecord();
				}
				break;
			case 5:
				System.out.println("Enter the type of BHK and type of accommdation to fetch the records:");
				typeOfBHK = getValidatedInteger("typeOfBHK");
				accomodationType = getValidatedInput("accomodationType");
				RealEstate[] bhkAccmArray = getAllRecordsOfbhkAccom(realEstateArray, typeOfBHK, accomodationType);
				if (bhkAccmArray.length == 0)
					System.out.println("No records available of type " + typeOfBHK + " and " + accomodationType);
				else {
					for (int i = 0; i < bhkAccmArray.length; i++)
						bhkAccmArray[i].displayRealEstateRecord();
				}
				break;
			case 6:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 6);
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Add a new entry in real estate");
		System.out.println("2. Categorize the listing based on \"To Let\" (Rent) and \"For Sale\" (Sale)");
		System.out.println("3. Categorize the listing based on 1BHK, 2BHK and 3BHK");
		System.out.println("4. Categorize the listing based on \"Apartment Flat\" and \"Individual house\"");
		System.out.println("5. Categorize the listings based on both \"BHK type\" and \"accomodationType\"");
		System.out.println("6. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private RealEstate[] getAllRecordsOfbhkAccom(RealEstate[] realEstateArray, int typeOfBHK, String accomodationType) {
		RealEstate[] bhkAccomArray = new RealEstate[0];
		for (int i = 0; i < realEstateArray.length; i++)
			if (realEstateArray[i].getAccomodationType().compareTo(accomodationType) == 0
					&& realEstateArray[i].getTypeOfBHK() == typeOfBHK)
				bhkAccomArray = addEntry(bhkAccomArray, realEstateArray[i]);
		return bhkAccomArray;
	}

	private RealEstate[] getAllRecordsOfAccomType(RealEstate[] realEstateArray, String accomodationType) {
		RealEstate[] accomArray = new RealEstate[0];
		for (int i = 0; i < realEstateArray.length; i++)
			if (realEstateArray[i].getAccomodationType().compareTo(accomodationType) == 0)
				accomArray = addEntry(accomArray, realEstateArray[i]);
		return accomArray;
	}

	private RealEstate[] getAllRecordsOfBHKType(RealEstate[] realEstateArray, int typeOfBHK) {
		RealEstate[] bHKArray = new RealEstate[0];
		for (int i = 0; i < realEstateArray.length; i++)
			if (realEstateArray[i].getTypeOfBHK() == typeOfBHK)
				bHKArray = addEntry(bHKArray, realEstateArray[i]);
		return bHKArray;
	}

	private RealEstate[] addEntry(RealEstate realEstateArray[], RealEstate realEstateRecord) {
		int currLen = realEstateArray.length;
		RealEstate temp[] = new RealEstate[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = realEstateArray[i];
		temp[currLen] = realEstateRecord;
		return temp;
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		int inputChoice;
		boolean isValid;
		switch (validationType) {
		case "accomodationType":
			do {
				isValid = true;
				System.out.println("Enter the accommodation type:");
				System.out.println("1.To Let");
				System.out.println("2.For Sale");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "To Let";
				else if (inputChoice == 2)
					inputString = "For Sale";
				else {
					System.out.println("Wrong input try again");
					isValid = false;
					inputString = null;
				}
			} while (!isValid);
			return inputString;
		case "housingType":
			do {
				isValid = true;
				System.out.println("Enter the housing type:");
				System.out.println("1.ApartmentFlat");
				System.out.println("2.IndividualHouse");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "ApartmentFlat";
				else if (inputChoice == 2)
					inputString = "IndividualHouse";
				else {
					System.out.println("Wrong input try again");
					isValid = false;
					inputString = null;
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}

	public int getValidatedInteger(String validationType) {
		int number = -1;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			System.out.printf("You have entered the number %d.\n", number);
			return number;
		case "typeOfBHK":
			do {
				isValid = true;
				System.out.println("Enter 1 for 1 BHK type");
				System.out.println("Enter 2 for 2 BHK type");
				System.out.println("Enter 3 for 3 BHK type");
				number = getValidatedInteger("Integer");
				if (number > 3 || number < 1)
					isValid = false;
			} while (!isValid);
			return number;
		}
		return number;
	}

}
