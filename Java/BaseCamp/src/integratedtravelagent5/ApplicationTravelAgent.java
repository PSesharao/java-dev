package integratedtravelagent5;

import java.util.Scanner;

public class ApplicationTravelAgent {
	private static Scanner input = new Scanner(System.in);
	private static ApplicationTravelAgent appTraveller = new ApplicationTravelAgent();

	public static void main(String[] args) {
		appTraveller.driverMethod();
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Enter traveller details:");
		System.out.println("2. Find most preferred destination:");
		System.out.println("3. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private void driverMethod() {
		int choice;
		String firstName;
		String mobileNumber;
		String typeOfJourney;
		String airline;
		MyDate depatureTime;
		MyDate arrivalTime;
		String source;
		String destination;
		boolean isValid;
		String[] destinationArray = { "Newyork", "Singapore", "Malaysia", "London", "Germany", "Australia" };
		Traveller travellerRecord[] = new Traveller[0];
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				firstName = getValidatedInput("firstName");
				mobileNumber = getValidatedInput("mobileNumber");
				typeOfJourney = getValidatedInput("typeOfJourney");
				airline = getValidatedInput("airline");
				do {
					isValid = true;
					System.out.println("Enter depature date and time :");
					depatureTime = new MyDate(getValidatedDate(), getValidatedTime());
					System.out.println("Enter arrival date and time :");
					arrivalTime = new MyDate(getValidatedDate(), getValidatedTime());
					if (hoursDifference(arrivalTime, depatureTime) <= 0) {
						isValid = false;
						System.out.println("Arrival time should be greater than depature time,try again!!");
					}
				} while (!isValid);
				source = getValidatedInput("source");
				destination = getValidatedInput("destination");
				Traveller travellerEntry = new Traveller(firstName, mobileNumber, typeOfJourney, airline, depatureTime,
						arrivalTime, source, destination);
				travellerRecord = addEntry(travellerRecord, travellerEntry);
				break;
			case 2:
				int prefIndex = findMostPreferredDestination(travellerRecord, destinationArray);
				if (prefIndex == -1) {
					System.out.println("No traveller has registered yet in the record");
				} else
					System.out.println(destinationArray[prefIndex] + " is the most preferred destination");
				break;

			case 3:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 3);
	}

	private int findMostPreferredDestination(Traveller[] travellerRecord, String[] destinationArray) {
		int prefDest = -1, destCount, maxCount = -1;
		for (int i = 0; i < destinationArray.length; i++) {
			destCount = 0;
			for (int j = 0; j < travellerRecord.length; j++) {
				if (destinationArray[i].compareTo(travellerRecord[j].getDestination()) == 0)
					destCount++;
				if (destCount > maxCount) {
					maxCount = destCount;
					prefDest = i;
				}
			}
		}
		return prefDest;
	}

