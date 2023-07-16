package assignment1;

import java.util.Scanner;

public class BinarySearch14 {
	private int [] intArray;
	private int arraySize;
	private String[] stringArray;
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
	
	public boolean findString(String value,String [] theArray){
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex){
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(theArray[middleIndex].compareTo(value) <0) lowIndex = middleIndex + 1;
			
			else if(theArray[middleIndex].compareTo( value) >0) highIndex = middleIndex - 1;
			
			else {
				return true;
			}
						
		}
		return false;
		
	}
	public boolean findElement(int value,int [] theArray){
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex){
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
			
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
			
			else {
				return true;
			}
						
		}
		return false;
		
	}
	private void sortintArray(int [] array) {
		int i,j,temp,num=array.length;
		   for (i = 0; i < num; i++)
		    {
		        for (j = 0; j < (num - i - 1); j++)
		        {
		            if (array[j] > array[j + 1])
		            {
		                temp = array[j];
		                array[j] = array[j + 1];
		                array[j + 1] = temp;
		            }
		        }
		    }
	}
	private void sortStringArray(String [] array) {
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
	private void printintArray() {
		for(int i=0;i<intArray.length;i++)
		{
			System.out.print(intArray[i]+" ");
		}
	}
	private void printStringArray() {
		for(int i=0;i<stringArray.length;i++)
		{
			System.out.print(stringArray[i]+" ");
		}
	}
	BinarySearch14()
	{
		System.out.println("Enter Array size :");
		arraySize=getValidatedPositiveInteger();
		intArray = new int[arraySize];
		stringArray= new String[arraySize];
		System.out.println("Enter the values for integer array :");
		for(int i=0;i<arraySize;i++)
			intArray[i]=getValidatedInteger();
		System.out.println("Enter the values for string array :");
		for(int i=0;i<arraySize;i++)
			stringArray[i]=input.next();
	}
	public static void main(String[] args) {
		BinarySearch14 bsObj = new BinarySearch14();
		bsObj.printintArray();
		System.out.println();
		bsObj.printStringArray();
		System.out.println();
		bsObj.sortintArray(bsObj.intArray);
		
		bsObj.sortStringArray(bsObj.stringArray);
		System.out.println();
		bsObj.printintArray();
		System.out.println();
		
		bsObj.printStringArray();
		
		System.out.println("Enter an integer value to look in array :");
		System.out.println("Hello");
		int key = input.nextInt();
		if(bsObj.findElement(key,bsObj.intArray)!=false)
			System.out.printf("\nThe value found ");
		else
			System.out.printf("\nThe value not found ");
		System.out.println("Enter a string to look into array :");
		String str = input.next();
		if(bsObj.findString(str,bsObj.stringArray)!=false)
			System.out.printf("\nThe value found");
		else
			System.out.printf("\nThe value not found");
	}
}
