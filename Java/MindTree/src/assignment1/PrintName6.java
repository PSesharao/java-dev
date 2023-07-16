package assignment1;

import java.util.Scanner;

public class PrintName6 {
	public static void printName(String name)
	{
		System.out.println("Hello, "+name+"!");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name :");
		String name = sc.nextLine();
		sc.close();
		printName(name);
	}
}
