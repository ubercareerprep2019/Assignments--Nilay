package homework2.Trees;

import homework2.Trees.Assets.PhoneBook;

public class BSTPhoneBook implements PhoneBook {
	// Variables
	private BinarySearchTree<BookEntry> tree;

	// Constructor
	public BSTPhoneBook() {
		tree = new BinarySearchTree<BookEntry>();
	}

	public int size() {
		return tree.size();
	}

	public void insert(String name, long phoneNumber) {
		tree.insert(new BookEntry(name, phoneNumber));
	}

	/*
	 * The search function for tree is slightly modified such that it only checks if
	 * the keys of the objects are equal. Therefore, passing a new object with just
	 * the key and any other long as the value would result in the tree returning
	 * the object with the matching key and the value we are looking for.
	 */
	public long find(String name) {
		BookEntry temp = new BookEntry(name, 0);
		temp = tree.search(temp);
		if (temp == null) {
			return -1;
		} else {
			return temp.getValue();
		}
	}
}
