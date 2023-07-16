package dynamicprogramming;
import java.util.Scanner;
/*Given two sequences, find the length of longest subsequence present 
in both of them. A subsequence is a sequence that appears in the same 
relative order, but not necessarily contiguous. For example, 
“abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
	Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.*/
public class LongCommSubSeqDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string1 :");
		String string1 = sc.next();
		System.out.println("Enter string2 :");
		String string2 = sc.next();
		int length1 = string1.length();
		int length2 = string2.length();
		int lcs = longestCommonSubSequence(string1,string2,length1,length2);
		System.out.println("The length of longest common subsequence of "+string1+","+string2 +" is :"+lcs);
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
