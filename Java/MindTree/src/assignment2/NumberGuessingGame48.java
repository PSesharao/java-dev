package assignment2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame48 {
	public static void main(String[] args) {
		Random r = new Random();
		int guessingNumber = r.nextInt(1000);
		int noOfTries = 0;
		Scanner sc =new Scanner(System.in);
		int n;
		boolean flag =false;
		while(flag ==false)
		{
			System.out.println("Pick a number between 1 to 1000");
			n=sc.nextInt();
			noOfTries++;
			if(n  == guessingNumber)
				flag = true;
			else if(n<guessingNumber)
				System.out.println("Too low");
			else
				System.out.println("Too high");
			
		}
		System.out.println("You win!!!");
		System.out.println("The number was "+guessingNumber);
		System.out.println("It took "+ noOfTries+ "attempts to guess  correctly");
		sc.close();
	}
}
