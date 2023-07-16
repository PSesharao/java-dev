package assignment1;

import java.util.Scanner;

public class IsPrime9 {
	private static Scanner input = new Scanner(System.in);

	public static long getValidatedPositiveInteger() {
		long number;
		do {
			System.out.println("Enter a positive integer :");
			while (!input.hasNextLong()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextLong();
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
		} while (number < 0);
		System.out.printf("You have entered a positive number %d.\n", number);

		return number;
	}

	public static boolean isPrime(long number) {
		if (number == 1)
			return false;
		for (int i = 2; i <= (int) Math.sqrt(number); i++) // i< number
			if (number % i == 0)
				return false;
		return true;
	}

	IsPrime9(long number) {
		System.out.println(isPrime(number));
	}

	public static void main(String[] args) {

		System.out.println("Enter an interger ");
		long number = getValidatedPositiveInteger();
		new IsPrime9(number);
		input.close();
	}
}