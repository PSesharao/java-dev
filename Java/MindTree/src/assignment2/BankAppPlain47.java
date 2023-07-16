package assignment2;
import java.util.Scanner;
public class BankAppPlain47 {
	private int account_number;
	private String name;
	private String account_type;
	private String dob;
	private double balance;
	private String address;
	public BankAppPlain47(int account_number, String name, String account_type, String dob, double balance,
			String address) {
		this.account_number = account_number;
		this.name = name;
		this.account_type = account_type;
		this.dob = dob;
		this.balance = balance;
		this.address = address;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAppPlain47 users [] = new BankAppPlain47[0];
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
				BankAppPlain47 user = new BankAppPlain47(acn, name, actype, dob, balance, address);
				users = addUser(users, user);
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
				users=deleteUser(users, acn1);
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
	private static void sortBasedOnId(BankAppPlain47[] users) {
		int min,noUsers = users.length;
		for(int i=0;i<noUsers-1;i++)
		{
			min = i;
			for(int j=i+1;j<noUsers;j++)
				if(users[i].account_number>users[j].account_number)
					min = j;
			if(min!=i) {
			BankAppPlain47 user = users[min] ;
			users[min] = users[i];
			users[i] = user;
			}
		}
		for(int i=0;i<noUsers;i++)
			System.out.println(users[i]);
	}
	private static void sortUsersBasedOnAddress(BankAppPlain47[] users) {
		int min,noUsers = users.length;
		for(int i=0;i<noUsers-1;i++)
		{
			min = i;
			for(int j=i+1;j<noUsers;j++)
				if(users[i].address.compareToIgnoreCase(users[j].address)>0)
					min = j;
			if(min!=i) {
			BankAppPlain47 user = users[min] ;
			users[min] = users[i];
			users[i] = user;
			}
		}
		for(int i=0;i<noUsers;i++)
			System.out.println(users[i]);
	}
	private static void displayUsersWithNonZeroBalance(BankAppPlain47[] users) {
		int target=-1,noOfUsers=users.length;
		for(int i=0;i<noOfUsers;i++)
			if(users[i].balance>0)
				{
				target =i;
				System.out.println(users[target]);
				}
		if(target==-1)
			System.out.println("No such user exist");
	}
	private static void displayUserWithName(BankAppPlain47[] users, String name) {
		int target=-1,noOfUsers=users.length;
		for(int i=0;i<noOfUsers;i++)
			if(users[i].name.equalsIgnoreCase(name))
				{
				target =i;
				break;
				}
		if(target!=-1) 
			System.out.println(users[target]);
		else
			System.out.println("The user with "+name + " does'nt exist ");
	}
	private static void displayUserWithId(BankAppPlain47[] users, int account_number) {
		int target=-1,noOfUsers=users.length;
		for(int i=0;i<noOfUsers;i++)
			if(users[i].account_number==account_number)
				{
				target =i;
				break;
				}
		if(target!=-1)
			System.out.println(users[target]);
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
	}
	private static BankAppPlain47[] deleteUser(BankAppPlain47[] users, int account_number) {
		int target=-1,noOfUsers=users.length;
		for(int i=0;i<noOfUsers;i++)
			if(users[i].account_number==account_number)
				{
				target =i;
				break;
				}
		if(target!=-1) {
			System.out.println(users[target] + "is deleted ");
			BankAppPlain47 temp [] = new BankAppPlain47[noOfUsers-1];
			int size = 0;
			for(int i=0;i<noOfUsers;i++)
				if(i==target) continue;
				else temp[size++] = users[i];
			users = temp;
			for(int i=0;i<size;i++)
				System.out.println(users[i]);
		}
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
		return users;
	}
	private static void updateUserName(BankAppPlain47[] users, int account_number, String newname) {
		int target=-1,noOfUsers=users.length;
		for(int i=0;i<noOfUsers;i++)
			if(users[i].account_number==account_number)
			{
			target =i;
			break;
			}
		if(target!=-1) 
			users[target].name =newname;
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
	}
	private static void updateUserAddress(BankAppPlain47[] users, int account_number, String newaddress) {
		int target=-1,noOfUsers=users.length;
		for(int i=0;i<noOfUsers;i++)
			if(users[i].account_number==account_number)
			{
			target =i;
			break;
			}
		if(target!=-1) 
			users[target].address =newaddress;
		else
			System.out.println("The user with "+account_number + " does'nt exist ");
	}
	private static BankAppPlain47[] addUser(BankAppPlain47 users[],BankAppPlain47 user) {
		int currLen = users.length;
		BankAppPlain47 temp[] = new BankAppPlain47[currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i] = users[i];
		temp[currLen] = user;
		return temp;
	}
	@Override
	public String toString() {
		return " [account_number=" + account_number + ", name=" + name + ", account_type="
				+ account_type + ", dob=" + dob + ", balance=" + balance + ", address=" + address + "] ";
 }
}
