package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import com.mindtree.entity.College;
import com.mindtree.entity.University;
import com.mindtree.exception.CollegeBoundException;

//import com.mindtree.service.implementation.UniversityService;

public class ApplicationUniversity {
	private static Scanner input = new Scanner(System.in);
	//private static UniversityService serApp = new UniversityService();
	public static void main(String[] args) {
		ApplicationUniversity univApp = new ApplicationUniversity();
		univApp.driverMethod();
	}
	private void driverMethod() {
		int choice;
		List<University> univList = new ArrayList<University>();
		do
		{
			choice = createMenu();
			switch(choice)
			{
			case 1:
				univList = createUniversity(univList);
				break;
			case 2:
				System.out.println("Printing with loop :");
				printUniversities(univList);
				System.out.println("Printing with the help of iterator ");
				printByIterator(univList);
				break;
			case 3:
				System.out.println("Exiting!!");
				break;
			default :
				System.out.println("Wrong choice,try again :");
			}
		}while(choice!=3);
	}
	private void printByIterator(List<University> univList) {
		Iterator<University> traverse = univList.iterator();
		while (traverse.hasNext()) {
			System.out.println(traverse.next());
		}
	}
	private void printUniversities(List<University> univList) {
		for(int i=0;i<univList.size();i++) 
			System.out.println(univList.get(i));
	}
	private List<University> createUniversity( List<University> univList)
	{
		System.out.println("Enter university id :");
		String univId = input.next();
		System.out.println("Enter university name :");
		String univName = input.next();
		int noOfColg =  getValidatedInteger("noOfColg");
		University entry = new University(univId, univName, noOfColg);
		entry.setCollegeList(new ArrayList<College>());
		System.out.println( "Reading college details");
		for(int i=0;i<noOfColg ;i++)
		{
			System.out.println("Enter colg name :"+(i+1));
			String nameOfColg =  input.next();
			System.out.println("Enter no of students in colg "+(i+1));
			int noOfStud = input.nextInt();
			entry.getCollegeList().add(new College(nameOfColg, noOfStud));
		}
		univList.add(entry);
		return univList;
	}
	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. create university:");
		System.out.println("2. print all universities:");
		System.out.println("3. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}
	
	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			//System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "noOfColg":
			do {
				isValid = true;
				System.out.println("Enter no of colleges :");
				number = getValidatedInteger("Integer");
				try {
					if (number < 0 || number > 5) {
						isValid = false;
						throw new CollegeBoundException("The no colleges should be atmost 5,try again !!");
					}
				} catch (CollegeBoundException e) {
					System.out.println(e.getMessage());
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}
	
}
