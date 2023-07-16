package appendstring18;

import java.util.Scanner;

public class ApplicationAppend {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationAppend appStr = new ApplicationAppend();
		appStr.driverMethod();
	}

	private void driverMethod() {
		String inputString;
		int noOfCopies;
		System.out.println("Enter a string");
		inputString = input.next();
		System.out.println("Enter no of copies ");
		noOfCopies = getValidatedPositiveInteger();
		System.out.println("The required appended string is :" + getAppendedStr(inputString, noOfCopies));
	}

	public String getAppendedStr(String string, int noOfCopies) {
		int lengthOfStr = string.length();
		String frontStr = "";
		for (int i = 0; i < 3; i++)
			frontStr += string.charAt(i);
		String result = "";
		if (lengthOfStr <= 3) {
			for (int i = 0; i < noOfCopies; i++)
				result += string;
		} else {
			for (int j = 0; j < noOfCopies; j++)
				result += frontStr;
		}
		return result;
	}

	public int getValidatedPositiveInteger() {
		int number;
		do {
			System.out.println("Enter a positive integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextInt();
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
		} while (number < 0);
		return number;
	}

}
