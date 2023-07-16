package assignment2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class BankApplication47 {
	private int account_number;
	private String name;
	private String account_type;
	private String dob;
	private double balance;
	private String address;
	public BankApplication47(int account_number, String name, String account_type, String dob, double balance,
			String address) {
		this.account_number = account_number;
		this.name = name;
		this.account_type = account_type;
		this.dob = dob;
		this.balance = balance;
		this.address = address;
	}
	public static void updateUserAddress(List<BankApplication47> users,int account_number,String newAddress) {
		int target=-1;
		for(int i=0;i<users.size();i++)
			if(users.get(i).account_number==account_number)
				{
				target =i;
				break;
				}
		if(target!=-1)
			users.get(target).address = newAddress;
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
	}
	public static void updateUserName(List<BankApplication47> users,int account_number,String newName) {
		int target=-1;
		for(int i=0;i<users.size();i++)
			if(users.get(i).account_number==account_number)
				{
				target =i;
				break;
				}
		if(target!=-1)
			users.get(target).name = newName;
		else
			System.out.println("The user with "+newName + " does'nt exist ");
	}
	public static void deleteUser(List<BankApplication47> users,int account_number) {
		int target=-1;
		for(int i=0;i<users.size();i++)
			if(users.get(i).account_number==account_number)
				{
				target =i;
				break;
				}
		if(target!=-1)
			users.remove(target);
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
	}
	public static void displayUserWithId(List<BankApplication47> users,int account_number) {
		int target=-1;
		for(int i=0;i<users.size();i++)
			if(users.get(i).account_number==account_number)
				{
				target =i;
				break;
				}
		if(target!=-1)
			System.out.println(users.get(target));
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
	}
	public static void displayUserWithName(List<BankApplication47> users,String name) {
		int target=-1;
		for(int i=0;i<users.size();i++)
			if(users.get(i).name.equalsIgnoreCase(name))
				{
				target =i;
				break;
				}
		if(target!=-1)
			System.out.println(users.get(target));
		else
			System.out.println("The user with "+name + " does'nt exist ");
	}
	public static void displayUsersWithNonZeroBalance(List<BankApplication47> users) {
		int target=-1;
		for(int i=0;i<users.size();i++)
			if(users.get(i).balance>0)
				{
				target =i;
				System.out.println(users.get(target));
				}
		if(target==-1)
			System.out.println("No such user exist");
	}
	public static void sortUsersBasedOnAddress(List<BankApplication47> users ) {
		Collections.sort(users,new Comparator<BankApplication47>()
		{

			@Override
			public int compare(BankApplication47 o1, BankApplication47 o2) {
				return o1.address.compareToIgnoreCase(o2.address);
			}
	
		});
		for(int i=0;i<users.size();i++)
		{
			System.out.println(users.get(i));
		}
}
	public static void sortBasedOnId(List<BankApplication47> users) {
		Collections.sort(users,new Comparator<BankApplication47>()
				{

					@Override
					public int compare(BankApplication47 o1, BankApplication47 o2) {
						if(o1.account_number>o2.account_number)
							return 1;
						else if(o1.account_number<o2.account_number)
							return -1;
						else 
							return 0;
					}
			
				});
		for(int i=0;i<users.size();i++)
		{
			System.out.println(users.get(i));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//BankApplication47 users [] = new BankApplication47[0];
		List<BankApplication47> users = new ArrayList<BankApplication47>();
		while(true)
		{
			System.out.println("1. Create bank user");
			System.out.println("2. Update user details");
			System.out.println("3. Delete user details");
			System.out.println("4. Display user details");
			System.out.println("5. Exit");
			System.out.println("Please enter your choice :");
			int ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the following details :");
				System.out.println("Enter account number :");
				int acn = sc.nextInt();
				System.out.println("Enter name :");
				String name = sc.next();
				System.out.println("Enter account type 'saving/loan/current':");
				String actype = sc.next();
				System.out.println("Enter date of birth :");
				String dob = sc.next();
				System.out.println("Enter balance :");
				double balance = sc.nextInt();
				System.out.println("Enter the address :");
				String address = sc.next();
				BankApplication47 user = new BankApplication47(acn, name, actype, dob, balance, address);
				users.add(user);
				break ;
			case 2:
				System.out.println("Enter account number of user to update :");
				int acno = sc.nextInt();
				int choice ;
				System.out.println("Enter 1 to update address :");
				System.out.println("Enter 2 to update name :");
				choice =sc.nextInt();
				if(choice == 1)
				{
					System.out.println("Enter new address :");
					String newaddress = sc.next();
					updateUserAddress(users, acno, newaddress);
				}
				else if(choice == 2)
				{
					System.out.println("Enter new name :");
					String newname = sc.next();
					updateUserName(users, acno, newname);
				}
				else 
					System.out.println("Enter either '1/2'");
				break;
			case 3 :
				System.out.println("Enter account number of user to delete :");
				int acn1=sc.nextInt();
				deleteUser(users, acn1);
				break;
			case 4 :
				System.out.println("Enter account number of user to display :");
				int acn2 = sc.nextInt();
				displayUserWithId(users, acn2);
				System.out.println("Enter name to display user details :");
				String name1 = sc.next();
				displayUserWithName(users, name1);
				System.out.println("Displaying users with non-zero account balance :");
				displayUsersWithNonZeroBalance(users);
				System.out.println("Sorting users based on address :");
				sortUsersBasedOnAddress(users);
				System.out.println("Sorting users based on account Id :");
				sortBasedOnId(users);
				break;
			case 5:
				System.out.println("Adieu Thanks!!!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter the right choice");
					
			}
		}
		
	}
	@Override
	public String toString() {
		return "BankApplication47 [account_number=" + account_number + ", name=" + name + ", account_type="
				+ account_type + ", dob=" + dob + ", balance=" + balance + ", address=" + address + "]";
	}
}