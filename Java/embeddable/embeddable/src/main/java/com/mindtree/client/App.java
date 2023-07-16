package com.mindtree.client;

import java.util.Scanner;

import org.hibernate.Session;

import com.mindtree.entity.Address;
import com.mindtree.entity.Student;
import com.mindtree.utility.SessionUtil;

public class App {
	private static Scanner input = new Scanner(System.in);
	private static Student student;
	private static Address address;
	private static SessionUtil hbutil = new SessionUtil();

	public static void main(String[] args) {
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			student = getStudentDetails();
			address = getAddressDetails();
			student.setAddress(address);
			sessionObj.save(student);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			hbutil.closeResource(sessionObj);
		}
	}

	private static Student getStudentDetails() {
		System.out.println("Enter student roll number :");
		String rollNum = input.next();
		System.out.println("Enter student name :");
		String name = input.next();
		return new Student(rollNum, name);
	}

	private static Address getAddressDetails() {
		System.out.println("Enter street :");
		String street = input.next();
		System.out.println("Enter city :");
		String city = input.next();
		System.out.println("Enter state :");
		String state = input.next();
		System.out.println("Enter pincode :");
		String pincode = input.next();
		return new Address(street, city, state, pincode);

	}
}
