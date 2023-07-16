package additionalset2;

import java.util.Scanner;

public class CompleteString7 {
	private static boolean checkAllChars ( String input )
    {
        //If input length is less than 26 then it can never be complete
        if(input.length() < 26)
        {
            return false;
        }
                  
        for (char ch = 'A'; ch <= 'Z'; ch++)
        {
            if (input.indexOf(ch) ==-1 && input.indexOf((char) (ch + 32)) ==-1)
            {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		String str ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string :");
		str = sc.next();
		System.out.println(checkAllChars(str));
		sc.close();
	}
}
