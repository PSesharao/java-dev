package exceptiondemo;

import java.util.Scanner;

public class ApplicationException {
	private static Scanner input = new Scanner(System.in); 
	public static void main(String[] args) {
		ApplicationException appEx = new ApplicationException();
		appEx.driverMethod();
	}

	private void driverMethod() {
		int number ;
		System.out.println("Enter a positive number :");
		number = input.nextInt();
		try {
			checkNumber(number);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void checkNumber(int number) throws Exception
	{
		if((number&1) == 1)
			throw new OddNumberException("This is odd number ");
		else
			throw new EvenNumberException("This is even number ");
	}
}
