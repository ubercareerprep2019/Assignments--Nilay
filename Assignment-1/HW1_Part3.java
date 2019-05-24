package homework1;

import java.util.*;
import java.util.stream.IntStream;
import org.w3c.dom.Node;

public class HW1_Part3 {

	public static void main(String[] args) {

		/*
		 * Custom test space for the 2 functions.
		 */

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 1; i <= 10; i++) {
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
}
/*
 * Part 3: Stacks & Queues
 */

/*
 * The Stack is implemented using a generic array. It has a default size of 10
 * but you can also specify the desired size when initializing your stack. The
 * Stack has the following methods- push(T ele) - It adds an element to the
 * stack pop() - It removes the top element from the stack pop(T ele) - It
 * removes the specified element from the stack top() - It returns the top
 * element on the stack without removing it isEmpty() - It returns a boolean
 * depending on if the stack is empty or not isFull() - It returns a boolean
 * depending on if the stack is full or not
 */
// T extends Comparable<T> 
class Stack<T> {
	private int defaultSize = 10; // default size of the array when initialized
	private T[] arr;
	private T min;
	private int top;

	// Constructor for initializing
	public Stack() {
		arr = (T[]) new Object[defaultSize];
		top = -1;
	}

	// Constructor for initializing with specific size
	public Stack(int size) {
		defaultSize = size;
		arr = (T[]) new Object[defaultSize];
		top = -1;
	}

	public void push(T element) {
		// If the array is full, it creates a new one with double the size, copies all
		// elements to it and then pushes the elements which is passed in.
		if (this.isFull()) {
			T[] temp = (T[]) new Object[defaultSize * 2];
			for (int i = 0; i <= top; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
			defaultSize = defaultSize * 2;
		}

		// For first element, the min must equal that element
//		if (top == -1) {
//			min = element;
//		} else {
//			if (min.compareTo(element) > 0) {
//				min = element;
//			}
//		}

		arr[++top] = element;
	}

	public T pop() {
		if (this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		T ans = arr[top];
		arr[top] = null;
		top--;
		return ans;
	}

	public T pop(T val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				T ans = arr[i];
				for (int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];
				}
				arr[arr.length - 1] = null;
				top--;
				return ans;
			}
		}
		System.out.println("The stack does not contain " + val);
		return null;
	}

	public T top() {
		if (this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		return arr[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public T min() {
		return min;
	}

	// Helper methods
	public boolean isFull() {
		return top >= (defaultSize - 1);
	}

}

class Queue<T> {

	private Stack<T> stack;
	T min;

	public Queue() {
		stack = new Stack<T>();
	}

	public Queue(int n) {
		stack = new Stack<T>(n);
	}

	public void enqueue(T element) {		
		stack.push(element);
	}

	public T dequeue() {
		Stack<T> helper = new Stack<T>();
		while (!stack.isEmpty()) {
			helper.push(stack.pop());
		}
		stack = helper;
		return stack.pop();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public T min() {
		return stack.min();
	}

}

