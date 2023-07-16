package com.mindtree.client;

import java.util.Scanner;

import com.mindtree.entity.Author;
import com.mindtree.entity.Book;
import com.mindtree.entity.Library;
import com.mindtree.entity.Name;
import com.mindtree.serivce.implementation.LibraryService;

public class LibraryApplication {
	private static Scanner input = new Scanner(System.in);
	private static LibraryService libService = new LibraryService();

	public static void main(String[] args) {
		LibraryApplication libApp = new LibraryApplication();
		libApp.driverMethod();
	}

	private void driverMethod() {
		Author[] authorRecord = new Author[0];
		Book[] bookRecord = new Book[0];
		Library[] libraryRecord = new Library[0];
		String authId, libId, bookId;
		int choice;
		int prevHistory;
		boolean isEntered;
		do {
			choice = createMenu();
			switch (choice) {
			case 1:
				do {
					isEntered = true;
					System.out.println("Reading author id :");
					authId = getValidatedInput("id");
					prevHistory = libService.getPrevRecord(authorRecord, authId);
					if (prevHistory == -1) {
						Author authorEntry = new Author(authId,
								new Name(getValidatedInput("firstName"), getValidatedInput("lastName")),
								getValidatedInput("gender"), getValidatedInteger("age"));
						authorRecord = libService.addEntry(authorRecord, authorEntry);
					} else {
						System.out.println("The artist " + (authId) + " has been registered before!!Try again");
						isEntered = false;
					}
				} while (!isEntered);
				break;
			case 2:
				do {
					isEntered = true;
					System.out.println("Reading book id :");
					bookId = getValidatedInput("id");
					prevHistory = libService.getPrevRecord(bookRecord, bookId);
					if (prevHistory == -1) {
						System.out.println("Reading the book details :");
						Book bookEntry = new Book(bookId, getValidatedInput("name"), getValidatedInteger("price"),
								getValidatedInput("language"));
						// songEntry.setArtistCrew(new Artist[0]);
						bookEntry.setAuthorList(new Author[0]);
						System.out.println("Reading no of author who wrote the book :");
						int noOfAuthor = getValidatedInteger("no");
						if (noOfAuthor > authorRecord.length) {
							System.out.println("You dont have enough authors registered to write book");
						} else {
							boolean isValid;
							System.out.println("Reading crew details ");
							for (int i = 0; i < noOfAuthor; i++) {
								do {
									isValid = true;
									System.out.println("Reading author id of " + (i + 1) + " author:");
									authId = getValidatedInput("id");
									prevHistory = libService.getPrevRecord(authorRecord, authId);
									if (prevHistory == -1) {
										isValid = false;
										System.out.println("The author " + (authId)
												+ " has not been registered before, Try again");
									} else {
										int prevLocalHistory = libService.getPrevRecord(bookEntry.getAuthorList(),
												authId);
										if (prevLocalHistory == -1) {
											bookEntry.setAuthorList(libService.addEntry(bookEntry.getAuthorList(),
													authorRecord[prevHistory]));

										} else {
											System.out.println("The author " + (authId)
													+ " has been added to the book already, Try again");
											isValid = false;
										}
									}
								} while (!isValid);

							}
							bookRecord = libService.addEntry(bookRecord, bookEntry);
						}
					} else {
						System.out.println("The book " + (bookId) + " has been registered before Try again");
						isEntered = false;
					}
				} while (!isEntered);
				break;
			case 3:
				do {
					isEntered = true;
					System.out.println("Reading library id :");
					libId = getValidatedInput("id");
					prevHistory = libService.getPrevRecord(libraryRecord, libId);
					if (prevHistory == -1) {
						System.out.println("Reading the library details :");
						Library libraryEntry = new Library(libId, getValidatedInput("name"));
						libraryEntry.setBookList(new Book[0]);
						System.out.println("Reading no of books present in the library:");
						int noOfBooks = getValidatedInteger("no");
						boolean isValid;
						System.out.println("Reading book details ");
						for (int i = 0; i < noOfBooks; i++) {
							do {
								isValid = true;
								System.out.println("Reading book id of " + (i + 1) + " book:");
								bookId = getValidatedInput("id");
								prevHistory = libService.getPrevRecord(bookRecord, bookId);
								if (prevHistory == -1) {
									isValid = false;
									System.out.println(
											"The book " + (bookId) + " has not been registered before, Try again");
								} else {
									libraryEntry.setBookList(
											libService.addEntry(libraryEntry.getBookList(), bookRecord[prevHistory]));
								}
							} while (!isValid);

						}
						libraryRecord = libService.addEntry(libraryRecord, libraryEntry);
					} else {
						System.out.println("The library " + (libId) + " has been registered before Try again");
						isEntered = false;
					}
				} while (!isEntered);
				break;
			case 4:
				System.out.println("Reading author id :");
				authId = getValidatedInput("id");
				Library libraryByAuth[] = libService.getAllLibraryByAuthor(libraryRecord, authId);
				for (int i = 0; i < libraryByAuth.length; i++)
					showLibrary(libraryByAuth[i]);
				break;
			case 5:
				Author youngAuth = libService.findYoungestAuthor(authorRecord);
				authId = youngAuth.getId();
				Book booksByAuth[] = libService.getAllBooksByAuthor(bookRecord, authId);
				for (int i = 0; i < booksByAuth.length; i++)
					System.out.println(booksByAuth[i].getName());
				break;
			case 6:
				String language;
				language = getValidatedInput("language");
				System.out.println("Reading library id :");
				libId = getValidatedInput("id");
				prevHistory = libService.getPrevRecord(libraryRecord, libId);
				if (prevHistory == -1) {
					System.out.println("The library " + (libId) + " has not been registered before Try again");
				} else {
					Book[] bookArray = libService.getAllBooksBasedOnGivenLanguageAndLibrary(language,
							libraryRecord[prevHistory]);
					for (int i = 0; i < bookArray.length; i++) {
						System.out.println(bookArray[i].getName());
					}
				}
				break;
			case 7:
				System.out.println("Reading library id :");
				libId = getValidatedInput("id");
				prevHistory = libService.getPrevRecord(libraryRecord, libId);
				if (prevHistory == -1) {
					System.out.println("The library " + (libId) + " has not been registered before Try again");
				} else {
					Book cost[] = libService.getCheapAndCostlyBook(libraryRecord[prevHistory]);
					System.out.println("The cheapest book is :" + cost[0].getName());
					System.out.println("The costliest book is :" + cost[1].getName());
				}
				break;
			case 8:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter right choice");
			}
		} while (choice != 8);
	}

