package dynamicprogramming;

import java.util.Scanner;

/*Given two strings ‘str1’ and ‘str2’ of size m and n respectively. 
The task is to remove/delete and insert minimum number of characters 
from/in str1 so as to transform it into str2. It could be possible that the 
same character needs to be removed/deleted from one point of str1 and inserted 
to some another point.

Examples:

Input : str1 = "heap", str2 = "pea" 
Output : Minimum Deletion = 2 and
         Minimum Insertion = 1*/
public class Min_Ins_DelToMakeStr1_Str2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string1 :");
		String string1 = sc.next();
		System.out.println("Enter string2 :");
		String string2 = sc.next();
		int length1 = string1.length();
		int length2 = string2.length();
		int lcs = longestCommonSubSequence(string1,string2,length1,length2);
		int minimum_no_of_deletions = length1-lcs;
		/* First make "heap" to "ea" , deleting two characters*/
		int minimum_no_of_insertions = length2 - lcs;
		/* Next make "ea" to "pea" by adding , 1 character */
		System.out.println("The minimum number of deletions :"+minimum_no_of_deletions);
		System.out.println("The minimum number of deletions :"+minimum_no_of_insertions);
		sc.close();
	}
	private static int longestCommonSubSequence(String string1, String string2, int length1, int length2) {
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
}
