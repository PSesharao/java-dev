package assignment1;

import java.util.Scanner;

public class InsertionSort15 {
	private int [] theArray;
	int arraySize;
	public static Scanner input = new Scanner(System.in);
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
	public void insertionSort(){
		for (int i = 1; i < arraySize; i++){
			  int j = i;
			  int toInsert = theArray[i];
			  while ((j > 0) && (theArray[j-1] > toInsert)){
				  theArray[j] = theArray[j-1];
				  j--;
			  }
			  theArray[j] = toInsert;
		}
	}
	InsertionSort15(int n)
	{
		theArray = new int[n];
		arraySize=n;
		System.out.println("Enter array values :");
		for(int i=0;i<n;i++)
		{
			theArray[i]=getValidatedInteger();
		}
	}
	private void printArray() {
		for(int i=0;i<theArray.length;i++)
			System.out.println(theArray[i]);
	}
	public static void main(String[] args) {
		System.out.println("Enter the length of array :");
		int l = getValidatedPositiveInteger();
		InsertionSort15 sort = new InsertionSort15(l);
		sort.printArray();
		sort.insertionSort();
		sort.printArray();
	}
}
