package incometax6;

import java.util.Scanner;

public class ApplicationIncomeTax {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int earningOfEmployee;
		System.out.println("Enter the tax to be paid by the employee :");
		earningOfEmployee = getValidatedPositiveInteger();
		IncomeTax callObject = new IncomeTax(earningOfEmployee);
		System.out.println("The tax to be paid by employee is:" + callObject.calculateIncomeTax()+"/-");
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
