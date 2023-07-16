package assignment1;

import java.util.Scanner;

public class GetMax7{
		private static Scanner input = new Scanner(System.in);
		GetMax7(int a,int b,int c)
		{
			if(a>b && a>c)
				System.out.println(a);
			else if(b>c)
				System.out.println(b);
			else
				System.out.println(c);
		}
		private static int getValidatedInteger() {
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
		public static void main(String[] args) {
			
			System.out.println("Enter 3 integers :");
			System.out.println("a :");
			int a=getValidatedInteger();
			System.out.println("b :");
			int b=getValidatedInteger();
			System.out.println("c :");
			int c=getValidatedInteger();
			System.out.println("The maximum of 3 is :");
			new GetMax7(a,b,c);
			input.close();
		}
}
