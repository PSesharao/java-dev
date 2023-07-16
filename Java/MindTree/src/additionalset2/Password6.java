package additionalset2;

import java.util.Scanner;

public class Password6 {
	public  Password6(String name,int age,String id) {
		System.out.println("Password is :"+name + age + id);
	}
	public static void main(String[] args) {
		String name,id;
		int age;
		Scanner sc = new Scanner(System.in);
		sc.close();
		System.out.println("Enter name :");
		name = sc.next();
		System.out.println("Enter age :");
		age = sc.nextInt();
		System.out.println("Enter id :");
		id = sc.next();
		new Password6(name,age,id);
	}
}
