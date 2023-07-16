package assignment1;

import java.util.Scanner;

public class ConsecutiveCharacters23 {
	private void printConsecutiveCharacters(String input)
	{
		String upperStr = stringUpper(input) ;
		//System.out.println(upperStr);
		String [] consecPairs = getAllConsecutivePairs(upperStr);
		String [] distinctPairs = getDistictPairs(consecPairs);
		for(int i=0;distinctPairs[i]!=null;i++)
			System.out.println(distinctPairs[i]+" "+findFrequency(distinctPairs[i], upperStr));
	}
	private int findFrequency(String subStr,String mainStr)
	{
		int frequency=0;
		int subIndex=0,subLen=subStr.length(),mainIndex,mainLen=mainStr.length();
		for(mainIndex=0;mainIndex<mainLen;)
		{
			subIndex=0;
			int matchedChar=0;
			while(subIndex<subLen && mainIndex<mainLen && mainStr.charAt(mainIndex)==subStr.charAt(subIndex))
				{
				subIndex++;
				mainIndex++;
				matchedChar++;
				}
			if(matchedChar==subLen)
			{
				frequency++;
				matchedChar=0;
				
			}
			else if(subIndex==0)
				mainIndex++;
		}
		return frequency;
	}
	private String[] getAllConsecutivePairs(String str)
	{
		String consecPairs[] = new String[100];
		int l=0;
		for(int i=0;i<str.length()-1;i++)
		{
			char ch = str.charAt(i);
			if((ch+1)==str.charAt(i+1))
				{consecPairs[l++] = ch+Character.toString(ch+1);i++;}
		}
		return consecPairs;
	}
	private String[] getDistictPairs(String pairs[])
	{
		String distinct [] = new String[50];
		int l=0,i,j;
		for(i=0;pairs[i]!=null;i++) {
			for(j=0;j<i;j++)
				if(pairs[j].compareTo(pairs[i])==0) break;
		if(i==j)
			distinct[l++]=pairs[i];
		}
		
		return distinct;
	}
	private String stringUpper(String str)
	{
		String s="";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='a' && str.charAt(i)<='z')
				s+=Character.toString((char) (str.charAt(i)-'a'+'A'));
			else if(str.charAt(i)>='A' && str.charAt(i)<='Z'||str.charAt(i)==' ')
				s+=Character.toString(str.charAt(i));
		}
		return s;
	}
	public static void main(String[] args) {
		String str;//="I saw a CD play-er and a modem in ccd";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string :");
		str = sc.nextLine();
		sc.close();
		ConsecutiveCharacters23 obj = new ConsecutiveCharacters23();
		obj.printConsecutiveCharacters(str);
	}
}
