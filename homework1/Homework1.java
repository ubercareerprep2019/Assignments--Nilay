package homework1;

import java.util.*;
import java.util.stream.IntStream;
import org.w3c.dom.Node;

public class Homework1 {

	public static void main(String[] args) {

		/*
		 * 		Custom test space for the 2 functions.
		 */
		
//		String s1 = "";		// Fill in with desired string
//		String s2 = "";		// Fill in with desired string
//		
//		if(isStringPermutation(s1, s2)) {
//			System.out.println("The 2 strings are permutations!");
//		}
//		else {
//			System.out.println("The 2 strings are not permutations :(");
//		}
//		
//
//		System.out.println("\n------------------------------------------------------------------- \n");
//		
//		
//		int[] arr = IntStream.range(-3, 14).toArray();				// Fill in numbers
//		int target = 5;											// Set a target number
//		
//		ArrayList<int[]> list = pairsThatEqualSum(arr, target);
//		
//		for(int[] a : list) {
//			System.out.println(a[0] + " + " + a[1]);
//		}
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		System.out.println(stack.isFull());
		stack.push(19);
		stack.push(29);
		stack.push(39);
		System.out.println(stack.pop());
		System.out.println(stack.isFull());
		stack.pop();
		System.out.println(stack.top());
		stack.push(99);
		System.out.println(stack.top());
		

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
				 map1.put(c, 1);
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
				 map2.put(c, 1);
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
	 * 		The function first transfers all the integers from the array to a Hashtable and computes each integers frequency.
	 * 		For a given n, it checks if there exists a number 'target-n' (also makes sure for cases where n = target-n and there is only 1 occurance of n)
	 * 		If it can find a valid pair, it adds both in a list which is returned. The algorithm should run in O(n) time.
	 * 
	 * 		Assumptions made-
	 * 			- The array might contains multiple occurances of the same number.
	 * 			- The output list should only consider unique equations (eg- 1 + 2 and 2 + 1 are the same and not unique)
	 * 	 		
	 */
	public static ArrayList<int[]> pairsThatEqualSum(int[] arr, int target) {	
		
		// Using a hashtable to store the values and their frequencies from input array/
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		
		// A list to store all the valid pairs.
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		// Populates the hashtable with respective values and frequencies
		for(int n : arr) {
			if(hash.containsKey(n)) {
				int freq = hash.get(n);
				hash.replace(n, freq+1);
			}
			else {
				hash.put(n, 1);
			}
		}
		
		// for every value from the hashtable, checks if there is another value which can add up to the target.
		for(int n : arr) {
			
			// Gets the frequency and reduces it by 1 to make sure it doesn't ust the same number twice unless it exists multiple times.
			int freq = hash.get(n);
			hash.replace(n, freq-1);
			
			// If there is a number (target-n) that exists in the table such that it isn't the number we're looking at right now, then we have a successful pair.
			if(hash.containsKey(target-n) && hash.get(target-n) > 0) {
				int[] a = {n, target-n};
				list.add(a);
			}
			// If we are not able to find a (target-n) then we put the current number back in the table since we didn't use it.
			else {
				hash.replace(n, freq);
			}
		}
		
		return list;
	}

}




/*
 * Part 3: Stacks & Queues
 */


	/*
	 * 		The Stack is implemented using a generic array. It has a default size of 10 but you can also specify the desired size when initializing your stack.
	 * 		The Stack has the following methods-
	 * 			push(T ele) - It adds an element to the stack
	 * 			pop()		- It removes the top element from the stack
	 * 			pop(T ele)	- It removes the specified element from the stack
	 * 			top() 		- It returns the top element on the stack without removing it
	 * 			isEmpty()	- It returns a boolean depending on if the stack is empty or not
	 * 			isFull()	- It returns a boolean depending on if the stack is full or not
	 */

class Stack<T> {
	private int defSize = 10;	// default size of the array when initialized
	private T[] arr;
	private int top;
	
	// Constructor for initializing
	public Stack() {
		arr = (T[]) new Object[defSize];
		top = -1;
	}

	// Constructor for initializing with specific size
	public Stack(int size) {
		defSize = size;
		arr = (T[]) new Object[defSize];
		top = -1;
	}

	public void push(T element) {
		// If the array is full, it creates a new one with double the size, copies all elements to it and then pushes the elements which is passed in.
		if(this.isFull()) {
			T[] temp = (T[]) new Object[defSize*2];
			for(int i = 0; i <= top; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
			defSize = defSize*2;
		}
		arr[++top] = element;
	}

	public T pop() {
		if(this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		T ans = arr[top];
		arr[top] = null;
		top--;
		return ans;
	} 
	
	public T pop(T val) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == val) {
				T ans = arr[i];
				for(int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j+1];
				}
				arr[arr.length-1] = null;
				top--;
				return ans;
			}
		}
		System.out.println("The stack does not contain " + val);
		return null;
	}

	public T top() {
		if(this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		return arr[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top >= (defSize-1);
	}

}
