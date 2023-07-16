package circularstring3;

import java.util.Scanner;

public class ApplicationCircularString {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		 String firstString;
		 String secondString;
		 System.out.println("Enter the first string :");
		 firstString = input.next();
		 System.out.println("Enter the second string :");
		 secondString = input.next();
		 CircularString callingObj = new CircularString(firstString, secondString);
		 if(callingObj.circularityCheck())
			 System.out.println("\"" +callingObj.getFirstString()+ "\""+" and "+
		 "\""+callingObj.getSecondString()+"\""+" are circular");
		 else
			 System.out.println("\"" +callingObj.getFirstString()+ "\""+" and "+
					 "\""+callingObj.getSecondString()+"\""+" are not circular");
	}
}
