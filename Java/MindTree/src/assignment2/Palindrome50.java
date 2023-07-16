package assignment2;

import java.util.Scanner;

public class Palindrome50 {
	Palindrome50(int n)
	{
		int rev=0;
		int d=n;
		while(n!=0)
		{
			rev=rev*10+(n%10);
			n=n/10;
		}
		if(rev == d)
			System.out.println("The number "+d +" is palindrome.");
		else
			System.out.println("The number "+d +" is not palindrome.");
	}
	Palindrome50(String str)
	{
		boolean flag =true ;
		int l = str .length();
		for(int i=0;i<l/2;i++)
			if(str.charAt(i)!=str.charAt(l-1-i))
				flag = false;
		if(flag)
			System.out.println("The string "+str +" is palindrome.");
		else
			System.out.println("The string "+str +" is not palindrome.");
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1. Check given number is palindrome or not");
			System.out.println("2. Check given string is palindrome or not");
			System.out.println("3. Exit");
			System.out.println("Please Enter your choice :");
			int ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter a number :");
				int n= sc.nextInt();
				new Palindrome50(n);
			break;
			case 2:
				System.out.println("Enter a string :");
				String str = sc.next();
				new Palindrome50(str);
			break;
			case 3:
				System.out.println("Adieu Thanks!!!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter the right choice");
			}
		}
	}
}
