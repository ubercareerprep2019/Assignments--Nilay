package homework1;

import java.util.*;
import java.util.stream.IntStream;
import org.w3c.dom.Node;

public class HW1_Part3 {

	public static void main(String[] args) {

		/*
		 * Custom test space
		 */

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		stack.push(19);
		stack.push(29);
		stack.push(39);
		System.out.println(stack.pop());
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
 * The Stack is implemented using an ArrayList.
 * The Stack has the following methods- 
 * push(T ele) - It adds an element to the stack 
 * pop() - It removes the top element from the stack 
 * pop(T ele) - It removes the specified element from the stack 
 * top() - It returns the top element on the stack without removing it 
 * isEmpty() - It returns a boolean depending on if the stack is empty or not 
 * min() - It returns the smallest element from the stack.
 * 
 */

class Stack<T extends Comparable<T>> {
	private ArrayList<T> list;
	private T min;
	private int top;

	// Constructor
	public Stack() {
		list = new ArrayList<T>();
		top = -1;
	}

	public void push(T element) {
		// If the stack is empty, then the first element has to be the smallest element
		if (this.isEmpty()) {
			min = element;
		} else {
			if (min.compareTo(element) > 0) {
				min = element;
			}
		}
		list.add(element);
		top++;
	}

	public T pop() {
		if (this.isEmpty()) {
			System.out.println("Error: Stack is empty!");
			return null;
		}
		T ans = list.remove(top);
		top--;
		
		// If popping min, find new min
		if(ans.equals(min)) {
			updateMin();	
		}
		
		return ans;
	}

	public T pop(T val) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(val)) {
				T ans = list.remove(i);
				
				// If popping min, find new min
				if(ans.equals(min)) {
					updateMin();	
				}
				
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
		return list.get(top);
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public T min() {
		if(list.isEmpty()) {
			return null;
		}
		return min;
	}
	
	// Helper method, 
	private void updateMin() {
		if(list.isEmpty()) {
			min = null;
			return;
		}
		T currMin = list.get(0);
		for(T ele : list) {
			if (currMin.compareTo(ele) > 0) {
				currMin = ele;
			}
		}
		if(!list.contains(min)) {
			min = currMin;
		}
	}

}


/*
 * The Queue is implemented using the Stack we created before.
 * The Queue has the following methods- 
 * enqueue(T ele) - It adds an element to the queue 
 * dequeue() - It removes the first element from the queue 
 * isEmpty() - It returns a boolean depending on if the queue is empty or not 
 * min() - It returns the smallest element from the queue.
 * 
 */
class Queue<T extends Comparable<T>> {
	private Stack<T> stack;

	public Queue() {
		stack = new Stack<T>();
	}

	public void enqueue(T element) {
		stack.push(element);
	}

	public T dequeue() {
		Stack<T> helper = new Stack<T>();
		while (!stack.isEmpty()) {
			helper.push(stack.pop());
		}
		T ans = helper.pop();
		while(!helper.isEmpty()) {
			stack.push(helper.pop());
		}
		return ans;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public T min() {
		return stack.min();
	}

}
