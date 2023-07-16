package dynamicprogramming;

import java.util.Scanner;

/*Given two sequences, find the length of longest subsequence present 
in both of them. A subsequence is a sequence that appears in the same 
relative order, but not necessarily contiguous. For example, 
“abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

	Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.*/
public class LongCommSubSeqRecursive {
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
		if(length1 == 0 || length2 == 0)
			return 0;
		else if(string1.charAt(length1-1) == string2.charAt(length2-1))
			return 1+longestCommonSubSequence(string1, string2, length1-1, length2-1);
		else
			return Math.max(longestCommonSubSequence(string1, string2, length1, length2-1),
					longestCommonSubSequence(string1, string2, length1-1, length2));
	}
}
