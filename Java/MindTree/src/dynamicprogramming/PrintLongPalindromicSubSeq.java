package dynamicprogramming;
import java.util.Scanner;
/*if the given sequence is “BBABCBCAB”, then the output should be 7 
as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” 
are also palindromic subsequences of the given sequence, but not the longest ones.*/
/*Another Logic : 
	// Every single character is a palindrome of length 1
	L(i, i) = 1 for all indexes i in given sequence

	// IF first and last characters are not same
	If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)} 

	// If there are only 2 characters and both are same
	Else if (j == i + 1) L(i, j) = 2  

	// If there are more than two characters, and first and last 
	// characters are same
	Else L(i, j) =  L(i + 1, j - 1) + 2 */
public class PrintLongPalindromicSubSeq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string :");
		String string1 = sc.next();
		String string2 = reverseString(string1); // Take 2 nd string as reverse of first string and perform reverse.
		int length1 = string1.length();
		int length2 = string2.length();
		String lps = longestPalindromicSubSequence(string1,string2,length1,length2);
		System.out.println("The longest Palindromic subsequence of "+string1+" is :"+lps);
		sc.close();
	}

	private static String longestPalindromicSubSequence(String string1, String string2, int length1, int length2) {
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
		// Now tracing the longest Palindromic subsequence is exactly the reverse follow up of table
		//and storing the common matches in reverse order from last brick of table . 
		int str1Row = length1 , str2Col = length2;
		String reversed = "";
		while(str1Row > 0 && str2Col>0)
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
		String lps = reverseString(reversed);
		return lps;
	}
	private static String reverseString(String string) {
		String reverse = "";
		for(int pos =string.length()-1 ;pos >=0 ; pos--)
			reverse+=string.charAt(pos);
		return reverse;
	}
}
