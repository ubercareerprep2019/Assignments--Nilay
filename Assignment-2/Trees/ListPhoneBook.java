package homework2.Trees;

import java.util.*;

public class ListPhoneBook implements PhoneBook {
	// Variables
	private List<BookEntry> list;
	
	// Constructor
	public ListPhoneBook() {
		list = new ArrayList<BookEntry>();
	}
	
	public int size() {
		return list.size();
	}

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
