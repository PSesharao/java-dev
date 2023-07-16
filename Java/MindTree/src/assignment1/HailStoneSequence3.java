package assignment1;

import java.util.Scanner;

public class HailStoneSequence3 {
	private static Scanner input = new Scanner(System.in);

	public int f(int number) {
		if (number % 2 == 0) {
			System.out.printf("%d is even so i take half :%d\n", number, number / 2);
			return number / 2;
		} else {
			System.out.printf("%d is odd so i make 3n+1 :%d\n", number, 3 * number + 1);
			return 3 * number + 1;
		}
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

	public HailStoneSequence3(int number) {
		int steps = 0;
		while (number != 1) {
			number = this.f(number);
			steps++;
		}
		System.out.printf("There are totally %d steps to reach 1", steps);
	}

	public static void main(String[] args) {
		int number = getValidatedInteger();
		new HailStoneSequence3(number);
		input.close();
	}
}
