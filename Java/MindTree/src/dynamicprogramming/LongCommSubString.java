package dynamicprogramming;

import java.util.Scanner;

/*Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
Examples:

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
The longest common substring is “Geeks” and is of length 5.*/
public class LongCommSubString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string1 :");
		String string1 = sc.next();
		System.out.println("Enter string2 :");
		String string2 = sc.next();
		int length1 = string1.length();
		int length2 = string2.length();
		int lcs = longestCommonSubString(string1,string2,length1,length2);
		System.out.println("The length of longest common substring of "+string1+","+string2 +" is :"+lcs);
		sc.close();
	}
	private static int longestCommonSubString(String string1, String string2, int length1, int length2) {
		int t[][] = new int[length1+1][length2+1];
		// Initialization 
		for(int len1 = 0;len1 <= length1 ;len1++)
			for(int len2 = 0;len2 <= length2 ; len2++)
				if(len1 == 0 || len2 == 0)
					t[len1][len2] = 0 ;
		// remaining table 
		for(int len1 = 1;len1 <= length1 ;len1++)
			for(int len2 = 1;len2 <= length2 ; len2++)
				{
					if(string1.charAt(len1-1) == string2.charAt(len2-1))
						t[len1][len2] = 1+t[len1-1][len2-1]; 
					else 
						t[len1][len2] = 0;// if a mismatch found
				}
			/*
			 * at last we have to return the max value in the matrix and not t[m][n]. Just
			 * traverse through the matrix once and store max value in a variable and return
			 * that. Why it is so? Cuz substring can exist anywhere in between.
			 */
		int lcs = -1;
		for(int len1 = 0;len1 <= length1 ;len1++)
			for(int len2 = 0;len2 <= length2 ; len2++)
			{
				if(t[len1][len2]>lcs) 
					lcs = t[len1][len2];
			}
		return lcs;
	}
}
