package com.mindtree.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.Employee;
import com.mindtree.exception.serviceexception.EmployeeServiceException;
import com.mindtree.service.EmployeeService;
import com.mindtree.service.impl.EmployeeServiceImpl;

public class JdbcSampleApplication {
	private static Scanner input = new Scanner(System.in);
	private static EmployeeService empSer = new EmployeeServiceImpl();
	public static void main(String[] args) {
		JdbcSampleApplication app = new JdbcSampleApplication();
		app.driverMethod();
  }
	
	private void driverMethod() {
		int choice;
		do
		{
			choice = createMenu();
			switch (choice) {
			case 1:
				boolean isInsertedSuccessfully = false;
				try {
					isInsertedSuccessfully = empSer.insertEmployeeIntoDB(getEmployeeDetails());
				} catch (EmployeeServiceException e) {
					
					e.printStackTrace();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if(isInsertedSuccessfully)
					System.out.println("Employee got inserted successfully");
				else
					System.out.println("Something went wrong");
				break;
			case 2:
				List<Employee> empRec = null;
				try {
					empRec = empSer.getAllEmployees();
				} catch (EmployeeServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				displayEmployees(empRec);
				break;
			case 3:
				System.out.println("Exiting!!");
				break;
			default :
				System.out.println("Wrong choice try again");
			}
		}while(choice!=3);
	}
	
	private void displayEmployees(List<Employee> empRec) {
		System.out.println("Id\tName\t\tSalary");
		/*for(Employee emp : empRec)
			System.out.println(emp.getId() +"\t" +emp.getName() +"\t" +emp.getSalary());*/
		
		empRec.forEach(emp -> System.out.println(emp.getId() +"\t" +emp.getName() +"\t" +emp.getSalary()));
		
		// works only with toString method
		//empRec.forEach(System.out::println);  
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Enter employee details:");
		System.out.println("2. Show Employees:");
		System.out.println("3. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}
	
	private int getValidatedInteger(String validationType) {
		int number;
		//boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		}
		return -1;
	}
	
	private Employee getEmployeeDetails() {
		System.out.println("Enter the employee Id :");
		int id = input.nextInt();
		System.out.println("Enter employee name :");
		String name = input.next();
		System.out.println("Enter employee salary");
		double salary = input.nextDouble();
		return new Employee(id, name, salary);
	}

	
}
