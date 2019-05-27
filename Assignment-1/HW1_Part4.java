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
		//list.tail.next = list.head;
		
		list.print();
		System.out.println(list.isPalindrome());
		//list.print();
		
		//list.print();
	}
}

class LinkedList<T extends Comparable<T>> {

	 Node head;
	 Node tail;
	private int size;

	public LinkedList() {
		head = new Node(null, tail);
		tail = head;
		size = 0;
	}

	public void print() {
		if(hasCycle()) {
			System.out.println("Cyclic list");
		}
		if (size == 0) {
			System.out.println("Empty");
			return;
		}
		int i = 0;
		Node curr = head;
		while (curr != null && i <= size) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
			i++;
		}
		System.out.println();
	}

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

	public T popBack() {
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

	public void insert(int index, T ele) {
		if (index > size) {
			System.out.println("Error: Invalid index");
			return;
		}
		else if (index == 0) {
			Node newNode = new Node(ele, head);
			head = newNode;
			size++;
		} 
		else if(index == size) {
			pushBack(ele);
		}
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
	
	public void erase(int index) {
		if (index >= size) {
			System.out.println("Error: Invalid index");
			return;
		}
		else if (index == 0) {
			head = head.next;
		} 
		else if(index == (size-1)) {
			popBack();
		}
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
	
	public T elementAt(int index) {
		if (index >= size) {
			System.out.println("Error: Invalid index");
			return null;
		}
		else if (index == 0) {
			return head.val;
		} 
		else if(index == (size-1)) {
			return tail.val;
		}
		else {
			Node curr = head;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			return curr.next.val;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean hasCycle() {
		
		HashSet<Node> set = new HashSet<Node>();
		
		Node curr = head;
		while(curr != null) {
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
	
	public boolean isPalindrome() {
		
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

	class Node {
		T val;
		Node next;

		public Node(T value, Node link) {
			val = value;
			next = link;
		}
	}
}
