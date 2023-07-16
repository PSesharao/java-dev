package assignment1;
import java.util.Scanner;
public class Password18 {
	int age;
	String fullName;
	Password18(int age,String fullName)
	{
		this.age = age;
		this.fullName = fullName;
	}
	public String getPassword()
	{
		String temp="";
		String [] names = new String[3];
		int len=0;
		for(int i=0;i<fullName.length();i++)
		{
			if(fullName.charAt(i)==' ' || (i==fullName.length()-1))  {
				if(i==fullName.length()-1) {temp+=fullName.charAt(i);names[len++]=temp;}
				else {
				names[len++]=temp;
				temp = "";
				}
			}
			else
				temp+=fullName.charAt(i);
		}
		String pswd = Character.toString(names[0].charAt(0))+Character.toString(names[1].charAt(0))+Character.toString(names[2].charAt(0))+String.valueOf(age);
		return pswd;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name in 'Intitial Middle Surname' format:");
		String name = sc.nextLine();
		System.out.println("Age :");
		int age = sc.nextInt();
		Password18 pwd = new Password18(age, name);
		System.out.println(pwd.getPassword());
		sc.close();
	}
}
