package assignment1;

import java.util.Scanner;

public class ReverseNum8 {
	private static Scanner input = new Scanner(System.in);

	ReverseNum8(String decimalNumber) {
		int length = decimalNumber.length();
		for (int index = length - 1; index >= 0; index--)
			System.out.print(decimalNumber.charAt(index));
	}

	public static String getValidatedPositiveDouble() {
		double number;
		String numberString;
		do {
			System.out.println("Enter a number :");
			while (!input.hasNextDouble()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a number :", userInput);
			}
			numberString = input.next();
			number = Double.parseDouble(numberString);
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
			System.out.printf("You have entered a number %s.\n", numberString);
		} while (number < 0);
		return numberString;
	}

	public static void main(String[] args) {
		String decimalNumber = getValidatedPositiveDouble();
		new ReverseNum8(decimalNumber);
		input.close();
	}
}
