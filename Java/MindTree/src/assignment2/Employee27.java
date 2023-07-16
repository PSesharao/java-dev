package assignment2;
import java.util.Scanner;
public class Employee27 {
	private int empId;
	private String empName;
	private String empDesig;
	private String empDept;
	public Employee27(int empId, String empName, String empDesig, String empDept) {
		setEmpId(empId);
		setEmpName(empName);
		setEmpDesig(empDesig);
		setEmpDept(empDept);
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		if(empName!=null)
			this.empName = empName;
		else
			System.out.println("Sorry! The name can't be Null");
	}
	public String getEmpDesig() {
		return empDesig;
	}
	public void setEmpDesig(String empDesig) {
		if(empDesig.compareToIgnoreCase("developer")==0||empDesig.compareToIgnoreCase("tester")==0||empDesig.compareToIgnoreCase("Lead")==0||empDesig.compareToIgnoreCase("manager")==0)
			this.empDesig = empDesig;
		else
			System.out.println("Invalid designation");
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		if(empDept.compareToIgnoreCase("TTH")== 0|| empDept.compareToIgnoreCase("RCM")== 0||empDept.compareToIgnoreCase("Digital")==0 || empDept.compareToIgnoreCase("DevOps")==0)
			this.empDept = empDept;
		else
			System.out.println("Invalid Dept");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empId;
		String name,desig,dept;
		System.out.println("Enter employee Id :");
		empId = sc.nextInt();
		System.out.println("Enter employee name :");
		name = sc.next();
		System.out.println("Enter employee designation :");
		desig = sc.next();
		System.out.println("Enter employee department :");
		dept = sc.next();
		//Employee27 emp =
		new Employee27(empId,name,desig,dept);
		sc.close();
	}
}
