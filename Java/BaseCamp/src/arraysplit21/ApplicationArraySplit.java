package arraysplit21;

import java.util.Scanner;

public class ApplicationArraySplit {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationArraySplit appSplit = new ApplicationArraySplit();
		appSplit.driverCode();
	}

	private void driverCode() {
		int sizeOfArray;
		int[] array;
		System.out.println("Enter the size of array:");
		sizeOfArray = getValidatedPositiveInteger();
		System.out.println("Enter " + sizeOfArray + " elements into array:");
		array = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++)
			array[i] = input.nextInt();
		System.out.println("The array is :");
		for (int i = 0; i < sizeOfArray; i++)
			System.out.print(array[i] + " ");
		int position = findIndex(array);
		System.out.println();
		if (position == -1)
			System.out.println("There is no such position in array");
		else
			System.out.println("We can split array at position " + (position) + " into two equal halves");
	}

	private int findIndex(int arr[]) {
		int size = arr.length;
		int right_sum = 0, left_sum = 0;
		for (int i = 0; i < size; i++)
			right_sum += arr[i];
		for (int i = 0; i < size; i++) {
			right_sum -= arr[i];
			if (left_sum == right_sum)
				return i + 1;
			left_sum += arr[i];
		}

		return -1;
	}

	public int getValidatedPositiveInteger() {
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
		return number;
	}

}
