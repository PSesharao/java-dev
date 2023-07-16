package assignment1;
import java.util.Scanner;
public class ReverseWords22 {
	public static String reverseWords(String s) {
	    if (s == null) return null;
	    
	    StringBuilder a = new StringBuilder(s);
	    int n = a.length();
	    
	    // step 1. reverse each word
	    reverseWords(a, n);
	    
	    // step 2. clean up spaces
	    return cleanSpaces(a, n);
	  }
	public static void reverseWords(StringBuilder a, int n) {
	    int i = 0, j = 0;
	      
	    while (i < n) {
	      while (i < j || i < n && (a.charAt(i) == ' ' || (a.charAt(i)>='0' && a.charAt(i)<='9') || a.charAt(i)=='.')) i++; // skip spaces
	      while (j < i || j < n && a.charAt(j) != ' ' && a.charAt(j)!='.'&&!((a.charAt(j)>='0' && a.charAt(j)<='9'))) j++; // skip non spaces
	      reverse(a, i, j - 1);                      // reverse the word
	    }
	  }
	// trim leading, trailing and multiple spaces
	public static String cleanSpaces(StringBuilder a, int n) {
	    int i = 0, j = 0; 
	    while (j < n) {
	      while (j < n && a.charAt(j)== ' ') j++;             // skip leading spaces
	      while (j < n && a.charAt(j) != ' ')  {a=a.replace(i,i+1,Character.toString(a.charAt(j)));i++;j++;} // keep non spaces a[i++]=a[j++]
	      while (j < n && a.charAt(j) == ' ') j++;             // skip spaces
	      if (j < n) {a=a.replace(i,i+1," ");i++;}    //a[i++] = ' ';                      // keep only one space
         }
	   return new String(a);                  //.substring(0, i);
	}
	public static void reverse(StringBuilder a, int i, int j) {
		    while (i < j) {
		      String t = Character.toString(a.charAt(i));//a[i];
		      a=a.replace(i,i+1,Character.toString(a.charAt(j)));i++;   //a[i++] = a[j];
		      a=a.replace(j,j+1,t);j--;   //a[j--] = t;
		    }
	  }
	  public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
			System.out.println("Enter your string :");
			String str=sc.nextLine();
			sc.close();
			System.out.println(reverseWords(str));
	}
}
