package assignment1;

import java.util.Scanner;

public class ArrayAddition5 {
	private static Scanner input = new Scanner(System.in);
	private double arr1[];
	private double arr2[];
	private int len1;
	private int len2;

	public void readArray() {
		System.out.println("Enter the length of array1 :");
		this.len1 = getValidatedPositiveInteger();
		this.arr1 = new double[len1];
		System.out.println("Enter the elements into array1 :");
		for (int i = 0; i < len1; i++)
			this.arr1[i] = getValidatedDouble();
		System.out.println("Enter the length of array2 :");
		this.len2 = getValidatedPositiveInteger();
		this.arr2 = new double[len2];
		System.out.println("Enter the elements into array2 :");
		for (int i = 0; i < len2; i++)
			this.arr2[i] = getValidatedDouble();
	}

	public double[] addArray() {
		if (len1 > len2) {
			for (int i = 0; i < len2; i++)
				this.arr1[i] += this.arr2[i];
			return this.arr1;
		} else {
			for (int i = 0; i < len1; i++)
				this.arr2[i] += this.arr1[i];
			return this.arr2;
		}
	}

	public void printHorzArray(double theArray[]) {
		int arraySize = theArray.length;
		for (int n = 0; n < 5 * arraySize + 1; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 5 * arraySize + 1; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + (int) theArray[n] + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 5 * arraySize + 1; n++)
			System.out.print("-");

		System.out.println();

	}

	public static double getValidatedDouble() {
		double number;

		System.out.println("Enter a number :");
		while (!input.hasNextDouble()) {
			String userInput = input.next();
			System.out.printf("\"%s\" is not a valid number,try again.\nEnter a number :", userInput);
		}
		number = input.nextDouble();
		System.out.printf("You have entered a number %f.\n", number);
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

	public static void main(String[] args) {
		ArrayAddition5 theArray = new ArrayAddition5();
		theArray.readArray();
		System.out.println("The addition result :");
		theArray.printHorzArray(theArray.addArray());
	}
}
