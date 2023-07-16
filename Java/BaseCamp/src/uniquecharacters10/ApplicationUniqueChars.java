package uniquecharacters10;

import java.util.Scanner;

public class ApplicationUniqueChars {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String inputString;
		System.out.println("Enter a string :");
		inputString = input.next();
		UniqueChars callObject = new UniqueChars(inputString);
		if (callObject.isUnique())
			System.out.println("The string " + "\"" + inputString + "\"" + " is unique");
		else
			System.out.println("The string " + "\"" + inputString + "\"" + " is not unique");
	}
}
