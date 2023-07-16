package assignment1;
import java.util.Scanner;
public class Compression24 {
	private String str;
	public Compression24(String s) {
		str = s;
	}
	private String compresString(String text) {
		int length = text.length();
			String compressedText = "";	
			char lastChar = text.charAt(0);	
			int charCount = 1;
			for(int i = 1; i < length; i++) {
				if(text.charAt(i)==' ') continue;
				if(text.charAt(i) == lastChar) charCount++;	
				else {
					compressedText += Character.toString(lastChar) + Integer.toString(charCount);
					lastChar = text.charAt(i);	
					charCount = 1;
				}
			}	
			compressedText += Character.toString(lastChar) + Integer.toString(charCount);
			return compressedText;		
	}
	private String stringLower()
	{
		String s="";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='A' && str.charAt(i)<='Z')
				s+=Character.toString((char) (str.charAt(i)-'A'+'a'));
			else
				s+=Character.toString(str.charAt(i));
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your string :");
		String str=sc.nextLine();
		sc.close();
		Compression24 c = new Compression24(str);
		String s= c.stringLower();
		System.out.println(c.compresString(s));
	}
}
