package homework1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import homework1.HW1_Part2;
import homework1.HW1_Part3;

import org.junit.Test;

public class HW1_Tests {

	@Test
	public void testStringPermutation1() {
		// tests for a basic anagram
		String s1 = "listen";
		String s2 = "silent";
		assertTrue(HW1_Part2.isStringPermutation(s1, s2));
		
		// tests with numbers
		s1 = "nilay1808";
		s2 = "18nilay08";
		assertTrue(HW1_Part2.isStringPermutation(s1, s2));
		
		// tests between alphabets and numbers
		s1 = "2019";
		s2 = "two";
		assertFalse(HW1_Part2.isStringPermutation(s1, s2));
		
		// tests compared to null string
		s1 = "";
		s2 = "ironman";
		assertFalse(HW1_Part2.isStringPermutation(s1, s2));
		
		// tests for case sensitive words
		s1 = "batman";
		s2 = "BATMAN";
		assertFalse(HW1_Part2.isStringPermutation(s1, s2));
	}
	
	@Test
	public void testPairsThatEqualSums() {
		/* 
		 * 		Tests for a general set of numbers
		 */
		int[] arr1 = {1, 2, 3, 4, 5};
		int target1 = 6;
		
		ArrayList<int[]> result = HW1_Part2.pairsThatEqualSum(arr1, target1);
		System.out.println("Test 1-");
		// checks if the resulting pairs actually add up to the target
		for(int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + target1);
			assertEquals(a[0] + a[1], target1);
		}
		System.out.println("");
		
		
		/*
		 * 		Tests with negative numbers
		 */
		int[] arr2 = {10, -10, 100, -200, 50, 60};
		int target2 = -210;
	
		result = HW1_Part2.pairsThatEqualSum(arr2, target2);
		System.out.println("Test 2-");
		// checks if the resulting pairs actually add up to the target
		for(int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + target2);
			assertEquals(a[0] + a[1], target2);
		}
		System.out.println("");
		
		
		/*
		 * 		Test with multiple iterations of numbers
		 */
		int[] arr3 = {2, 2, 3, 6, 5, 6, 7, -3, 9, -5};
		int target3 = 4;
		result = HW1_Part2.pairsThatEqualSum(arr3, target3);
		System.out.println("Test 3-");
		// checks if the resulting pairs actually add up to the target
		for(int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + target3);
			assertEquals(a[0] + a[1], target3);
		}
		System.out.println("");
		
		
		/*
		 * 		Test with multiple iterations of numbers
		 */
		int[] arr4 = {5};
		int target4 = 10;
		result = HW1_Part2.pairsThatEqualSum(arr4, target4);
		System.out.println("Test 4-");
		// checks if the resulting pairs actually add up to the target
		if(result.size()==0) {
			System.out.println("No pairs found!");
		}
		for(int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + target4);
			assertEquals(a[0] + a[1], target4);
		}
		System.out.println("");
		
		
		/*
		 * 		Test with multiple iterations of numbers
		 */
		int[] arr5 = {5, 5};
		int target5 = 10;
		result = HW1_Part2.pairsThatEqualSum(arr5, target5);
		System.out.println("Test 5-");
		// checks if the resulting pairs actually add up to the target
		if(result.size()==0) {
			System.out.println("No pairs found!");
		}
		for(int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + target5);
			assertEquals(a[0] + a[1], target5);
		}
		System.out.println("");
		
	}

	
	/*
	 * Basic push, pop, top, isEmpty tests.
	 */
	@Test
	public void testStack1() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(10);
		stack.push(20);
		
		assertEquals(stack.top(), Integer.valueOf(20));
		assertEquals(stack.pop(), Integer.valueOf(20));
		assertFalse(stack.isEmpty());
		assertEquals(stack.pop(1), Integer.valueOf(1));
		assertEquals(stack.top(), Integer.valueOf(10));
		assertFalse(stack.isEmpty());
		
	}
	
	
	/*
	 * 		Testing initializing the stack with specific values.
	 * 		Testing pushing more elements to a stack than the specific value during initializing.
	 * 		Testing pop and top from an empty stack.
	 * 		Testing pop(T ele) for an element that does not exist.
	 */
	@Test
	public void testStack2() {
		Stack<Integer> stack = new Stack<Integer>(3);
		int count = 0;
		for(int i = 1; i <= 10; i++) {
			stack.push(i);
			if(stack.isFull()) {
				count++;
			}
		}
		// When pushing the first 10 natural numbers on the stack, the size of the stack goes from 3 -> 6 -> 12. 
		// Hence it has to change its array twice.
		assertEquals(count, 2);
		assertEquals(stack.pop(100), null);
		for(int i = 0; i < 10; i++) {
			stack.pop();
		}
		assertEquals(stack.pop(), null);
		assertEquals(stack.top(), null);
	}
	
	
	
	public void testQueue1() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		assertEquals(queue.dequeue(), Integer.valueOf(30));
		assertFalse(queue.isEmpty());
		assertEquals(queue.dequeue(), Integer.valueOf(20));
		assertEquals(queue.dequeue(), Integer.valueOf(10));
		assertTrue(queue.isEmpty());
	}


}
