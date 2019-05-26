package homework1;

import java.util.*;
import java.util.stream.IntStream;
import org.w3c.dom.Node;

public class HW1_Part3 {

	public static void main(String[] args) {

		/*
		 * Custom test space
		 */
		System.out.println("Custom tests for stack-\n");
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Should be 30- " + stack.pop());
		System.out.println("Should be 20- " + stack.pop());
		stack.push(99);
		System.out.println("Should be 99- " + stack.top());
		stack.pop(10);
		System.out.println("Should be 10- " + stack.min());
		stack.push(5);
		System.out.println("Should be 5- " + stack.min());

		
		System.out.println("\n-------------------------------------------------------------------\n");

		
		System.out.println("Custom tests for queue-\n");
		Queue<Integer> queue = new Queue<Integer>();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		System.out.println("Should be 10- " + queue.dequeue());
		System.out.println("Should be 20- " + queue.dequeue());
		queue.enqueue(50);
		queue.enqueue(30);
		System.out.println("Should be 30- " + queue.dequeue());
		System.out.println("Should be 30- " + queue.min());
		System.out.println("Should be 50- " + queue.dequeue());
		
		

	}
}
/*
 * Part 3: Stacks & Queues
 */

/*
 * The Stack is implemented using an ArrayList. 
 * It keeps track of the index of the element on the top of the stack and also keeps track of the min element on the stack.
 * The top index is updated every time an element is pushed or popped. 
 * The min is updated every time an element smaller than it is pushed and everytime it is popped.
 */

class Stack<T extends Comparable<T>> {
	// Class Variables
	private ArrayList<T> list;
	private T min;
	private int top;

	// Constructor
	public Stack() {
		list = new ArrayList<T>();
		top = -1;
	}

	// It adds an element to the stack
	public void push(T element) {
		// Updates the min value
		if (this.isEmpty()) {
			// If the stack is empty, then the first element has to be the smallest element
			min = element;
		} else {
			// Compares it to the current min and then updates if the element is smaller
			// than the min
			if (min.compareTo(element) > 0) {
				min = element;
			}
		}

		list.add(element);
		top++;
	}

	// Removes the top element from the stack
	public T pop() {
		// Error Handler
		if (this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		T ans = list.remove(top);
		top--;

		// If the element popped was the min element, it searches the stack for the new
		// min
		if (ans.equals(min)) {
			updateMin();
		}

		return ans;
	}

	// Removes the specified element from the stack
	public T pop(T val) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(val)) {
				T ans = list.remove(i);

				// If popping min, find new min
				if (ans.equals(min)) {
					updateMin();
				}

				return ans;
			}
		}

		// Error Handler
		System.out.println("The stack does not contain " + val);
		return null;
	}

	// Returns the top element on the stack without removing it from the stack
	public T top() {
		// Error Handler
		if (this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		return list.get(top);
	}

	// Checks if the stack is empty or not.
	public boolean isEmpty() {
		return top == -1;
	}

	// Returns the smallest element from the stack
	public T min() {
		// Error Handler
		if (list.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		return min;
	}

	// Helper method, updates the min from the list
	private void updateMin() {
		// For an empty list, there should be no min
		if (list.isEmpty()) {
			min = null;
			return;
		}
		// Iterates through the list to find the smallest min.
		T currMin = list.get(0);
		for (T ele : list) {
			if (currMin.compareTo(ele) > 0) {
				currMin = ele;
			}
		}
		// If all instances of the min element have been removed from the stack, it sets
		// the min as the next smallest value
		if (!list.contains(min)) {
			min = currMin;
		}
	}

}

/*
 * The Queue is implemented using the Stack we created before. 
 * 
 */
class Queue<T extends Comparable<T>> {
	// Class Variables
	private Stack<T> stack;

	public Queue() {
		stack = new Stack<T>();
	}

	// Adds the element on the queue
	public void enqueue(T element) {
		stack.push(element);
	}

	// Removes the first element from the queue
	public T dequeue() {
		// Creates a helper stack and transfers all elements from the current stack to
		// the helper stack to reverse the order
		Stack<T> helper = new Stack<T>();
		while (!stack.isEmpty()) {
			helper.push(stack.pop());
		}

		// Removes the first element
		T ans = helper.pop();

		// Pushes remaining elements back on the stack to maintain order.
		while (!helper.isEmpty()) {
			stack.push(helper.pop());
		}
		return ans;
	}

	// Checks if the queue is empty or not
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	// Returns the smallest element from the queue.
	public T min() {
		return stack.min();
	}

}