	private void showLibrary(Library library) {
		System.out.println("Library Id:\t" + library.getId());
		System.out.println("Library Name:\t" + library.getName());
		System.out.println("The available books in library are :");
		System.out.println();
		for (int i = 0; i < library.getBookList().length; i++) {
			System.out.println(library.getBookList()[i].getName());
		}
	}

	public Author[] addEntry(Author[] authorRecord, Author authorEntry) {
		int currLen = authorRecord.length;
		Author temp[] = new Author[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = authorRecord[i];
		temp[currLen] = authorEntry;
		return temp;
	}

	public Book[] addEntry(Book[] bookRecord, Book bookEntry) {
		int currLen = bookRecord.length;
		Book temp[] = new Book[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = bookRecord[i];
		temp[currLen] = bookEntry;
		return temp;
	}

	public Library[] addEntry(Library[] libraryRecord, Library libraryEntry) {
		int currLen = libraryRecord.length;
		Library temp[] = new Library[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = libraryRecord[i];
		temp[currLen] = libraryEntry;
		return temp;
	}

	public int getPrevRecord(Author[] authorRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < authorRecord.length; i++) {
			if (authorRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	public int getPrevRecord(Book[] bookRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < bookRecord.length; i++) {
			if (bookRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	public int getPrevRecord(Library[] libraryRecord, String id) {
		int prevHist = -1;
		for (int i = 0; i < libraryRecord.length; i++) {
			if (libraryRecord[i].getId().compareTo(id) == 0) {
				prevHist = i;
				break;
			}
		}
		return prevHist;
	}

	private int createMenu() {
		int choice;
		System.out.println("Enter your choice:");
		System.out.println("1. Add new author details:");
		System.out.println("2. Add new book details:");
		System.out.println("3. Add new library details:");
		System.out.println("4. Get and show all libraries by given author");
		System.out.println("5. Get all books written by youngest author");
		System.out.println("6. Get all books in given language at given library");
		System.out.println("7. Get the cheapest and costliest book present in the given library");
		System.out.println("8. Exit");
		choice = getValidatedInteger("Integer");
		return choice;
	}

	private String getValidatedInput(String validationType) {
		String inputString;
		boolean isValid;
		int inputChoice;
		switch (validationType) {
		case "firstName":
			do {
				isValid = true;
				System.out.println("Enter author firstname in alphastring :");
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
		case "lastName":
			do {
				isValid = true;
				System.out.println("Enter author lastname in alphastring :");
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
		case "name":
			do {
				isValid = true;
				System.out.println("Enter name in alphastring :");
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
				if (inputChoice == 1)
					inputString = "Male";
				else if (inputChoice == 2)
					inputString = "Female";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "language":
			do {
				isValid = true;
				System.out.println("Enter language:");
				System.out.println("1.Hindi");
				System.out.println("2.Telugu");
				System.out.println("3.English");
				System.out.println("4.Tamil");
				System.out.println("5.Kannada");
				System.out.println("6.Malayalam");
				System.out.println("7.Sanskrit");
				inputChoice = getValidatedInteger("Integer");
				if (inputChoice == 1)
					inputString = "Hindi";
				else if (inputChoice == 2)
					inputString = "Telugu";
				else if (inputChoice == 3)
					inputString = "English";
				else if (inputChoice == 4)
					inputString = "Tamil";
				else if (inputChoice == 5)
					inputString = "Kannada";
				else if (inputChoice == 6)
					inputString = "Malayalam";
				else {
					inputString = null;
					isValid = false;
					System.out.println("Wrong choice try again!!");
				}
			} while (!isValid);
			return inputString;
		case "id":
			do {
				isValid = true;
				System.out.println("Enter the id:");
				inputString = input.next();
				if (inputString.length() > 10) {
					System.out.println("The id should not be more than 10 character long");
					isValid = false;
				} else {
					for (int i = 0; i < inputString.length(); i++)
						if (!(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')
								&& !(inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')
								&& !(inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')) {
							isValid = false;
							System.out.println("id should be alphanumeric,try again");
							break;

						}
				}
			} while (!isValid);
			return inputString;
		}
		return null;
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
			do {
				isValid = true;
				System.out.println("Enter artist age :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 150) {
					isValid = false;
					System.out.println("The age is invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "no":
			do {
				isValid = true;
				System.out.println("Enter size :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 10) {
					isValid = false;
					System.out.println("The size invalid try again!!");
				}
			} while (!isValid);
			return number;
		case "price":
			do {
				isValid = true;
				System.out.println("Enter the price :");
				number = getValidatedInteger("Integer");
				if (number < 0 || number > 5000) {
					isValid = false;
					System.out.println("The price is invalid try again!!");
				}
			} while (!isValid);
			return number;
		}
		return -1;
	}

}
