package homework1;

import java.util.*;


public class HW1_Part4 {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();

		list.pushBack(5);
		list.pushBack(10);
		list.pushBack(15);
		list.pushBack(10);
		list.pushBack(5);
		list.insert(2, 100);
		
		list.print();
		System.out.println(list.isPalindrome());
		//list.print();
		
		//list.print();
	}
}

/*
 * 		The LinkedList has been implemented using the Node class.
 * 		It keeps track of the head node, tail node and size of the list.
 * 		Note- The list is indexed from 0.
 * 
 * 		The list had the following methods-
 * 		print() - Prints the list
 * 		pushBack(T ele) - Inserts an element to the back of the list
 * 		popBack() - Removes the last element from the list
 * 		insert(int index, T ele) - Inserts the element at the given index. 
 * 		erase(int index) - Removes the element from the given index
 * 		elementAt(int index) - Returns the element at given index.
 * 		size() - Returns the size of the list
 * 		hasCycle() - Checks if the list is cyclic or not
 * 		isPalindrome() - Checks if the list is a palindrome or not
 */
class LinkedList<T extends Comparable<T>> {
	// Class Variables
	private Node head;
	private Node tail;
	private int size;

	// Constructor
	public LinkedList() {
		head = new Node(null, tail);
		tail = head;
		size = 0;
	}

	// A function to print the list
	public void print() {
		// Error Handler
		if (size <= 0) {
			System.out.println("Error: The list is empty!");
			return;
		}
		
		// Cyclic List Handler
		if(hasCycle()) {
			System.out.println("Note: The list is a cyclic list");
			int i = 0;
			Node curr = head;
			while (curr != null && i <= size) {
				System.out.print(curr.val + " -> ");
				curr = curr.next;
				i++;
			}
			System.out.println("...");
		}
		
		// Normal List Handler
		else {
			Node curr = head;
			String s = "";
			while (curr != null) {
				s += curr.val + " -> ";
				curr = curr.next;
			}
			System.out.println(s.substring(0, s.length()-3));
		}
	}
	
	// Adds an element to the back of the list
	public void pushBack(T ele) {
		Node newNode = new Node(ele, null);
		if (size == 0) {
			head = newNode;
			tail = head;
		} else if (size == 1) {
			head.next = newNode;
			tail = head.next;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	// Removes the last element from the list
	public T popBack() {
		// Error Handler
		if (size <= 0) {
			System.out.println("Error: The list is empty!");
			return null;
		}
		
		T ans;
		if (size == 1) {
			ans = head.val;
			head = null;
		} else {
			Node curr = head;
			while (curr.next != tail) {
				curr = curr.next;
			}
			ans = tail.val;
			curr.next = null;
			tail = curr;
		}
		size--;
		return ans;
	}

	// Inserts the given element at the given index
	// Note: The list is indexed from 0
	public void insert(int index, T ele) {
		// Error Handler
		if (index > size) {
			System.out.println("Error: Invalid index");
			return;
		}
		// Insert at front
		else if (index == 0) {
			Node newNode = new Node(ele, head);
			head = newNode;
			size++;
		} 
		// Insert at rear
		else if(index == size) {
			pushBack(ele);
		}
		// Insert in the middle
		else {
			Node curr = head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			Node newNode = new Node(ele, curr.next);
			curr.next = newNode;
			size++;
		}
		return;
	}
	
	// Removes the element at a given index from the list without returning it
	// Note: The list is indexed from 0
	public void erase(int index) {
		// Error Handler
		if (index >= size) {
			System.out.println("Error: Invalid index");
			return;
		}
		// Remove from front
		else if (index == 0) {
			head = head.next;
		} 
		// Remove from back
		else if(index == (size-1)) {
			popBack();
		}
		// Remove from middle
		else {
			Node curr = head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
		}
		size--;
		return;
	}
	
	// Returns the element at a given index from the list without removing it
	// Note: The list is indexed from 0
	public T elementAt(int index) {
		// Error Handler
		if (index >= size) {
			System.out.println("Error: Invalid index");
			return null;
		}
		// Element in the front
		else if (index == 0) {
			return head.val;
		} 
		// Element in the rear
		else if(index == (size-1)) {
			return tail.val;
		}
		// Element in the middle
		else {
			Node curr = head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			return curr.next.val;
		}
	}
	
	// Returns the size of the list
	public int size() {
		return size;
	}
	
	// Checks if the list is cyclic or not
	public boolean hasCycle() {
		// Use a set to store all unique nodes
		HashSet<Node> set = new HashSet<Node>();
		Node curr = head;
		while(curr != null) {
			// If the set contains a node we've already seen, then the list is cyclic
			if(set.contains(curr)) {
				return true;
			}
			else {
				set.add(curr);
			}
			curr = curr.next;
		}
		return false;
	}
	
	// Checks if the list is a palindrome or not
	public boolean isPalindrome() {
		// Empty list handler
		if (size <= 0) {
			return false;
		}
		
		/*
		 * 		Using a stack and queue to store all the elements of the list.
		 * 		If the order of elements is the same in the stack and queue, then it is a palindrome
		 */
		Stack<T> stack = new Stack<T>();
		Queue<T> queue = new Queue<T>();
		Node curr = head;
		while(curr != null) {
			stack.push(curr.val);
			queue.enqueue(curr.val);
			curr = curr.next;
		}
		while(!stack.isEmpty() && !queue.isEmpty()) {
			if(stack.pop() != queue.dequeue()) {
				return false;
			}
		}
		if(stack.isEmpty() && queue.isEmpty()) {
			return true;
		}
		return false;
	}
	
	// Makes the list cyclic by linking the head and tail
	public boolean makeCyclic() {
		if(this.size() > 1) {
			tail.next = head;
			return true;
		}
		return false;
	}

	// Helper Node class for the LinkedList
	private class Node {
		T val;
		Node next;
		
		// Constructor
		public Node(T value, Node link) {
			val = value;
			next = link;
		}
	}
}
