package com.mindtree.serivce.implementation;

import com.mindtree.entity.Author;
import com.mindtree.entity.Book;
import com.mindtree.entity.Library;
import com.mindtree.serivce.LibraryServiceable;

public class LibraryService implements LibraryServiceable {

	@Override
	public Book[] getCheapAndCostlyBook(Library library) {
		int cheapIndex = -1, costlyIndex = -1, cheap = 999999, costly = -1;
		Book cost[] = new Book[2];
		for (int i = 0; i < library.getBookList().length; i++) {
			if (library.getBookList()[i].getPrice() < cheap) {
				cheap = library.getBookList()[i].getPrice();
				cheapIndex = i;
			}
			if (library.getBookList()[i].getPrice() > costly) {
				costly = library.getBookList()[i].getPrice();
				costlyIndex = i;
			}
		}
		cost[0] = library.getBookList()[cheapIndex];
		cost[1] = library.getBookList()[costlyIndex];
		return cost;
	}

	@Override
	public Author findYoungestAuthor(Author[] authorRecord) {
		int index = -1, age = 99999;
		for (int i = 0; i < authorRecord.length; i++) {
			if (authorRecord[i].getAge() < age) {
				age = authorRecord[i].getAge();
				index = i;
			}
		}
		return authorRecord[index];
	}

	@Override
	public Author[] addEntry(Author[] authorRecord, Author authorEntry) {
		int currLen = authorRecord.length;
		Author temp[] = new Author[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = authorRecord[i];
		temp[currLen] = authorEntry;
		return temp;
	}

	@Override
	public Book[] addEntry(Book[] bookRecord, Book bookEntry) {
		int currLen = bookRecord.length;
		Book temp[] = new Book[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = bookRecord[i];
		temp[currLen] = bookEntry;
		return temp;
	}

	@Override
	public Library[] addEntry(Library[] libraryRecord, Library libraryEntry) {
		int currLen = libraryRecord.length;
		Library temp[] = new Library[currLen + 1];
		for (int i = 0; i < currLen; i++)
			temp[i] = libraryRecord[i];
		temp[currLen] = libraryEntry;
		return temp;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
	public Library[] getAllLibraryByAuthor(Library[] libraryRecord, String authId) {
		Library libraryByAuth[] = new Library[0];
		boolean added;
		for (int i = 0; i < libraryRecord.length; i++) {
			added = false;
			for (int j = 0; j < libraryRecord[i].getBookList().length; j++)
				for (int k = 0; k < libraryRecord[i].getBookList()[j].getAuthorList().length; k++) {
					if (libraryRecord[i].getBookList()[j].getAuthorList()[k].getId().compareTo(authId) == 0 && !added) {
						libraryByAuth = addEntry(libraryByAuth, libraryRecord[i]);
						added = true;
					}
				}
		}
		return libraryByAuth;
	}

	@Override
	public Book[] getAllBooksBasedOnGivenLanguageAndLibrary(String language, Library library) {
		Book[] bookArray = new Book[0];
		for (int i = 0; i < library.getBookList().length; i++) {
			if (library.getBookList()[i].getLanguage().compareTo(language) == 0) {
				bookArray = addEntry(bookArray, library.getBookList()[i]);
			}
		}
		return bookArray;
	}

	@Override
	public Book[] getAllBooksByAuthor(Book[] bookRecord, String authId) {
		Book booksByAuth[] = new Book[0];
		for (int i = 0; i < bookRecord.length; i++) {
			for (int j = 0; j < bookRecord[i].getAuthorList().length; j++) {
				if (bookRecord[i].getAuthorList()[j].getId().compareTo(authId) == 0)
					booksByAuth = addEntry(booksByAuth, bookRecord[i]);
			}
		}
		return booksByAuth;
	}

}
