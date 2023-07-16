package assignment1;

import java.util.Scanner;

public class Insertion_BubbleSorts16 {
	private static Scanner input = new Scanner(System.in);
	private void bubbleSortStringArray(String [] array) {
		int i,j,num=array.length;
		String temp;
		   for (i = 0; i < num; i++)
		    {
		        for (j = 0; j < (num - i - 1); j++)
		        {
		            if (array[j].compareTo(array[j + 1])>0)
		            {
		                temp = array[j];
		                array[j] = array[j + 1];
		                array[j + 1] = temp;
		            }
		        }
		    }
	}
	public void insertionSortStringArray(String [] theArray){
		int arraySize = theArray.length;
		for (int i = 1; i < arraySize; i++){
			  int j = i;
			  String toInsert = theArray[i];
			  while ((j > 0) && (theArray[j-1].compareTo(toInsert)>0)){
				  theArray[j] = theArray[j-1];
				  j--;
			  }
			  theArray[j] = toInsert;
		}
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
	private void printStringArray(String stringArray []) {
		for(int i=0;i<stringArray.length;i++)
		{
			System.out.println(stringArray[i]);
		}
	}
	public static void main(String[] args) {
		System.out.println("Enter Array size :");
		int arraySize=getValidatedPositiveInteger();
		String[] stringArray= new String[arraySize];
		System.out.println("Enter the values for string array :");
		for(int i=0;i<arraySize;i++)
			stringArray[i]=input.next();
		Insertion_BubbleSorts16 b = new Insertion_BubbleSorts16();
		b.bubbleSortStringArray(stringArray);
		b.printStringArray(stringArray);
		b.insertionSortStringArray(stringArray);
		b.printStringArray(stringArray);
	}
	
}
