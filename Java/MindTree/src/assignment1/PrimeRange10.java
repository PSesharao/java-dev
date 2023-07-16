package assignment1;

import java.util.Scanner;

public class PrimeRange10 {
	private static Scanner input = new Scanner(System.in);
	
	public static int[] primeRange(int lowerlimit, int upperlimit) {
		int primes[] = new int[0];
		for (int number = lowerlimit; number <= upperlimit; number++)
			if (IsPrime9.isPrime(number))
				primes = addPrime(primes, number);
		return primes;
	}

	public static int[] addPrime(int primes[], int prime) {
		int currLength = primes.length;
		int temp[] = new int[currLength + 1];
		for (int i = 0; i < currLength; i++)
			temp[i] = primes[i];
		temp[currLength] = prime;
		return temp;
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

	public static void displayPrimes(int[] primesList) {
		int length = primesList.length;
		if (length == 0)
			System.out.println("No primes in between given range");
		else {
			for (int i = 0; i < primesList.length; i++) {
				if (i == 0)
					System.out.print(primesList[i]);
				else
					System.out.print("," + primesList[i]);
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Enter lower limit :");
		int lowerlimit = getValidatedPositiveInteger();
		System.out.println("Enter upper limit :");
		int upperlimit = getValidatedPositiveInteger();
		int primesList[] = primeRange(lowerlimit, upperlimit);
		displayPrimes(primesList);
		input.close();
	}

}
