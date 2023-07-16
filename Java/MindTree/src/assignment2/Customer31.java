package assignment2;

import java.util.Scanner;

public class Customer31 {
	private String name;
	private String mobileNo;
	private double feedbackRating;
	public Customer31(String name, String mobileNo, double feedbackRating) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.feedbackRating = feedbackRating;
	}
	public static void main(String[] args) {
		Customer31 customers[] = new Customer31[5];
		Scanner sc = new Scanner(System.in);
		String n,m;
		double f;
		for(int i=0;i<3;i++)
		{
			System.out.println("Enter the details of customer "+(i+1));
			System.out.println("The Name :");
			n=sc.next();
			System.out.println("The mobile number :");
			m=sc.next();
			System.out.println("The rating :");
			f=sc.nextDouble();
			customers[i] = new Customer31(n, m, f);
		}
		for(int i=0;i<3;i++)
			displayFeedBack(customers[i]);
		sc.close();
	}
	public static void displayFeedBack(Customer31 customer) {
		System.out.println("The feedback rating is :"+customer.feedbackRating);
	}
	@Override
	public String toString() {
		return "Customer31 [name=" + name + ", mobileNo=" + mobileNo + ", feedbackRating=" + feedbackRating + "]";
	}
}
