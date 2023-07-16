package assignment1;

import java.util.Scanner;

public class Area11 {
	private static Scanner input = new Scanner(System.in);

	public static double getValidatedPositiveDouble() {
		double number;
		do {
			System.out.println("Enter a number :");
			while (!input.hasNextDouble()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter a number :", userInput);
			}
			number = input.nextDouble();
			if (number < 0)
				System.out.println("You have entered a negative number " + number + " try again.");
			System.out.printf("You have entered a number %f.\n", number);
		} while (number < 0);
		return number;
	}

	public String stringLower(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				s += Character.toString((char) (str.charAt(i) - 'A' + 'a'));
			else 
				s += Character.toString(str.charAt(i));
		}
		return s;
	}

	Area11() {
		String fig;
		do {
			System.out.println("Enter the figure name 'Triangle/Square/Rectangle/Circle'");
			fig = input.next();
			fig = stringLower(fig);
			switch (fig) {
			case "triangle": {
				System.out.println("Enter s :");
				double s = getValidatedPositiveDouble();
				System.out.println("Enter h :");
				double h = getValidatedPositiveDouble();
				System.out.printf("The area is %.2f\n", .5 * s * h);
				break;
			}
			case "square": {
				System.out.println("Enter length of s :");
				double s = getValidatedPositiveDouble();
				System.out.printf("The area is %.2f\n", s * s);
				break;
			}
			case "rectangle": {
				System.out.println("Enter w :");
				double w = getValidatedPositiveDouble();
				System.out.println("Enter h :");
				double h = getValidatedPositiveDouble();
				System.out.printf("The area is %.2f\n", w * h);
				break;
			}
			case "circle": {
				System.out.println("Enter r :");
				double r = getValidatedPositiveDouble();
				System.out.printf("The area is %.2f\n", 3.14 * r * r);
				break;
			}
			default:
				System.out.println("Sorry!! Enter the figure name again!!!");
			}
		} while (!(fig.equalsIgnoreCase("Triangle") || fig.equalsIgnoreCase("Square")
				|| fig.equalsIgnoreCase("Rectangle") || fig.equalsIgnoreCase("Circle")));
	}

	public static void main(String[] args) {

		new Area11();
		input.close();
	}
}