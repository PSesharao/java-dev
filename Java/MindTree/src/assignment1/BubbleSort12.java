package assignment1;

import java.util.Scanner;

public class BubbleSort12 {
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

	private static int[] bubbleSort(int array[]) {
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
		return array;
	}

	public static void main(String[] args) {
		int[] arr;
		int l;
		System.out.println("Enter the length of array :");
		l = getValidatedPositiveInteger();
		arr = new int[l];
		System.out.println("Enter the elements into array :");
		for (int i = 0; i < l; i++)
			arr[i] = getValidatedInteger();
		arr = bubbleSort(arr);
		dispalyArray(arr);
	}

	private static void dispalyArray(int[] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++)
			if (i == 0)
				System.out.print(arr[i]);
			else
				System.out.print("," + arr[i]);
	}
}
