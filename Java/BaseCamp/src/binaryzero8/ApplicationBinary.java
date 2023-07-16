package binaryzero8;

import java.util.Scanner;

public class ApplicationBinary {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int number = getValidatedPositiveInteger();

		BinaryZeros callObj = new BinaryZeros(number);

		System.out.println("The number " + number + " has " + callObj.noOfBinaryZeros() + " zeroes in binary form");
	}

	public static int getValidatedPositiveInteger() {
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
		System.out.printf("You have entered a positive number %d.\n", number);

		return number;
	}
}
