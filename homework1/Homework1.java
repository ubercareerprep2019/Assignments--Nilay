package homework1;
import java.util.*;
import org.w3c.dom.Node;


public class Homework1 {
	// arguments are passed using the text field below this editor
	public static void main(String[] args) {
		
		// Testing for isStringPermutation-
		String[] s1 = {"Car", "Arc"};
		Boolean ans1 = true;
		
		String[] s2 = {"World", "Lord"};
		Boolean ans2 = false;
		
		String[][] testStrings = {s1, s2};
		Boolean[] answers = {ans1, ans2};
		
		if(testStringPermutation(testStrings, answers)) {
			System.out.println("All tests for isStringPermutation passed successfully!");
		}
		else {
			System.out.println("Tests Failed for isStringPermutation :(");
		}
		
		
		
		// Testing for pairsThatEqualSums-
		int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
		int t1 = 14;
		
		int[] a2 = {10, 20, 30, 40, 50};
		int t2 = 50;
		
		int[][] testNumbers = {a1, a2};
		int[] testTarget = {t1, t2};
		
		if(testPairsThatEqualSums(testNumbers, testTarget)) {
			System.out.println("All tests for pairsThatEqualSums passed successfully!");
		}
		else {
			System.out.println("Tests Failed for pairsThatEqualSums :(");
		}
		
		
		
		//System.out.println("Hello world");
		
		
	}

	/*
	 * Part 2: Arrays & Strings
	 */

	public static boolean isStringPermutation(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		
		int[] mapS1 = new int[26];
		int[] mapS2 = new int[26];

		for (char c : s1.toLowerCase().toCharArray()) {
			mapS1[c - 'a']++;
		}

		for (char c : s2.toLowerCase().toCharArray()) {
			mapS2[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (mapS1[i] != mapS2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int[][] pairsThatEqualSum(int[] inputArray, int targetSum) {

		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int num1 : inputArray) {
			int num2 = targetSum - num1;
			if (Arrays.binarySearch(inputArray, num2) > -1) {
				int[] arr = { num1, num2 };
				list.add(arr);
			}
		}

		int[][] ans = new int[list.size()][2];

		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}

		return ans;
	}
	
	
	public static boolean testStringPermutation(String[][] inputStrings, Boolean[] answers) {
		int i = 0;
		for(String[] strings : inputStrings) {
			String s1 = strings[0];
			String s2 = strings[1];
			if(isStringPermutation(s1, s2) != answers[i]) {
				System.out.println("Error Caused due to: " +  s1 + " & " + s2 + " are not permutations.");
				return false;
			}
			i++;
		}
		
		return true;
	}
	

	public static boolean testPairsThatEqualSums(int[][] inputArr, int[] target) {
		for(int i = 0; i < inputArr.length; i++) {
			int[][] result = pairsThatEqualSum(inputArr[i], target[i]);
			for(int[] arr : result) {
				if(arr[0] + arr[1] != target[i]) {
					System.out.println("Error Caused due to: " + arr[0] + " + " + arr[1] + " = " + target[i]);
					return false;
				}
			}
		}
		return true;
	}

}




/*
 * Part 3: Stacks & Queues
 */

class Stack<T> {

	private ArrayList<T> stack;
	private int size;

	public Stack() {
		stack = new ArrayList<T>();
		size = 0;
	}

	public void push(T element) {
		stack.add(element);
		size++;
	}

	public T pop() {
		T ans = stack.remove(size - 1);
		size--;
		return ans;
	}

	public T top() {
		return stack.get(size - 1);
	}

	public boolean isEmpty() {
		return size == 0;
	}

}

class Queue<T> {

	private Stack<T> queue;
	private Stack<T> helperQueue;
	private int size;
	int min;

	public Queue() {
		queue = new Stack<T>();
		helperQueue = new Stack<T>();
		size = 0;
		min = Integer.MAX_VALUE;
	}

	public void enqueue(T element) {
		queue.push(element);
		size++;
		if ((int) element < min) {
			min = (int) element;
		}
	}

	public T dequeue() {
		while (!queue.isEmpty()) {
			helperQueue.push(queue.pop());
		}
		return helperQueue.pop();
	}

	public int min() {
		return min;
	}

}




/*
 * Part 4: Linked List
 */

class LinkedList<T> {

	Node head, tail;
	int size;

	public LinkedList(T val) {
		head = new Node(val, null);
		tail = head;
		size++;
	}

	public void pushBack(T val) {
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		Node newNode = new Node(val, null);
		curr.next = newNode;
		tail = newNode;
		size++;
	}

	public T popBack() {
		Node curr = head;
		while (curr.next != tail) {
			curr = curr.next;
		}
		T ans = tail.val;
		curr.next = null;
		tail = curr;
		size--;
		return ans;
	}

	public void insert(int index, T val) {
		Node curr = head;
		Node newNode = new Node(val, null);
		int i = 0;
		while (i < index) {
			curr = curr.next;
			i++;
		}
		Node temp = curr.next;
		curr.next = newNode;
		newNode.next = temp;
		size++;
	}

	public void erase(int index) {

		Node curr = head;
		int i = 0;
		while (i < index) {
			curr = curr.next;
			i++;
		}
		Node temp = curr.next;
		curr.next = curr.next.next;
		temp.next = null;
		size--;
	}

	public T elementAt(int index) {
		Node curr = head;
		int i = 0;
		while (i < index) {
			curr = curr.next;
		}
		return curr.next.val;
	}

	public int size() {
		return size;
	}

	public boolean hasCycle() {

		int listSize = this.size();

		ArrayList<T> list1 = new ArrayList<T>();
		ArrayList<T> list2 = new ArrayList<T>();

		Node curr = head;
		int i = 0;
		while (i < listSize * 2 && curr != null) {
			if (i < listSize) {
				list1.add(curr.val);
			} else {
				list2.add(curr.val);
			}
			curr = curr.next;
		}

		if (list1.size() == list2.size()) {
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j) != list2.get(j)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;

	}

	class Node {
		T val;
		Node next;

		public Node(T value, Node link) {
			val = value;
			next = link;
		}
	}

}
