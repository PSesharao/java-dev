package assignment1;

import java.util.Scanner;

//import java.util.Arrays;

public class LastNameSwap19 {
	private String firstName;
	private String lastName;
	private String[] fname = new String[2];
	private String[] lname = new String[2];
	LastNameSwap19(String s1,String s2)
	{
		firstName = s1;
		lastName = s2;
	}
	private String[] getString(String name) {
		String temp="";
		String [] names = new String[2];
		int len=0;
		for(int i=0;i<name.length();i++)
		{
			if(name.charAt(i)==' ' || (i==name.length()-1))  {
				//System.out.println(temp);
				if(i==name.length()-1) {temp+=name.charAt(i);names[len++]=temp;}
				else {
				names[len++]=temp;
				temp = "";
				}
			}
			else
				temp+=name.charAt(i);
		}
		return names;
	}
	private void printNames()
	{
		System.out.println("Name 1 : "+firstName);
		System.out.println("Name 2 : "+lastName);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name1 :");
		String name1=sc.nextLine();
		//sc.nextLine();
		System.out.println("Enter your name2 :");
		String name2=sc.nextLine();
		sc.close();
		LastNameSwap19 l = new LastNameSwap19(name1,name2);
		l.fname = l.getString(l.firstName);
		l.lname = l.getString(l.lastName);
		l.printNames();
		//System.out.println(Arrays.toString(l.fname));
		//System.out.println(Arrays.toString(l.lname));
		l.firstName = l.fname[0]+" "+l.lname[1];
		l.lastName = l.lname[0] +" "+l.fname[1];
		l.printNames();
	}
}
