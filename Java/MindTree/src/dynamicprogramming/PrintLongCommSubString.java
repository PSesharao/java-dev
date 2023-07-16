package dynamicprogramming;
import java.util.Scanner;
/*Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
Examples:

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
The longest common substring is “Geeks” and is of length 5.*/
public class PrintLongCommSubString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string1 :");
		String string1 = sc.next();
		System.out.println("Enter string2 :");
		String string2 = sc.next();
		int length1 = string1.length();
		int length2 = string2.length();
		String lcs = longestCommonSubString(string1,string2,length1,length2);
		System.out.println("The longest common substring of "+string1+","+string2 +" is :"+lcs);
		sc.close();
	}

	private static String longestCommonSubString(String string1, String string2, int length1, int length2) {
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
		int lcslen = -1,str1Row=-1,str2Col=-1;
		for(int len1 = 0;len1 <= length1 ;len1++)
			for(int len2 = 0;len2 <= length2 ; len2++)
			{
				if(t[len1][len2]>lcslen) 
					{
					lcslen = t[len1][len2];
					str1Row = len1;
					str2Col = len2;
					}
			}
		String reversed = "";
		while(t[str1Row][str2Col]!=0)//str1Row > 0 && str2Col>0)
		{
			if(string1.charAt(str1Row-1)==string2.charAt(str2Col-1)) {  // when matched 
				reversed +=string1.charAt(str1Row-1); // store
				// moving up to diagonal brick of table
				str1Row=str1Row-1;
				str2Col=str2Col-1;
			}
			else if(t[str1Row][str2Col-1] > t[str1Row-1][str2Col])
			{
				// move to top brick 
				//str1Row=str1Row;
				str2Col=str2Col-1;
			}
			else
			{
				// move to left brick
				str1Row=str1Row-1;
				//str2Col=str2Col;
			}
		}
		String lcs = reverseString(reversed);
		return lcs;
	}
	private static String reverseString(String string) {
		String reverse = "";
		for(int pos =string.length()-1 ;pos >=0 ; pos--)
			reverse+=string.charAt(pos);
		return reverse;
	}
}
