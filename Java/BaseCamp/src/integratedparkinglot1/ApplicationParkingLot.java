package integratedparkinglot1;

import java.util.Scanner;

public class ApplicationParkingLot {
	public static Scanner input = new Scanner(System.in);
	public static ApplicationParkingLot parkingApp = new ApplicationParkingLot();

	public static void main(String[] args) {
		parkingApp.driverMethod();
	}

	private void driverMethod() {
		String vehicleNumber;
		int freeSlotIndex, index;
		int parkingTime;
		MyDate entryTime;
		MyDate firstDate;
		MyDate secondDate;
		ParkingLot parkingSlots[] = new ParkingLot[100];
		for (int i = 0; i < 100; i++)
			parkingSlots[i] = new ParkingLot(true);
		int choice;
		do {
			choice = parkingApp.createMenu();
			switch (choice) {
			case 1:
				System.out.println("The free parking slots are :");
				for (int i = 0; i < 100; i++)
					if (parkingSlots[i].isAvailable())
						System.out.println("Slot " + (i + 1));
				break;
			case 2:
				vehicleNumber = getValidatedInput("vehicleNumber");
				System.out.println("Enter the entry date and time:");
				entryTime = new MyDate(getValidatedDate(), getValidatedTime());
				freeSlotIndex = -1;
				for (int i = 0; i < 100; i++)
					if (parkingSlots[i].isAvailable()) {
						freeSlotIndex = i;
						break;
					}
				if (freeSlotIndex == -1)
					System.out.println("No slot is available");
				else {
					parkingSlots[freeSlotIndex] = new ParkingLot(vehicleNumber, entryTime);
					parkingSlots[freeSlotIndex].setAvailable(false);
					System.out.println("The slot " + (freeSlotIndex + 1) + " has been alloted for parking");
				}
				break;
			case 3:
				System.out.println("Enter the vehicle number to be exited :");
				vehicleNumber = getValidatedInput("vehicleNumber");
				for (index = 0; index < 100; index++)
					if (parkingSlots[index].getVehicleNumber().compareTo(vehicleNumber) == 0)
						break;
				if (index < 100) {
					System.out.println("The slot " + (index + 1) + " has been freed");
					parkingSlots[index].setAvailable(true);
					firstDate = parkingSlots[index].getEntryTime();
					System.out.println("Enter the exit date and time:");
					secondDate = new MyDate(getValidatedDate(), getValidatedTime());
					parkingTime = hoursDifference(firstDate, secondDate);
					if (parkingTime <= 2)
						System.out.println("The entry fee for vehicle is 50");
					else {
						System.out.println("The entry fee for vehicle is " + (parkingTime - 2) * 30);
					}
				}
				break;
			case 4:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 4);
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Check for the available parking");
		System.out.println("2. Allocate an empty slot for parking for a vehicle");
		System.out.println("3. Calculate the parking fee on exit");
		System.out.println("4. Exit");
		choice = getValidatedInteger();
		return choice;
	}
	
	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		switch (validationType) {
		case "vehicleNumber":
			do {
				isValid = true;
				System.out.println("Enter the vehicle number:");
				inputString = input.next();
				if (inputString.length() > 10) {
					System.out.println("The mobile number should not be more than 10 character long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') && !(inputString.charAt(i) >= 'A' && inputString.charAt(i)<='Z') && !(inputString.charAt(i) >= 'a' && inputString.charAt(i)<='z')) {
							isValid = false;
							System.out.println("vehicle number should be alphanumeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		}
		return null;
	}
	
	private int getValidatedInteger() {
		int number;

		System.out.println("Enter an integer :");
		while (!input.hasNextInt()) {
			String userInput = input.next();
			System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
		}
		number = input.nextInt();
		System.out.printf("You have entered a number %d.\n", number);
		return number;
	}

	public int countNoOfLeapYearsBefore(MyDate date) {
		int years = date.getYears();
		if (date.getMonths() <= 2)
			years -= 1;
		return years / 4 - years / 100 + years / 400;
	}

	public int hoursDifference(MyDate firstDate, MyDate secondDate) {
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
		return (int) (hours1 > hours2 ? hours1 - hours2 : hours2 - hours1);
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
}
