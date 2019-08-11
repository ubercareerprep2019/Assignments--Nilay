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

	@Test
	public void testPhoneBooks1() {
		PhoneBook book1 = new ListPhoneBook();
		PhoneBook book2 = new BSTPhoneBook();
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		long l = 1099;
		
		for(char c : alphabet.toCharArray()) {
			book1.insert(c + "", l);
			book2.insert(c + "", l);
			
			l = (long) (l * Math.random() + l);
		}
		
		for(char c : alphabet.toCharArray()) {
			assertEquals(book1.find(c+""), book2.find(c+""));
		}
	}
	
	@Test
	public void testPhoneBooks2() throws FileNotFoundException {
		String path = System.getProperty("user.dir") + "/src/homework2/Tests/Assets/words.txt";
		Scanner scan = new Scanner(new File(path));
		
		PhoneBook book1 = new ListPhoneBook();
		PhoneBook book2 = new BSTPhoneBook();
		
		String str = scan.nextLine();
		scan.close();
		
		for(String s : str.split(" ")) {
			long number = (s.charAt(0) - '0') * (s.charAt(s.length()-1) - '0') * s.length();	// Hash Function

			book1.insert(s, number);
			book2.insert(s, number);
		}
		
		List<Long> ans1 = new ArrayList<Long>();
		List<Long> ans2 = new ArrayList<Long>();
		
		long startTime = System.currentTimeMillis();
		for(String s : str.split(" ")) {
			ans1.add(book1.find(s));
		}
		long endTime = System.currentTimeMillis();
		
		long List_Time = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		for(String s : str.split(" ")) {
			ans2.add(book2.find(s));
		}
		endTime = System.currentTimeMillis();
		
		long BST_Time = endTime - startTime;
		
		System.out.println(BST_Time + " " + List_Time);
		
		assertTrue(BST_Time < List_Time);
		assertTrue(ans1.containsAll(ans2) && ans2.size() == ans1.size());
	}

}
