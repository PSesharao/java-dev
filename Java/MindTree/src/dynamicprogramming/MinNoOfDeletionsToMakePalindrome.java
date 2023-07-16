package dynamicprogramming;

import java.util.Scanner;

/*Given a string of size ‘n’. The task is to remove or delete minimum number 
of characters from the string so that the resultant string is palindrome.
Examples :

Input : aebcbda
Output : 2
Remove characters 'e' and 'd'
Resultant string will be 'abcba'
which is a palindromic string
It's nothing but length-lps
*/
public class MinNoOfDeletionsToMakePalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string :");
		String string1 = sc.next();
		String string2 = reverseString(string1); // Take 2 nd string as reverse of first string and perform reverse.
		int length1 = string1.length();
		int length2 = string2.length();
		int lps = longestPalindromicSubSequence(string1,string2,length1,length2);
		System.out.println("The no of deletions required to make "+string1+" palindrome is :"+(length1-lps));
		sc.close();
	}

	private static int longestPalindromicSubSequence(String string1, String string2, int length1, int length2) {
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
					t[len1][len2] = Math.max(t[len1][len2-1],t[len1-1][len2]);
			}
		
		return t[length1][length2];
	}
	private static String reverseString(String string) {
		String reverse = "";
		for(int pos =string.length()-1 ;pos >=0 ; pos--)
			reverse+=string.charAt(pos);
		return reverse;
	}
}
