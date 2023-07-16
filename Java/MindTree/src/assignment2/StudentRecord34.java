package assignment2;
import java.util.Scanner;
public class StudentRecord34 {
	private String name;
	private String branch;
	private int id;
	public StudentRecord34(String name,String branch,int id) {
		this.name = name;
		this.branch = branch; 
		this.id = id;
	}
	public static void main(String[] args) {
		StudentRecord34 students[];
		Scanner sc  = new Scanner(System.in);
		students = new StudentRecord34[0];
		while(true)
		{
			int ch;
			System.out.println("1.Create Student Record ");
			System.out.println("2.Sort Students Based on Branch ");
			System.out.println("3.Sort Students Based on Id ");
			System.out.println("4.Exit");
			System.out.println("Please Enter a choice :");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1 :
				System.out.println("Enter name :");
				String name = sc.next();
				System.out.println("Enter branch :");
				String branch = sc.next();
				System.out.println("Enter the id :");
				int id = sc.nextInt();
				StudentRecord34 student = new StudentRecord34(name, branch, id);
				students = addStudent(students,student);
				break;
			case 2 :
				System.out.println("Enter the branch of the students to sort :");
				String branch1 = sc.next(); 
				String studentNames[]=sortByBranch(students,branch1);
				if(studentNames==null)
					System.out.println("There are no students from "+branch1);
				else
				displayStudentsWithBranch(studentNames);
				break;
			case 3 :
				System.out.println("Sorting students based on id ");
				sortById(students);
				displayStudentsId(students);
				break;
			case 4 :
				System.out.println("Adieu Thanks!!!");
				sc.close();
				System.exit(0);
				break;
			default :
				System.out.println("Enter the right choice ");	
			}
		}
}
	private static void displayStudentsWithBranch(String[] studentNames) {
		int len = studentNames.length;
		for(int i=0;i<len;i++)
			System.out.println(studentNames[i]);
	}
	private static StudentRecord34[] addStudent(StudentRecord34[] students, StudentRecord34 student) {
		int currLen = students.length;
		StudentRecord34[] temp = new StudentRecord34[currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i] = students[i];
		temp[currLen] = student;
		return temp;
	}
	private static String[] sortByBranch(StudentRecord34 students[], String branch1) {
		int len1 = students.length;
		String namesFromBranch[] = new String[0];
		for(int i=0;i<len1;i++)
			if(students[i].branch.compareToIgnoreCase(branch1)==0)
			     namesFromBranch= addNameFromBranch(namesFromBranch,students[i].name);
		int len=namesFromBranch.length;
		if(len==0)
			return null;
		for(int i=0;i<len-1;i++)
			for(int j=0;j<len-1-i;j++)
			{
				if(namesFromBranch[j].compareToIgnoreCase(namesFromBranch[j+1])>0)
				{
					String temp = namesFromBranch[j];
					namesFromBranch[j] = namesFromBranch[j+1];
					namesFromBranch[j+1] = temp;
				}
			}
		return namesFromBranch;
	}
	private static String[] addNameFromBranch(String[] namesFromBranch, String name2) {
		int currLen = namesFromBranch.length;
		String temp[] = new String[currLen+1];
		for(int i=0;i<currLen;i++)
			temp[i] = namesFromBranch[i];
		temp[currLen] = name2;
		return temp;
	}
	private static void sortById(StudentRecord34 students[]) {
		int len = students.length;
		for(int i=0;i<len-1;i++)
			for(int j=0;j<len-1-i;j++)
			{
				if(students[j].id>students[j+1].id)
				{
					StudentRecord34 temp =students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
			}
	}
	private static void displayStudentsId(StudentRecord34 students[]) {
		for(int i=0;i<students.length;i++)
		{
			System.out.println("Id of "+(i+1)+" th student :"+students[i].id);
		}
	}
}
