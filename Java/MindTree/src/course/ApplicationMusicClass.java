package course;

import java.util.Scanner;

public class ApplicationMusicClass {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationMusicClass appMusic = new ApplicationMusicClass();
		appMusic.driverMethod();
	}
	
	private void driverMethod() {
	    //String availableCourses[] = { "Guitar","Ukelete","Keyboard","Drums","Vocal"};
	    Student studentRec[] = new Student[0];
	    Course courseRec[] = new Course[0];
	    int choice;
	    String firstName;
		String mobileNumber;
		int age;
		String gender;
		String address;
		String courseName;
		int duration;
		int fee;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				courseName = getValidatedInput("courseName");
				duration = getValidatedInteger("duration");
				fee = getValidatedInteger("fee");
				Course courseEntry = new Course(courseName, duration, fee);
				courseRec = addEntry(courseRec, courseEntry);
				break;
			case 2:
				firstName = getValidatedInput("firstName");
				age = getValidatedInteger("age");
				gender = getValidatedInput("gender");
				address = getValidatedInput("address");
				courseName = getValidatedInput("courseName");
				mobileNumber = getValidatedInput("mobileNumber");
				Student studentEntry = new Student(firstName, age, gender, address, courseName, mobileNumber);
				studentRec = addEntry(studentRec, studentEntry);
				break;
			case 3:
				courseName = getValidatedInput("courseName");
				int noOfStudents = getNoOfEnrolled(studentRec,courseName);
				System.out.println("The no of students enrolled in "+courseName +" are:"+noOfStudents);
				break;
			case 4:
				
				insertionSort(studentRec);
				for(int i=0;i<studentRec.length;i++)
				{
					studentRec[i].displayStudent();
					System.out.println();
				}
				break;
			case 5:
				mobileNumber = getValidatedInput("mobileNumber");
				Student desired = getStudentOnMobile(studentRec,mobileNumber);
				desired.displayStudent();
				break;
			case 6:
				
				address = getValidatedInput("address");
				Student [] sameAddress = getStudentsFromCity(studentRec,address);
				for(int i=0;i<sameAddress.length;i++)
				{
					sameAddress[i].displayStudent();
					System.out.println();
				}
				break;
			case 7:
				System.out.println("Exiting!!");
				break;
			default:
				System.out.println("Enter the right choice:");
			}

		} while (choice != 7);
	}
	
	

	private Student[] getStudentsFromCity(Student[] studentRec, String address) {
		Student [] sameAddress = new Student[0];
		for(int i=0;i<studentRec.length;i++)
			if(studentRec[i].getAddress().compareTo(address)==0)
				sameAddress = addEntry(sameAddress, studentRec[i]);
		return sameAddress;
	}

	private Student getStudentOnMobile(Student[] studentRec, String mobileNumber) {
		Student desired = null;
		for(int i=0;i<studentRec.length;i++)
			if(studentRec[i].getMobileNumber().compareTo(mobileNumber)==0)
			{
				desired = studentRec[i];
				break;
			}
		return desired;
	}

	private int getNoOfEnrolled(Student[] studentRec, String courseName) {
		int n=0;
		for(int i=0;i<studentRec.length;i++)
			if(studentRec[i].getCourseName().compareTo(courseName)==0)
				n++;
		return n;
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Add the course:");
		System.out.println("2. Enroll student:");
		System.out.println("3. Find no of students enrolled in a given course");
		System.out.println("4. Sort students based on the city");
		System.out.println("5. Search student's mobile number");
		System.out.println("6. Search students enrolled in a particular city");
		System.out.println("7. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}
	
	private Course[] addEntry(Course courseRec[], Course courseEntry) {
		int currLen = courseRec.length;
		Course temp[] = new Course[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = courseRec[i];
		temp[currLen] = courseEntry;
		return temp;
	}
	
	private Student[] addEntry(Student studentRec[], Student studentEntry) {
		int currLen = studentRec.length;
		Student temp[] = new Student[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = studentRec[i];
		temp[currLen] = studentEntry;
		return temp;
	}
	
	private void insertionSort(Student[] theArray) {
		int arraySize = theArray.length;
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			Student toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1].getAddress().compareTo(toInsert.getAddress())>0)) {
				theArray[j] = theArray[j - 1];
				j--;
			}
			theArray[j] = toInsert;
		}
	}
	
	private int getValidatedInteger(String validationType) {
		int number;
		boolean isValid;
		switch (validationType) {
		case "Integer":
			System.out.println("Enter an integer :");
			while (!input.hasNextInt()) {
				String userInput = input.next();
				System.out.printf("\"%s\" is not a valid number,try again.\nEnter an integer :", userInput);
			}
			number = input.nextInt();
			return number;
		case "age":
			do
			{
				isValid = true;
				System.out.println("Enter your age :");
				number =  getValidatedInteger("Integer");
				if(number < 0 || number > 150)
				{
					isValid = false;
					System.out.println("The age is invalid try again!!");
				}
			}while(!isValid);
			return number;
		case "duration":
			do
			{
				isValid = true;
				System.out.println("Enter course duration in months:");
				number =  getValidatedInteger("Integer");
				if(number < 0 || number > 12)
				{
					isValid = false;
					System.out.println("The course duration should be within 12 try again!!");
				}
			}while(!isValid);
			return number;
		case "fee":
			do
			{
				isValid = true;
				System.out.println("Enter course fee:");
				number =  getValidatedInteger("Integer");
				if(number < 0 || number > 100000)
				{
					isValid = false;
					System.out.println("The course duration should be within 100000 try again!!");
				}
			}while(!isValid);
			return number;
		}
		return -1;
	}

	
	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "mobileNumber":
			do {
				isValid = true;
				System.out.println("Enter the mobile number:");
				inputString = input.next();
				if (inputString.length() != 10) {
					System.out.println("The mobile number should be 10 digit long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')) {
							isValid = false;
							System.out.println("Mobile number should be numeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter your name in alphastring :");
				inputString = input.next();
				for (int i = 0; i < inputString.length(); i++)
					if (!((inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
							|| (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z'))) {
						System.out.println("You have not entered a alphastring!Try again!!");
						isValid = false;
						break;
					}
			} while (!isValid);
			return inputString;
		case "gender":
			do {
				isValid = true;
				System.out.println("Enter your gender:");
				System.out.println("1.Male");
				System.out.println("2.Female");
				inputChoice = getValidatedInteger("Integer");
				if(inputChoice == 1)
					inputString = "Male";
				else if(inputChoice == 2)
					inputString = "Female";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "courseName":
			do { 
				isValid = true;
				System.out.println("Choose the courseName:");
				System.out.println("1. Guitar");
				System.out.println("2. Ukelete");
				System.out.println("3. Keyboard");
				System.out.println("4. Drums");
				System.out.println("5. ");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Guitar";
				else if (inputChoice == 2)
					inputString = "Ukelete";
				else if (inputChoice == 3)
					inputString = "Keyboard";
				else if (inputChoice == 4)
					inputString = "Drums";
				else if (inputChoice == 5)
					inputString = "Vocal";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again");
				}
			} while (!isValid);
			return inputString;
		case "address":
			
				System.out.println("Enter your address :");
				inputString = input.next();
			   return inputString;
		}
		return null;
	}

}
