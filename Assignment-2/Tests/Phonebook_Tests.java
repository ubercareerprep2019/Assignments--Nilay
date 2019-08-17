package homework2.Tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import java.util.*;

import homework2.Trees.BSTPhoneBook;
import homework2.Trees.ListPhoneBook;
import homework2.Trees.Assets.PhoneBook;

public class Phonebook_Tests {

	// Tests insert and find of the alphabet and random numbers for both phonebooks
	@Test
	public void testPhoneBooks1() {
		// Initiate the Phonebooks
		PhoneBook book1 = new ListPhoneBook();
		PhoneBook book2 = new BSTPhoneBook();
		
		// Initiate string and number
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		long l = (long) Math.pow(Math.random() * 50 + 1, Math.random() * 50 + 1); // Random number generator

		// Populate the books
		for (char c : alphabet.toCharArray()) {
			book1.insert(c + "", l);
			book2.insert(c + "", l);
			l = (long) (l * Math.random() + l); // Random number generator
		}

		// Check if the keys map to the same values in each book
		for (char c : alphabet.toCharArray()) {
			assertEquals(book1.find(c + ""), book2.find(c + ""));
		}
	}

	// Tests the speed of both the phonebooks. It imports a file consisting of Lorem
	// Ipsum text and inserts the word with a random number. It also stores the
	// results of each search in a list and compares them to make sure the searches
	// were successful
	@Test
	public void testPhoneBooks2() throws FileNotFoundException {
		// Import the text
		String path = System.getProperty("user.dir") + "/src/homework2/Tests/Assets/words.txt";
		Scanner scan = new Scanner(new File(path));
		String str = scan.nextLine();
		scan.close();

		// Initiate the Phonebooks
		PhoneBook book1 = new ListPhoneBook();
		PhoneBook book2 = new BSTPhoneBook();

		// Populate the phonebooks
		for (String s : str.split(" ")) {
			long number = (s.charAt(0) - '0') * (s.charAt(s.length() - 1) - '0') * s.length(); // Random number generator
			book1.insert(s, number);
			book2.insert(s, number);
		}

		// Initiate lists for search verification
		List<Long> ans1 = new ArrayList<Long>();
		List<Long> ans2 = new ArrayList<Long>();

		// Calculate seach time for book1
		long startTime = System.currentTimeMillis();
		for (String s : str.split(" ")) {
			ans1.add(book1.find(s));
		}
		long endTime = System.currentTimeMillis();
		long List_Time = endTime - startTime;

		// Calculate seach time for book2
		startTime = System.currentTimeMillis();
		for (String s : str.split(" ")) {
			ans2.add(book2.find(s));
		}
		endTime = System.currentTimeMillis();
		long BST_Time = endTime - startTime;

		// Check if BST is faster than List
		assertTrue(BST_Time < List_Time);
		// Check if seach was successful and there were no leaks
		assertTrue(ans1.containsAll(ans2) && ans2.size() == ans1.size());
	}

}
