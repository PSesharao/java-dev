package assignment2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str= sc.next();
		boolean flag = true;
		sc.close();
		if(str.length()!=8)
			flag=false;
		if(!(str.charAt(3)>='A'&&str.charAt(3)<='Z'))
			flag = false;
		if(!(str.charAt(4)>='0'&&str.charAt(4)<='9'&&str.charAt(5)>='0'&&str.charAt(5)<='9'))
			flag = false;
		if(!(str.charAt(6)>='0'&&str.charAt(6)<='9'&&str.charAt(7)>='0'&&str.charAt(7)<='9'))
			flag = false;
		if(flag)
		{
			
			int priceperTicket ;
			if(str.charAt(3)>='A'&&str.charAt(3)<='M')
				priceperTicket=750;
			else if(str.charAt(3)>='N'&&str.charAt(3)<='S')
				priceperTicket=500;
			else
				priceperTicket=250;
			int numberofTickets = Integer.parseInt(str.substring(6, 8));
			int totalPrice = priceperTicket*numberofTickets;
			System.out.println(totalPrice);
		}
		else
		{
			System.out.println(str+" is not a valid String");
		}
	}
}
