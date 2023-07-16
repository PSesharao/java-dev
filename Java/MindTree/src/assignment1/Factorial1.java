package assignment1;

import java.util.Scanner;

public class Factorial1 {
	private static Scanner input = new Scanner(System.in);

	public static int[] factorial(int number) {
		int factArray[] = new int[1000];
		int length = 1, digit, product, carry;
		factArray[0] = 1;
		for (int multiple = 2; multiple <= number; multiple++) {
			carry = 0;
			for (int result = 0; result < length; result++) {
				product = multiple * factArray[result] + carry;
				digit = product % 10;
				carry = product / 10;
				factArray[result] = digit;
			}
			while (carry != 0) {
				length++;
				digit = carry % 10;
				factArray[length - 1] = digit;
				carry /= 10;
			}
		}

		factArray[length] = -1;
		return factArray;
	}

	public static int lengthOfFactorial(int factArray[]) {
		int length = 0;
		while (factArray[length] != -1)
			length++;
		return length;
	}

	public static int getValidatedInteger() {
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

	public static void main(String[] args) {
		
		int number = getValidatedInteger();
		int factArray[] = factorial(number);
		int length = lengthOfFactorial(factArray);
		System.out.println("The factorial of " + number + " is :");
		for (int l = length - 1; l >= 0; l--)
			System.out.print(factArray[l]);

		input.close();
	}

}
