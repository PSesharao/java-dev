package assignment1;

import java.util.Scanner;

public class ArraySum4 {
	private static Scanner input = new Scanner(System.in);
	private int a[];
	private int l;

	public static int getValidatedInteger() {
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


	ArraySum4() {
		int s = 0;
		System.out.println("Enter the length of the array :");
		l = getValidatedPositiveInteger();
		a = new int[l];
		System.out.println("Enter the elements into array :");
		for (int i = 0; i < l; i++) {
			a[i] = getValidatedInteger();
			s += a[i];
		}
		System.out.println("The sum of the array is :" + s);
		input.close();
	}

	public static void main(String[] args) {
		new ArraySum4();
	}
}
