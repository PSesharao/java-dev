package formcircularstring4;

import java.util.Scanner;

public class ApplicationFormCircularString {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String inputString;
		int inputNumber;
		System.out.println("Enter a string:");
		inputString = input.next();
		System.out.println("Enter a number:");
		inputNumber = input.nextInt();
		FormCircularString callObject = new FormCircularString(inputString, inputNumber);
		String circularStringArray[] = callObject.generateCircularStrings();
		String distinctCircularArray[] = callObject.generateDistinctCircularStrings(circularStringArray);
		System.out.println("The all possible distinct circular strings of " + "length " + inputNumber
				+ " from a given string " + "\"" + inputString + "\"" + " are :");
		for (int i = 0; i < distinctCircularArray.length; i++)
			System.out.println(distinctCircularArray[i]);
	}
}
