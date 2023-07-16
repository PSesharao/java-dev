package assignment1;

import java.util.Scanner;

public class Table2 {
	private static Scanner input = new Scanner(System.in);

	public static void generateTable(int n) {
		for (int i = 1; i <= 12; i++)
			System.out.printf("%d x %-2d = %-2d\n", n, i, n * i);
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
		generateTable(number);
		input.close();
	}
}
