package assignment1;

import java.util.Scanner;

public class IntegerSearch13 {
	private static Scanner input = new Scanner(System.in);

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

	public boolean binarySearchForValue(int value, int[] theArray) {
		int arraySize = theArray.length;
		int lowIndex = 0;
		int highIndex = arraySize - 1;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;

			if (theArray[middleIndex] < value)
				lowIndex = middleIndex + 1;

			else if (theArray[middleIndex] > value)
				highIndex = middleIndex - 1;

			else {

				// System.out.println("\nFound a Match for " + value + " at Index " +
				// middleIndex);

				// lowIndex = highIndex + 1;
				return true;
			}

		}
		return false;

	}

	private void sortintArray(int[] array) {
		int i, j, temp, num = array.length;
		for (i = 0; i < num; i++) {
			for (j = 0; j < (num - i - 1); j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int a[], l, v;

		System.out.println("Enter the length of the array :");
		l = getValidatedPositiveInteger();
		a = new int[l];
		System.out.println("Enter the elements into array :");
		for (int i = 0; i < l; i++)
			a[i] = getValidatedInteger();

		System.out.println("Enter the value to search :");
		v = getValidatedInteger();
		IntegerSearch13 obj = new IntegerSearch13();
		obj.sortintArray(a);
		obj.binarySearchForValue(v, a);
		input.close();
	}
}
