package dynamicprogramming;
import java.util.Scanner;

/*Given two strings str1 and str2, find the shortest string that has both str1 and str2 
as subsequences.
Examples:

Input:   str1 = "geek",  str2 = "eke"
Output: "geeke" or "gekek"

Input: X = "AGGTAB",  Y = "GXTXAYB"
Output: "AGXGTXAYB" OR "AGGXTXAYB" 
OR Any string that represents shortest
supersequence of X and Y

Input: X = "HELLO",  Y = "GEEK"
Output: "GEHEKLLO" OR "GHEEKLLO"
OR Any string that represents shortest 
supersequence of X and Y
*/
/*Note : It's length can also be determined by length1 + length2 - lcs .*/
public class PrintShortCommSuperSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string1 :");
		String string1 = sc.next();
		System.out.println("Enter string2 :");
		String string2 = sc.next();
		int length1 = string1.length();
		int length2 = string2.length();
		String scs1 = shortestCommonSuperSequence(string1,string2,length1,length2);
		System.out.println("The shortest common supersequence of "+string1+","+string2 +" is :"+scs1);
		String scs2 = shortestCommonSuperSequence(string2, string1, length2, length1);
		System.out.println("The shortest common supersequence of "+string1+","+string2 +" is :"+scs2);
		sc.close();
	}
	private static String shortestCommonSuperSequence(String string1, String string2, int length1, int length2) {
		int t[][] = new int[length1+1][length2+1];
		// Initialization 
		for(int len1 = 0;len1 <= length1 ;len1++)
			for(int len2 = 0;len2 <= length2 ; len2++) {
				if(len1 == 0)
					t[len1][len2] = len2;
				if( len2 == 0)
					t[len1][len2] = len1;
			}
		// remaining table 
		for(int len1 = 1;len1 <= length1 ;len1++)
			for(int len2 = 1;len2 <= length2 ; len2++)
			{
				if(string1.charAt(len1-1) == string2.charAt(len2-1))
					t[len1][len2] = 1+t[len1-1][len2-1]; // Add the only 1 common character to scs
				else 
					t[len1][len2] =1+Math.min(t[len1][len2-1],t[len1-1][len2]); 
				// delete a character choose min , add deleted character to scs.
			}
		int str1Row = length1,str2Col = length2;
		String scs = "";
		while(str1Row> 0 && str2Col >0)
		{
			if(string1.charAt(str1Row-1)==string2.charAt(str2Col-1))
			{
				scs = string1.charAt(str1Row-1)+scs;
				// moving up to diagonal brick of table
				str1Row=str1Row-1;
				str2Col=str2Col-1;
			}
			else if(t[str1Row][str2Col-1] < t[str1Row-1][str2Col])
			{
				// add character from string2
				scs = string2.charAt(str2Col-1)+scs;
				// move to top brick
				//str1Row=str1Row;
				str2Col=str2Col-1;
			}
			else
			{
				// add character from string1
				scs = string1.charAt(str1Row-1)+scs;
				// move to left brick
				str1Row=str1Row-1;
				//str2Col=str2Col;
			}
		}
		if(str1Row == 0)   // If string 1 is completely deleted
		while(str2Col != 0)// Add remaining characters in string2 to scs
		{
			scs = string2.charAt(str2Col-1)+scs;
			str2Col=str2Col-1;
		}
		else  // If string 2 is completely deleted
			while(str1Row !=0)// Add remaining characters in string1 to scs
			{
				scs = string1.charAt(str1Row-1)+scs;
				str1Row=str1Row-1;
			}
			
		return scs;
	}
}
