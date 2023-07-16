package vowels14;

import java.util.Scanner;

public class ApplicationVowel {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String inputString;
		System.out.println("Enter a string:");
		inputString = input.nextLine();
		VowelOccurence vObj = new VowelOccurence(inputString);
		vObj.vowelOccurence();
	}
}
