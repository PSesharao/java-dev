package decimalones9;

import java.util.Scanner;

public class ApplicationDecimalOnes {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		long number = getValidatedNumber();
		DecimalOnes callObject = new DecimalOnes(number);
		System.out.println("The minimum multiple has " + callObject.Ones() + " ones");
	}

	public static long getValidatedNumber() {
		long number;
		do {
			System.out.println("Enter a positive integer :");
			while (!input.hasNextLong()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextLong();
			if (number <= 0)
				System.out.println("You have entered a negative number " + number + " try again.");
			else if (number > 10000)
				System.out.println("Number should be atmost 10000");
			else if (number % 2 == 0)
				System.out.println("Number should not be divisible by 2");
			else if (number % 5 == 0)
				System.out.println("Number should not be divisible by 5");

		} while (number <= 0 || number > 10000 || number % 2 == 0 || number % 5 == 0);
		System.out.printf("You have entered a positive number %d.\n", number);

		return number;
	}
}
