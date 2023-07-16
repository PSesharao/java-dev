package naturalnumsquare7;

import java.util.Scanner;

public class ApplicationNaturalSquare {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int arraySize;
		int theArray[];
		System.out.println("Enter the size of the array :");
		arraySize = getValidatedArraySize();
		theArray = new int[arraySize];
		System.out.println("Enter the elements into the array:");
		for (int i = 0; i < arraySize; i++)
			theArray[i] = getValidatedArrayElement();
		NaturalNumSquare callObject = new NaturalNumSquare(arraySize, theArray);
		int theSquares[] = callObject.computeSquare();
		printArray(theArray, theSquares);
	}

	public static void printArray(int[] theArray, int[] theSquares) {
		int arraySize = theArray.length;
		System.out.println("----------");
		for (int i = 0; i < arraySize; i++) {

			System.out.print("| " + theArray[i] + " | ");
			System.out.println(theSquares[i] + " |");

			System.out.println("----------");

		}

	}

	public static int getValidatedArraySize() {
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
			else if (number > 10)
				System.out.println("The array size should be at most 10" + " try again.");
		} while (number < 0 || number > 10);
		System.out.printf("You have entered the array size %d.\n", number);

		return number;
	}

	public static int getValidatedArrayElement() {
		int number;
		do {
			System.out.println("Enter a positive integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a positive integer :", userInput);
			}
			number = input.nextInt();
			if (number < 1)
				System.out.println("You have entered " + number + " is not a natural number try again.");
			else if (number > 10)
				System.out.println("The element should be at most 10" + " try again.");
		} while (number < 1 || number > 10);
		System.out.printf("You have entered the element %d.\n", number);
		return number;
	}

}
