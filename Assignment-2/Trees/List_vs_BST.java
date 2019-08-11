package homework2.Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homework2.Trees.Assets.PhoneBook;

public class List_vs_BST {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Create 2 phone books of each type and filepaths for the each of the files
		 */
		PhoneBook book1 = new ListPhoneBook();
		PhoneBook book2 = new BSTPhoneBook();
		String data_path = System.getProperty("user.dir") + "/src/homework2/Trees/Assets/data.csv";
		String search_path = System.getProperty("user.dir") + "/src/homework2/Trees/Assets/search.txt";

		// Scan the data file
		Scanner scan = new Scanner(new File(data_path));

		/*
		 * Parse each line from the file and populate both the phone books. Log total
		 * time taken for this.
		 */
		long startTime = System.currentTimeMillis();
		while (scan.hasNextLine()) {
			String[] line = scan.nextLine().split(",");

			String name = line[0];
			long phoneNumber = Long.parseLong(line[1]);

			book1.insert(name, phoneNumber);
			book2.insert(name, phoneNumber);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Insert took " + (endTime - startTime) + " ms.");

		// Check if the sizes are equals to given constant size
		System.out.println("Check for size of both books equal the constant size(1000000) - "
				+ (book1.size() == 1000000 && book2.size() == 1000000));

		/*
		 * Scan the search file and make a list of search queries
		 */
		scan = new Scanner(new File(search_path));
		List<String> searchQueries = new ArrayList<String>();
		while (scan.hasNextLine()) {
			searchQueries.add(scan.nextLine());
		}
		scan.close();

		/*
		 * Create two lists to store answers for queries from each book, log the search
		 * times for each and check if the queries result in same answers.
		 */
		List<Long> ans1 = new ArrayList<Long>();
		List<Long> ans2 = new ArrayList<Long>();

		startTime = System.currentTimeMillis();
		for (String s : searchQueries) {
			ans1.add(book1.find(s));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Find for book1 took " + (endTime - startTime) + " ms.");

		startTime = System.currentTimeMillis();
		for (String s : searchQueries) {
			ans2.add(book2.find(s));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Find for book2 took " + (endTime - startTime) + " ms.");

		// Checks that the queries result in same values for both books.
		System.out.println("Check for consistent answers throughout both books- "
				+ (ans1.containsAll(ans2) && ans1.size() == ans2.size()));
	}

}