	private Traveller[] addEntry(Traveller travellerRecord[], Traveller travellerEntry) {
		int currLen = travellerRecord.length;
		Traveller temp[] = new Traveller[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = travellerRecord[i];
		temp[currLen] = travellerEntry;
		return temp;
	}

	private int getValidatedInteger(String validationType) {
		int number;
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
		case "typeOfJourney":
			do {
				isValid = true;
				System.out.println("Enter the type of journey:");
				System.out.println("1. one way");
				System.out.println("2. return");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "one way";
				else if (inputChoice == 2)
					inputString = "return";
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
		case "source":
			do {
				isValid = true;
				System.out.println("Choose the source:");
				System.out.println("1. Delhi");
				System.out.println("2. Mumbai");
				System.out.println("3. Chennai");
				System.out.println("4. Hyderabad");
				System.out.println("5. Bangalore");
				System.out.println("6. Vishakapatnam");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Delhi";
				else if (inputChoice == 2)
					inputString = "Mumbai";
				else if (inputChoice == 3)
					inputString = "Chennai";
				else if (inputChoice == 4)
					inputString = "Hyderabad";
				else if (inputChoice == 5)
					inputString = "Bangalore";
				else if (inputChoice == 6)
					inputString = "Vishakapatnam";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again");
				}
			} while (!isValid);
			return inputString;
		case "destination":
			do {
				isValid = true;
				System.out.println("Choose the destination:");
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
		}
		return null;
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
				if (months < 0 || months > 12) {
					isValidTime = false;
					System.out.println("Months should be atleast 1 and atmost 12");
				} else {
					if ((years % 4 == 0 && years % 100 != 0) || years % 400 == 0)
						isLeapYear = true;
					else
						isLeapYear = false;
					switch (months) {
					case 1:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("January should have atmost 31 days");
						}
						break;
					case 2:
						if (isLeapYear) {
							if (days > 29 || days < 0) {
								isValidTime = false;
								System.out.println("February should have atmost 29 days in leap year");
							}
						} else {
							if (days > 28 || days < 0) {
								isValidTime = false;
								System.out.println("February should have atmost 28 days in not leap year");
							}
						}
						break;
					case 3:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("March should have atmost 31 days");
						}
						break;
					case 4:
						if (days > 30 || days < 0) {
							isValidTime = false;
							System.out.println("April should have atmost 30 days");
						}
						break;
					case 5:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("May should have atmost 31 days");
						}
						break;
					case 6:
						if (days > 30 || days < 0) {
							isValidTime = false;
							System.out.println("June should have atmost 30 days");
						}
						break;
					case 7:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("July should have atmost 31 days");
						}
						break;
					case 8:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("August should have atmost 31 days");
						}
						break;
					case 9:
						if (days > 30 || days < 0) {
							isValidTime = false;
							System.out.println("September should have atmost 30 days");
						}
						break;
					case 10:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("October should have atmost 31 days");
						}
						break;
					case 11:
						if (days > 30 || days < 0) {
							isValidTime = false;
							System.out.println("November should have atmost 30 days");
						}
						break;
					case 12:
						if (days > 31 || days < 0) {
							isValidTime = false;
							System.out.println("December should have atmost 31 days");
						}
						break;
					default:
						System.out.println("Month is invalid");
					}

				}
			}

		} while (!isValidTime);
		return inputDate;
	}

	private String getValidatedTime() {
		String inputString;
		boolean isValidTime;
		int hours, minutes;
		do {
			isValidTime = true;
			System.out.println("Enter the time in HH:MM 24 hour format :");
			inputString = input.next();
			if (inputString.length() != 5) {
				isValidTime = false;
				System.out.println("The length of string should be exactly 5 try again");
			} else if (!((inputString.charAt(0) >= '0' && inputString.charAt(0) <= '9')
					|| (inputString.charAt(1) >= '0' && inputString.charAt(1) <= '9')
					|| (inputString.charAt(3) >= '0' && inputString.charAt(3) <= '9')
					|| (inputString.charAt(4) >= '0' && inputString.charAt(4) <= '9'))) {
				System.out.println("The hours and minutes should be integers.");
				isValidTime = false;
			} else {
				hours = (inputString.charAt(0) - '0') * 10 + (inputString.charAt(1) - '0');
				minutes = (inputString.charAt(3) - '0') * 10 + (inputString.charAt(4) - '0');
				if (hours < 0 || hours >= 24) {
					isValidTime = false;
					System.out.println("Hours should be atmost 23 and atleast 0");
				}
				if (minutes < 0 || minutes >= 60) {
					isValidTime = false;
					System.out.println("Minutes should be atmost 59 and atleast 0");
				}
			}
		} while (!isValidTime);
		return inputString;
	}

	private int countNoOfLeapYearsBefore(MyDate date) {
		int years = date.getYears();
		if (date.getMonths() <= 2)
			years -= 1;
		return years / 4 - years / 100 + years / 400;
	}

	private int hoursDifference(MyDate firstDate, MyDate secondDate) {
		int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		long noOfDaysUptoFirstYear, noOfDaysUptoSecondYear;

		noOfDaysUptoFirstYear = firstDate.getYears() * 365 + firstDate.getDays();

		for (int i = 0; i < firstDate.getMonths() - 1; i++)
			noOfDaysUptoFirstYear += monthDays[i];

		noOfDaysUptoFirstYear += countNoOfLeapYearsBefore(firstDate);

		noOfDaysUptoSecondYear = secondDate.getYears() * 365 + secondDate.getDays();

		for (int i = 0; i < secondDate.getMonths() - 1; i++)
			noOfDaysUptoSecondYear += monthDays[i];

		noOfDaysUptoSecondYear += countNoOfLeapYearsBefore(secondDate);

		long hours1, hours2;
		hours1 = noOfDaysUptoFirstYear * 24 + (firstDate.getHours() * 60 + firstDate.getMinutes()) / 60;
		hours2 = noOfDaysUptoSecondYear * 24 + (secondDate.getHours() * 60 + secondDate.getMinutes()) / 60;
		return (int) (hours1 - hours2);
	}

}
