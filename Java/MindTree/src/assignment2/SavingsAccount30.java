package assignment2;

import java.util.Scanner;

public class SavingsAccount30 {
	static Scanner sc = new Scanner(System.in);
	private double balance;
	private int interestRate;
	private int accountNo;
	public SavingsAccount30(int accountNo, int interestRate,double balance ) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNo = accountNo;
	}
	public void withDraw(double amount)
	{
		if(amount>balance)
			System.out.println("Sorry ! your balance "+ balance+ " rs/- is lower than your expected withdrawl amount "+amount+"rs/-");
		else
		{
			System.out.println("successfully withdrawn " +amount+" rs/-");
			balance-=amount;
		}
	}
	public void calculateInterest()
	{
		
		System.out.println("Enter the time in years till which you want to calculate interest :");
		int t= sc.nextInt();
		System.out.println("The total interest made after "+t+" years is "+(balance*t*interestRate)/100+"rs/-");
	}
	public static void main(String[] args) {
		int account_num,interest_rate;
		double balance;
		System.out.println("Enter account number :");
		account_num = sc.nextInt();
		System.out.println("Enter interest rate :");
		interest_rate = sc.nextInt();
		System.out.println("Enter balance :");
		balance = sc.nextDouble();
		SavingsAccount30 s= new SavingsAccount30(account_num, interest_rate, balance);
		System.out.println(s);
		s.calculateInterest();
		s.withDraw(2000);
		System.out.println(s);
		sc.close();
	}
	@Override
	public String toString() {
		return " [balance=" + balance + ", interestRate=" + interestRate + ", accountNo=" + accountNo
				+ "]";
	}
}
