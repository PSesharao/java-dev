package assignment1;

import java.util.Scanner;

public class Initials17 {
	String str;
	Initials17(String s)
	{
		str = s;
	}
	private String getCompressed1(String str) {
		String compressed= "";
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)>='A' && str.charAt(i)<='Z')
				compressed+=str.charAt(i);
		return compressed;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your full name:");
		String name = sc.nextLine() ; 
		Initials17 c = new Initials17(name);
		System.out.println(c.getCompressed1(c.str));
		sc.close();
	}
}
