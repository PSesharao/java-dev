package clock11;

import java.util.Scanner;

public class ApplicationClock {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String inputString;
		System.out.println("Enter time in HH:MM format");
		inputString = getValidatedTime();
		ClockDiff callObject = new ClockDiff(inputString);
		System.out.println("The drift angle difference for " + "\"" + inputString + "\"" + " is:"
				+ callObject.getAngleDifference() + " degrees");
	}

	public static String getValidatedTime() {
		String inputString;
		boolean isValidTime;
		int hours, minutes;
		do {
			isValidTime = true;
			System.out.println("Enter a string :");
			inputString = input.next();
			if (inputString.length() != 5) {
				isValidTime = false;
				System.out.println("The length of string should be exactly 5 try again");
			} else if (inputString.charAt(2) != ':') {
				isValidTime = false;
				System.out.println("The separator should be ':'.try agin");
			} else if (!((inputString.charAt(0) >= '0' && inputString.charAt(0) <= '9')
					|| (inputString.charAt(1) >= '0' && inputString.charAt(1) <= '9')
					|| (inputString.charAt(3) >= '0' && inputString.charAt(3) <= '9')
					|| (inputString.charAt(4) >= '0' && inputString.charAt(4) <= '9'))) {
				System.out.println("The hours and minutes should be integers.");
				isValidTime = false;
			}
			else {
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
		System.out.println("You have entered a valid time");
		return inputString;
	}
}
