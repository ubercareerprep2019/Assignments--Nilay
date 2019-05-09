package homework1;

import java.util.*;
import org.w3c.dom.Node;

public class Homework1 {
	// arguments are passed using the text field below this editor
	public static void main(String[] args) {

		/*
		 * 		Custom test space for the 2 functions.
		 */

		String s1 = "";		// Fill in with desired string
		String s2 = "";		// Fill in with desired string

		if(isStringPermutation(s1, s2)) {
			System.out.println("The 2 strings are permutations!");
		}
		else {
			System.out.println("The 2 strings are not permutations :(");
		}


		System.out.println("\n------------------------------------------------------------------- \n");


		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};					// Fill in numbers
		int target = 10;											// Set a target number

		ArrayList<int[]> list = pairsThatEqualSum(arr, target);

		for(int[] a : list) {
			System.out.println(a[0] + " + " + a[1]);
		}



	}

/*
* Part 2: Arrays & Strings
*/

	/*
	 * 		The function uses 2 HashMaps to store the frequencies from each of the input strings and a HashSet to store all the unique characters (needed to interate over the 2 HashMaps in the end).
	 * 		The function basically calculates the frequency of each unique character from the strings and then returns true only if the frequencies match for every character.
	 * 		The runtime for this function should be O(n).
	 *
	 * 		Following assumptions made for this program-
	 * 			- The strings can contain any character including numbers and other characters.
	 * 			- The function is case sensitive, meaning that it will look at 'A' and 'a' differently and hence they won't be a valid permutation.
	 * 			- The function will consider 2 strings to be valid permutations only if they have the same length.
	 */
	public static boolean isStringPermutation(String s1, String s2) {

		// The assumption I made was that a string "abc" and "abcc" are not valid permutations.
		if (s1.length() != s2.length()) {
			return false;
		}

		// Using a HashMap to store the characters and their frequencies for each string
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

		// Using a HashSet to store all unique characters
		HashSet<Character> set = new HashSet<Character>();

		// Populating the HashMap with the character frequencies for String s1
		for (char c : s1.toCharArray()) {
			if(map1.containsKey(c)) {
				int i = map1.get(c);
				map1.put(c, i++);
			}
			else {
				 map1.put(c, 0);
			}
			set.add(c);
		}

		// Populating the HashMap with the character frequencies for String s2
		for (char c : s2.toCharArray()) {
			if(map2.containsKey(c)) {
				int i = map2.get(c);
				map2.put(c, i++);
			}
			else {
				 map2.put(c, 0);
			}
			set.add(c);
		}

		// Using all unique characters from the HashSet to iterate over the HashMaps and check if the frequencies match for each character from both strings.
		for(char c : set) {
			if(map1.get(c) != map2.get(c)) {
				return false;
			}
		}

		return true;
	}



	/*
	 * 		The function first transfers all the integers from the array to a HashSet for maximium efficiency.
	 * 		For a given num1 there has to be only one num1 which will add to the target (num2 = target - num1).
	 * 		So for each number, we look up if the HashSet contains its pair such that they add up to the target. If it does, it add this pair to a list which is eventually returned.
	 */
	public static ArrayList<int[]> pairsThatEqualSum(int[] inputArray, int targetSum) {

		// Using a HashSet to store all the numbers for more efficiency.
		HashSet<Integer> hash = new HashSet<Integer>();

		// The list that stores all the valid pairs.
		ArrayList<int[]> list = new ArrayList<int[]>();

		// Transfers all the numbers im the HashSet.
		for (int n : inputArray) {
			hash.add(n);
		}

		// For every number, it checks if the HashSet contains the only other number which would add up to the given target.
		for (int num1 : inputArray) {
			if (hash.contains(targetSum - num1)) {
				int[] arr = { num1, targetSum - num1 };
				list.add(arr);
				hash.remove(num1);
				hash.remove(targetSum-num1);
			}
		}

		return list;
	}

}
