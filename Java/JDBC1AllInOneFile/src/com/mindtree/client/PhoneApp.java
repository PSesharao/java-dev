package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.Phone;
import com.mindtree.exception.serviceexception.PhoneServiceException;
import com.mindtree.service.PhoneService;
import com.mindtree.service.impl.PhoneServiceImpl;

public class PhoneApp {

	private static PhoneService phoneService = new PhoneServiceImpl();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)  {
		// create a phone
		Phone phone = getCreatedPhone();
		// insert that phone in DB
		boolean isInsertedSuccessfully = false;
		try {
			isInsertedSuccessfully = phoneService.insertPhoneToDB(phone);
		} catch (PhoneServiceException e) {
			//System.out.println(e.getCause());
			//System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		if (isInsertedSuccessfully) {
			System.out.println("Phone got inserted successfully");
		} else {
			System.out.println("something went wrong..");
		}

		// retrieve all phones from DB
		List<Phone> insertedPhones = new ArrayList<Phone>();
		try {
			insertedPhones = phoneService.getAllPhonesFromDB();
		} catch (PhoneServiceException e) {
			e.printStackTrace();
		}
		displayPhonesFromDB(insertedPhones);
	}

	private static void displayPhonesFromDB(List<Phone> insertedPhones) {
		for (Phone phone : insertedPhones) {
			System.out.println(phone.getId() + " " + phone.getName() + " " + phone.getPrice());
		}

	}

	private static Phone getCreatedPhone() {
		
		System.out.println("Enter id of phone: ");
		int id = sc.nextInt();

		System.out.println("Enter Name of phone");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("Enter price of phone");
		double price = sc.nextDouble();

		Phone myPhone = new Phone(id, name, price);

		return myPhone;
	}

}
