package checktriples19;

import java.util.Scanner;

public class ApplicationTriple {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationTriple appTriple = new ApplicationTriple();
		appTriple.driverMethood();
	}
	
	private void driverMethood() {
		int sizeOfArray;
		int[] array;
		System.out.println("Enter the size of array:");
		sizeOfArray = getValidatedPositiveInteger();
		System.out.println("Enter " + sizeOfArray + " elements into array:");
		array = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++)
			array[i] = input.nextInt();
		if(findTriple(array) == false)
			System.out.println("Triple found");
		else
			System.out.println("No triple found");
	}
	
	private boolean findTriple(int[] array) {
		for(int i = 0; i < array.length - 2; i++)
		{
			if(array[i] == array[i+1] && array[i] == array[i+2])
				return false;
		}
		return true;
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
