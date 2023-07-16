package mirrorcopy17;

import java.util.Scanner;

public class ApplicationMirror {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationMirror appMirror = new ApplicationMirror();
		appMirror.driverMethod();
	}
	
	private void driverMethod() {
		int sizeOfArray;
		String [] stringArray;
		sizeOfArray = getValidatedPositiveInteger();
		System.out.println("Enter "+sizeOfArray +" strings into array:");
		stringArray = new String[sizeOfArray];
		for(int i=0;i<sizeOfArray;i++)
		{
			System.out.println("Enter the string "+(i+1)+" into array :");
			stringArray[i] = input.next();
		}
		System.out.println("The original Array :");
		
		for(int i=0;i<sizeOfArray;i++)
			System.out.print(stringArray[i] + " ");
		
		reverseStrings(stringArray);
		reverseArray(stringArray);
		System.out.println();
		System.out.println("The mirror Array :");
		for(int i=0;i<sizeOfArray;i++)
			System.out.print(stringArray[i] + " ");
	}
	
	private void reverseArray(String[] stringArray) {
		int lenArray = stringArray.length;
		String temp;
		for(int i=0;i<lenArray/2;i++)
		{
			temp = stringArray[i];
			stringArray[i] = stringArray[lenArray-1-i];
			 stringArray[lenArray-1-i] = temp;
		}
	}

	private void reverseStrings(String[] stringArray) {
		String original,reverse;
		int lenOfStr;
		for(int i=0;i<stringArray.length;i++)
		{
			original = stringArray[i];
			lenOfStr = original.length();
			reverse = "";
			for(int j=lenOfStr-1;j>=0;j--)
				reverse+=original.charAt(j);
			stringArray[i] = reverse;
		}
	}
	
	private int getValidatedPositiveInteger() {
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
