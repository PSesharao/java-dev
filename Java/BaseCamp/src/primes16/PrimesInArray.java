package primes16;

import java.util.Scanner;

public class PrimesInArray {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		PrimesInArray appPrime = new PrimesInArray();
		appPrime.driverMethod();
	}
	
	private void driverMethod() {
		int primes[] = new int[0];
		int sizeOfArray ;
		int[] array;
		System.out.println("Enter the size of array:");
		sizeOfArray = getValidatedPositiveInteger();
		System.out.println("Enter "+sizeOfArray +" elements into array:");
		array = new int[sizeOfArray];
		for(int i=0;i<sizeOfArray;i++)
			array[i] = getValidatedPositiveInteger();
		for(int i=0;i<sizeOfArray;i++)
			if(isPrime(array[i]))
				primes = addPrime(primes, array[i]);
		System.out.println("The primes in the array are :");
		
		for(int i=0;i<primes.length;i++)
			System.out.print(primes[i]+" ");
	}

	public boolean isPrime(long number) {
		if (number == 1)
			return false;
		for (int i = 2; i*i <= number; i++) // i< number
			if (number % i == 0)
				return false;
		return true;
	}
	
	public  int[] addPrime(int primes[], int prime) {
		int currLength = primes.length;
		int temp[] = new int[currLength + 1];
		for (int i = 0; i < currLength; i++)
			temp[i] = primes[i];
		temp[currLength] = prime;
		return temp;
	}
	
	public int getValidatedPositiveInteger() {
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
