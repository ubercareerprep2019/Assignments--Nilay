package homework1;

import java.util.*;
import java.util.stream.IntStream;
import org.w3c.dom.Node;

public class HW1_Part5 {

	public static void main(String[] args) {

		TowerOfHanoi game = new TowerOfHanoi(8);
		
		game.makeGame();
		
		game.print();
		
//		game.r1.push(3);
//		game.r1.push(2);
//		game.r1.push(1);
//		
//		game.r2.push(5);
//		
//		game.r3.push(4);
//		
//		game.print();
//		
//		game.moveDisk(3, 2);
//		game.print();
//		System.out.println(game.winChecker());
//
//		game.moveDisk(1, 2);
//		game.print();
//		System.out.println(game.winChecker());
//
//		game.moveDisk(1, 3);
//		game.print();
//		System.out.println(game.winChecker());
//		
//		game.moveDisk(2, 3);
//		game.print();
//		System.out.println(game.winChecker());
//		
//		game.moveDisk(1, 2);
//		game.print();
//		System.out.println(game.winChecker());
//		
//		game.moveDisk(3, 1);
//		game.print();
//		System.out.println(game.winChecker());
//
//		game.moveDisk(3, 2);
//		game.print();
//		System.out.println(game.winChecker());
//
//		game.moveDisk(1, 2);
//		game.print();
//		System.out.println(game.winChecker());


		
	}

}

class TowerOfHanoi {

	Rod r1, r2, r3;
	int numOfDisks;
	
	public TowerOfHanoi(int n) {
		r1 = new Rod();
		r2 = new Rod();
		r3 = new Rod();
		numOfDisks = n;
	}
	
	
	public void moveDisk(int startRod, int destRod) {
		
		// Error Handler 1: Check if startRod and destRod exist
		if(!isValidRod(startRod) || !isValidRod(destRod)) {
			System.out.println("Error: The rods passed in do not exist.\n");
			return;
		}
		
		if(startRod == destRod) {
			return;
		}
		
		int disk;
		
		// Get the top disk which needs to be moved
		if(startRod == 1) {
			disk = r1.pop();
		}
		else if(startRod == 2) {
			disk = r2.pop();
		}
		else{
			disk = r3.pop();
		}
		
		// Error Handler 2: Given rod is empty
		if(disk == -1) {
			System.out.println("Error: The start rod passed in is empty!\n");
			return;
		}
		
		Boolean success;
		
		// Push the disk on the destination rod
		if(destRod == 1) {
			success = r1.push(disk);
		}
		else if(destRod == 2) {
			success = r2.push(disk);
		}
		else{
			success = r3.push(disk);
		}
		
		// Error Handler 3: Check if the move was valid and that it occured, if not put the disk back in the starting rod
		if(!success) {
			if(startRod == 1) {
				r1.push(disk);
			}
			else if(startRod == 2) {
				r2.push(disk);
			}
			else{
				r3.push(disk);
			}
			System.out.println("Error: Cannot move the rod since it's an invalid move.\n");
			return;
		}
		
		return;
	}
	
	public List<Integer> disksAtRod(int rod) {
		
		switch(rod) {
		case 1:
			return r1.toList();
		case 2:
			return r2.toList();
		case 3:
			return r3.toList();
		default:
			System.out.println("Error: Given rod doesn't exist.\n");
			return null;
		}
		
	}
	
	
	public void print() {
		List<Integer> rod1 = disksAtRod(1);
		List<Integer> rod2 = disksAtRod(2);
		List<Integer> rod3 = disksAtRod(3);
		
		Stack<String> printStack = new Stack<String>();
		
		for(int i = 0; i < numOfDisks; i++) {
			
			String d1, d2, d3;
			
			if(rod1.isEmpty()) {
				d1 = " ";
			}
			else {
				d1 = rod1.remove(rod1.size()-1).toString();
			}
			
			if(rod2.isEmpty()) {
				d2 = " ";
			}
			else {
				d2 = rod2.remove(rod2.size()-1).toString();
			}
			
			if(rod3.isEmpty()) {
				d3 = " ";
			}
			else {
				d3 = rod3.remove(rod3.size()-1).toString();
			}
			
			String line = " | " + d1 + " | " + d2 + " | " + d3 + " | ";
			
			printStack.push(line);
		}
		
		while(!printStack.isEmpty()) {
			System.out.println(printStack.pop());
		}
		System.out.println();
	}
	
	
	public boolean winChecker() {
		if(r1.isEmpty() && r2.isEmpty()) {
			return r3.size() == numOfDisks;
		}
		if(r1.isEmpty() && r3.isEmpty()) {
			return r2.size() == numOfDisks;
		}
		if(r2.isEmpty() && r3.isEmpty()) {
			return r1.size() == numOfDisks;
		}
		return false;
	}
	
	
	/*
	 * 	Helper Functions
	 */
	
	private boolean isValidRod(int r) {
		return (r == 1 || r == 2 || r == 3);
	}
	
	
	public void makeGame() {
		int n = numOfDisks;
		
		for(int i = n; i > 0; i--) {
			int r = (int) (Math.random()*3) + 1;
			
			if(r == 1) {
				r1.push(i);
			}
			else if(r == 2) {
				r2.push(i);
			}
			else{
				r3.push(i);
			}
			
		}
		return;
	}

}




class Rod {
	
	private Stack<Integer> s;
	
	// Constructor
	public Rod() {
		s = new Stack<Integer>();
	}
	
	// Pushes int following the rules of Tower of Hanoi
	public boolean push(int i) {
		if(!s.isEmpty() && s.top() <= i) {
			return false;
		}
		s.push(i);
		return true;
	}
	
	// Removes the top most int from the rod
	public int pop() {
		if(s.isEmpty()) {
			return -1;
		}
		return s.pop();
	}
	
	// List is top to bottom
	public List<Integer> toList() {
		List<Integer> list = new ArrayList<Integer>();
		
		Stack<Integer> helper = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			int i = s.pop();
			list.add(i);
			helper.push(i);
		}
		
		while(!helper.isEmpty()) {
			s.push(helper.pop());
		}
		
		return list;	
	}
	
	// Checks if the number exists in the stack.
	public boolean contains(int i) {
		return s.contains(i);
	}
	
	// Checks if the rod is empty.
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	// returns number of elements in the rod
	public int size() {
		return s.size();
	}

}