package arrayfix24;

import java.util.Scanner;

public class ApplicationRearrange {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationRearrange fixApp = new ApplicationRearrange();
		fixApp.driverCode();
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
		rearrangeArray(array);
		System.out.println("The array after rearranging :");
		for (int i = 0; i < sizeOfArray; i++)
			System.out.print(array[i] + " ");
	}

	private void rearrangeArray(int[] array) {
		int length = array.length;
		int indexOf4 = 0;
		int indexOf3;
		for (indexOf3 = 0; indexOf3 < length - 1; indexOf3++) {
			if (array[indexOf3] == 3 && array[indexOf3 + 1] != 4) {
				while (array[indexOf4] != 4)
					indexOf4++;
				array[indexOf4] = array[indexOf3 + 1];
				array[indexOf3 + 1] = 4;
			}
		}
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
