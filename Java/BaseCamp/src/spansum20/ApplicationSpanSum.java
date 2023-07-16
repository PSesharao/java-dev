package spansum20;

import java.util.Scanner;

public class ApplicationSpanSum {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationSpanSum spanApp = new ApplicationSpanSum();
		spanApp.driverCode();
	}
	
	private void driverCode() {
		int sizeOfArray ;
		int[] array;
		System.out.println("Enter the size of array:");
		sizeOfArray = getValidatedPositiveInteger();
		System.out.println("Enter "+sizeOfArray +" elements into array:");
		array = new int[sizeOfArray];
		for(int i=0;i<sizeOfArray;i++)
			array[i] = getValidatedPositiveInteger();
		System.out.println("The sum of span of array is :"+spanSum(array));
	}
	
	public int spanSum(int[] array) 
	{
		int maxSpan = 0;
		int sumOfspan=0;
		int span;
		int j,startIndex=-1,endIndex=-1;
		for(int i = 0; i < array.length; i++)
		{
			for(j = array.length - 1; array[i] != array[j]; j--);
			span = 1 + j - i;
			if(span > maxSpan)
				{
				   maxSpan = span;
				   startIndex = i;
				   endIndex = j;
				}
		}
		for(int i=startIndex;i<endIndex;i++)
			sumOfspan +=array[i];
		return sumOfspan;
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
