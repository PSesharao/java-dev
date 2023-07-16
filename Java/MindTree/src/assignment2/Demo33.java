package assignment2;

public class Demo33 {
	public static void main(String[] args) {
		Student student1 = new Student(101, "Ravindra", false);
		if(student1.isSecondChance()==false)
			student1.identifyMarks(98);
		else
			student1.identifyMarks(95, 99);
		Student student2 = new Student(102, "RaviSharma", true);
		if(student2.isSecondChance()==false)
			student2.identifyMarks(92);
		else
			student2.identifyMarks(94, 97);
		System.out.println("The student1 details ");
		System.out.println(student1.getStudentId());
		System.out.println(student1.getStudentName());
		System.out.println(student1.getMarks());
		System.out.println(student1.isSecondChance());
		System.out.println("The student2 details ");
		System.out.println(student2.getStudentId());
		System.out.println(student2.getStudentName());
		System.out.println(student2.getMarks());
		System.out.println(student2.isSecondChance());
	}
}

class Student{
	private int studentId;
	private String studentName;
	private float marks;
	private boolean secondChance;
	public Student(int studentId, String studentName, boolean secondChance) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.secondChance = secondChance;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public float getMarks() {
		return marks;
	}
	public boolean isSecondChance() {
		return secondChance;
	}
	public void identifyMarks(float marks)
	{
		this.marks=marks;
	}
	public void identifyMarks(float marks1,float marks2)
	{
		this.marks = marks1>marks2 ? marks1 :marks2;
	}
}
