package com.mindtree.serivce;

import com.mindtree.entity.Author;
import com.mindtree.entity.Book;
import com.mindtree.entity.Library;

public interface LibraryServiceable {
	Book[] getCheapAndCostlyBook(Library library);
	Book[] getAllBooksBasedOnGivenLanguageAndLibrary(String language , Library library);
	Book[] getAllBooksByAuthor(Book[] bookRecord , String authId );
	Author findYoungestAuthor(Author[] authorRecord);
	Library[] getAllLibraryByAuthor(Library[] libraryRecord , String authId);
	Author[] addEntry(Author[] authorRecord, Author authorEntry);
	Book[] addEntry(Book[] bookRecord, Book bookEntry);
	Library[] addEntry(Library[] libraryRecord, Library libraryEntry);
	int getPrevRecord(Author[] authorRecord, String id) ;
	int getPrevRecord(Book[] bookRecord, String id);
	int getPrevRecord(Library[] libraryRecord, String id);
}
