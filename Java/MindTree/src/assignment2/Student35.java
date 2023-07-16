package assignment2;

import java.util.Scanner;

public class Student35 {
	private String name;
	private String id;
	private String branch;
	private double score;
	public Student35(String name, String id, String branch, double marks) {
		this.name = name;
		this.id = id;
		this.branch = branch;
		this.score = marks;
	}
	
	public static Student35 getTopper(Student35 students[])
	{
		int max_index=0;
		for(int i=1;i<students.length;i++)
			if(students[i].score>students[max_index].score)
				max_index=i;
		return students[max_index];
	}
	public static void main(String[] args) {
		Student35 students[] = new Student35[3];
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter no of students :");
		n=sc.nextInt();
		String name,id,branch;
		double score;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the details of student"+(i+1));
			System.out.println("Name :");
			name = sc.next();
			System.out.println("ID :");
			id = sc.next();
			System.out.println("Branch :");
			branch = sc.next();
			System.out.println("Score :");
			score = sc.nextDouble();
			students[i] = new Student35(name, id, branch, score);
		}
		Student35 max = getTopper(students) ;
		System.out.println(max);
		sc.close();
	}

	@Override
	public String toString() {
		return "Student35 [name=" + name + ", id=" + id + ", branch=" + branch + ", score=" + score + "]";
	}
	
}
