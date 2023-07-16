package integratedmuseum2;

import java.util.Scanner;

public class ApplicationMenu {
	public static Scanner input = new Scanner(System.in);
	public static ApplicationMenu museumApp = new ApplicationMenu();

	public static void main(String[] args) {
		museumApp.driverMethod();
	}

	private void driverMethod() {
		String firstName;
		int age;
		String gender;
		int lowerLimit, noOfMale, noOfFemale;
		int upperLimit;
		MyDate dateOfEntry;
		MuseumData museumEntryRecord[] = new MuseumData[0];
		int choice;
		do {
			choice = museumApp.createMenu();
			switch (choice) {
			case 1:
				firstName = getValidatedInput("firstName");
				age = getValidatedInteger("age");
				gender = getValidatedInput("gender");
				dateOfEntry = new MyDate(getValidatedDate());
				MuseumData museumEntry = new MuseumData(firstName, age, gender, dateOfEntry);
				museumEntryRecord = museumApp.addEntry(museumEntryRecord, museumEntry);
				break;
			case 2:
				for (int i = 0; i < museumEntryRecord.length; i++) {
					System.out.println("The entry :" + (i + 1));
					museumEntryRecord[i].displayMuseumEntry();
					System.out.println("The entry fee is :" + museumEntryRecord[i].calculateEntryFee());

				}
				break;
			case 3:
				dateOfEntry = new MyDate(getValidatedDate());
				System.out.println(
						"The museum has " + museumApp.fetchNoOfVisitorsOnGivenDay(museumEntryRecord, dateOfEntry)
								+ " visitors on " + dateOfEntry);
				break;
			case 4:
				System.out.println("Enter the lower age Limit :");
				lowerLimit = getValidatedInteger("age");
				System.out.println("Enter the upper age Limit :");
				upperLimit =  getValidatedInteger("age");
				if (upperLimit > lowerLimit)
					System.out.println("There are "
							+ museumApp.noOfVisitorsBetweenAgeRange(lowerLimit, upperLimit, museumEntryRecord)
							+ " visitors between this age range");
				else
					System.out.println("There are "
							+ museumApp.noOfVisitorsBetweenAgeRange(upperLimit, lowerLimit, museumEntryRecord)
							+ " visitors between this age range");
				break;
			case 5:
				noOfFemale = museumApp.getFemaleCount(museumEntryRecord);
				noOfMale = museumApp.getMaleCount(museumEntryRecord);
				System.out.println("The female male ratio is " + noOfFemale + ":" + noOfMale);
				break;
			case 6:
				dateOfEntry = new MyDate(getValidatedDate());
				System.out.println("The total earning on given date is :"
						+ museumApp.getTotalEarningOnGivenDay(museumEntryRecord, dateOfEntry));
				break;
			case 7:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 7);
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Enter new museum visitor record");
		System.out.println("2. Calculate Entry Fee");
		System.out.println("3. Fetch number of visitors on the given day");
		System.out.println("4. Fetch number of visitors within age range");
		System.out.println("5. Fetch the ratio of female vs male visitors");
		System.out.println("6. Fetch the total earning on given day from the museum");
		System.out.println("7. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
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
		}
		return -1;
	}
	
	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
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


	private MuseumData[] addEntry(MuseumData museumEntryRecord[], MuseumData museumEntry) {
		int currLen = museumEntryRecord.length;
		MuseumData temp[] = new MuseumData[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = museumEntryRecord[i];
		temp[currLen] = museumEntry;
		return temp;
	}

	private int fetchNoOfVisitorsOnGivenDay(MuseumData[] museumEntryRecord, MyDate dateOfEntry) {
		int noOfVistors = 0;
		for (int i = 0; i < museumEntryRecord.length; i++) {
			if (museumEntryRecord[i].getDateOfEntry().getDate().compareTo(dateOfEntry.getDate()) == 0)
				noOfVistors++;
		}
		return noOfVistors;
	}

	private int getMaleCount(MuseumData[] museumEntryRecord) {
		int noOfMale = 0;
		for (int i = 0; i < museumEntryRecord.length; i++)
			if (museumEntryRecord[i].getGender().compareTo("MALE") == 0)
				noOfMale++;
		return noOfMale;
	}

	private int getTotalEarningOnGivenDay(MuseumData[] museumEntryRecord, MyDate dateOfEntry) {
		int todayEarning = 0;
		for (int i = 0; i < museumEntryRecord.length; i++)
			if (museumEntryRecord[i].getDateOfEntry().getDate().compareTo(dateOfEntry.getDate()) == 0)
				todayEarning += museumEntryRecord[i].calculateEntryFee();
		return todayEarning;
	}

	private int getFemaleCount(MuseumData[] museumEntryRecord) {
		int noOfFemale = 0;
		for (int i = 0; i < museumEntryRecord.length; i++)
			if (museumEntryRecord[i].getGender().compareTo("FEMALE") == 0)
				noOfFemale++;
		return noOfFemale;
	}

	private int noOfVisitorsBetweenAgeRange(int lowerLimit, int upperLimit, MuseumData[] museumEntryRecord) {
		int noOfVisitors = 0;
		for (int i = 0; i < museumEntryRecord.length; i++)
			if (museumEntryRecord[i].getAge() >= lowerLimit && museumEntryRecord[i].getAge() <= upperLimit)
				noOfVisitors++;
		return noOfVisitors;
	}

	private String getValidatedDate() {
		String inputDate;
		boolean isValidTime, isLeapYear;
		int days, months, years;
		do {
			isValidTime = true;
			System.out.println("Enter the date in the DD-MM-YYYY format");
			inputDate = input.next();
			if (inputDate.length() != 10) {
				isValidTime = false;
				System.out.println("Length should be exactly 10");
			} else if (inputDate.charAt(2) != '-' || inputDate.charAt(5) != '-') {
				isValidTime = false;
				System.out.println("The separator should be '-'");
			} else if (!((inputDate.charAt(0) >= '0' && inputDate.charAt(0) <= '9')
					&& (inputDate.charAt(1) >= '0' && inputDate.charAt(1) <= '9'))) {
				System.out.println("The days should be numeric");
				isValidTime = false;
			} else if (!((inputDate.charAt(3) >= '0' && inputDate.charAt(3) <= '9')
					&& (inputDate.charAt(4) >= '0' && inputDate.charAt(4) <= '9'))) {
				System.out.println("The months should be numeric");
				isValidTime = false;
			} else if (!((inputDate.charAt(6) >= '0' && inputDate.charAt(6) <= '9')
					&& (inputDate.charAt(7) >= '0' && inputDate.charAt(7) <= '9')
					&& (inputDate.charAt(8) >= '0' && inputDate.charAt(8) <= '9')
					&& (inputDate.charAt(9) >= '0' && inputDate.charAt(9) <= '9'))) {
				System.out.println("The years should be numeric");
				isValidTime = false;
			} else {
				days = (inputDate.charAt(0) - '0') * 10 + (inputDate.charAt(1) - '0');
				months = (inputDate.charAt(3) - '0') * 10 + (inputDate.charAt(4) - '0');
				years = (inputDate.charAt(6) - '0') * 10 + (inputDate.charAt(7) - '0')
						+ (inputDate.charAt(8) - '0') * 10 + (inputDate.charAt(9) - '0');
				if (days < 0 || days > 31) {
					isValidTime = false;
					System.out.println("Days should be atleast 1 and atmost 31");
				} else if (months < 0 || months > 12) {
					isValidTime = false;
					System.out.println("Months should be atleast 1 and atmost 12");
				} else {
					if ((years % 4 == 0 && years % 100 != 0) || years % 400 == 0)
						isLeapYear = true;
					else
						isLeapYear = false;
					switch (months) {
					case 1:
						break;
					case 2:
						if (isLeapYear) {
							if (days > 29) {
								isValidTime = false;
								System.out.println("February should have atmost 29 days in leap year");
							}
						} else {
							if (days > 28) {
								isValidTime = false;
								System.out.println("February should have atmost 28 days in not leap year");
							}
						}
						break;
					case 3:
						break;
					case 4:
						if (days > 30) {
							isValidTime = false;
							System.out.println("April should have atmost 30 days");
						}
						break;
					case 5:
						break;
					case 6:
						if (days > 30) {
							isValidTime = false;
							System.out.println("June should have atmost 30 days");
						}
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						if (days > 30) {
							isValidTime = false;
							System.out.println("September should have atmost 30 days");
						}
						break;
					case 10:
						break;
					case 11:
						if (days > 30) {
							isValidTime = false;
							System.out.println("November should have atmost 30 days");
						}
						break;
					case 12:
						break;
					default:
						System.out.println("Month is invalid");
					}

				}
			}

		} while (!isValidTime);
		System.out.println("You have entered the valid date!!");
		return inputDate;
	}
}
