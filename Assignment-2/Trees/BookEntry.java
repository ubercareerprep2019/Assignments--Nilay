package homework2.Trees;

import javafx.util.Pair;

public class BookEntry extends Pair<String, Long> implements Comparable<BookEntry> {

	private static final long serialVersionUID = 1L;
	
	// Constructor
	public BookEntry(String name, long number) {
		super(name, number);
	}
	
	// Compares only the keys of the pair
	public int compareTo(BookEntry e) {
		return this.getKey().compareTo(e.getKey());
	}
	
	public String toString() {
		return ("Name: " + this.getKey() + " Number: " + this.getValue() + " | ");
	}
}
