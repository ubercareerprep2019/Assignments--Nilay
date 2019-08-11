package homework2.Trees;

import java.util.*;

import homework2.Trees.Assets.PhoneBook;

public class ListPhoneBook implements PhoneBook {
	// Variables
	private List<BookEntry> list;
	
	// Constructor
	public ListPhoneBook() {
		list = new ArrayList<BookEntry>();
	}
	
	// returns the size of the book
	public int size() {
		return list.size();
	}

	// Inserts the name and phone number in the book by creating a new BookEntry
	public void insert(String name, long phoneNumber) {
		list.add(new BookEntry(name, phoneNumber));
	}

	// Returns the value corresponding to the input key if it exists, otherwise it returns -1
	public long find(String name) {
		for(BookEntry e : list) {
			if(e.getKey().equals(name)) {
				return e.getValue();
			}
		}
		return -1;
	}
}
