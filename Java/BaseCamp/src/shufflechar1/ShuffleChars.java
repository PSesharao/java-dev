package shufflechar1;

import java.util.Scanner;

public class ShuffleChars {
	private String inputString;
	public static Scanner input = new Scanner(System.in);

	public ShuffleChars(String inputString) {
		this.inputString = inputString;
	}

	public static String getValidatedAlphaString() {
		String inputString;
		boolean isAlphabet;
		do {
			System.out.println("Enter a alphastring :");
			inputString = input.next();
			isAlphabet = true;
			for (int i = 0; i < inputString.length(); i++)
				if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
						|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
					isAlphabet = false;
					break;
				}
			if (!isAlphabet)
				System.out.println("You have not entered a alphastring!Try again!!");
		} while (!isAlphabet);
		System.out.println("You have entered a alphastring");
		return inputString;
	}

	public String getShuffledChar() {
		int front = 0;
		int rear = inputString.length() - 1;
		boolean frontTurn = true;
		String shuffledString = "";
		while (front <= rear) {
			if (frontTurn) {
				if (inputString.charAt(front) >= 'A' && inputString.charAt(front) <= 'Z')
					shuffledString +=(char) (inputString.charAt(front) - 'A' + 'a');
				else
					shuffledString +=(char)(inputString.charAt(front));
				front++;
				frontTurn = false;
			} else {
				if (inputString.charAt(rear) >= 'a' && inputString.charAt(rear) <= 'z')
					shuffledString += (char)(inputString.charAt(rear) - 'a' + 'A');
				else
					shuffledString += (char)(inputString.charAt(rear));
				rear--;
				frontTurn = true;
			}
		}
		return shuffledString;
	}
}
