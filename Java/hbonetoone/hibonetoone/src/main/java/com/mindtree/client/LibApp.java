package com.mindtree.client;

import java.util.Scanner;

import org.hibernate.Session;

import com.mindtree.entity.Book;
import com.mindtree.entity.Library;
import com.mindtree.utility.SessionUtil;

public class LibApp {
	private static Scanner input = new Scanner(System.in);
	private static Book bookObj;
	private static Library libObj;
	private static SessionUtil hbutil = new SessionUtil();

	public static void main(String[] args) {
		Session sessionObj = null;
		try {
			sessionObj = hbutil.buildSession().openSession();
			sessionObj.beginTransaction();
			bookObj = getBookDetails();
			sessionObj.save(bookObj);
			libObj = getLibraryDetails();
			libObj.setBook(bookObj);
			sessionObj.save(libObj);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			/*songObj = sessionObj.get(Song.class, "song1");
			System.out.println(songObj);*/
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

	private static Book getBookDetails() {
		System.out.println("Enter the book Id:");
		String bookId = input.next();
		System.out.println("Enter the book name:");
		String bookName = input.next();
		return new Book(bookId, bookName);
	}
	
	private static Library getLibraryDetails()
	{
		System.out.println("Enter library Id :");
		String libId = input.next();
		System.out.println("Enter library Name :");
		String libName =  input.next();
		return new Library(libId, libName);
	}

}
