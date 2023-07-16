package assignment1;

import java.util.Scanner;

public class TestUSN21 {
	private String universityRollNum;
	TestUSN21(String rollnum)
	{
		this.universityRollNum = rollnum;
	}
	private boolean validateRollNum(String rollNum) {
		 if(!((rollNum.length()==10) && (rollNum.charAt(0)=='1' || rollNum.charAt(0)=='2')))
			 return false;
		 if(!((rollNum.charAt(1)>='A'&&rollNum.charAt(1)<='Z')||(rollNum.charAt(2)>='A'&&rollNum.charAt(2)<='Z')))
			return false;
		 if(!((rollNum.charAt(3)>='0'&&rollNum.charAt(3)<='9')||(rollNum.charAt(4)>='0'&&rollNum.charAt(4)<='9')||(rollNum.charAt(7)>='0'&&rollNum.charAt(7)<='9')||(rollNum.charAt(8)>='0'&&rollNum.charAt(8)<='9')||(rollNum.charAt(9)>='0'&&rollNum.charAt(9)<='9')))
			 return false;
		 if(!((rollNum.substring(5, 7).equals("CS"))||(rollNum.substring(5, 7).equals("IS"))||(rollNum.substring(5, 7).equals("EC"))||(rollNum.substring(5, 7).equals("ME"))))
			 return false;
		 return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String rollnum = sc.next();
		TestUSN21 t = new TestUSN21(rollnum);
		sc.close();
		System.out.println(t.validateRollNum(t.universityRollNum));
	}
}
