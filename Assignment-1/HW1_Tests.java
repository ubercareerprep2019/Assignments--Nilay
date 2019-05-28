package homework1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import homework1.HW1_Part2;

import org.junit.Test;

public class HW1_Tests {

	@Test
	public void testStringPermutation1() {
		// tests for a basic anagram
		String s1 = "listen";
		String s2 = "silent";
		assertTrue(HW1_Part2.isStringPermutation(s1, s2));
	}

	@Test
	public void testStringPermutation2() {
		// tests with numbers
		String s1 = "nilay1808";
		String s2 = "18nilay08";
		assertTrue(HW1_Part2.isStringPermutation(s1, s2));
	}

	@Test
	public void testStringPermutation3() {
		// tests between alphabets and numbers
		String s1 = "2019";
		String s2 = "two";
		assertFalse(HW1_Part2.isStringPermutation(s1, s2));
	}

	@Test
	public void testStringPermutation4() {
		// tests compared to null string
		String s1 = "";
		String s2 = "ironman";
		assertFalse(HW1_Part2.isStringPermutation(s1, s2));
	}

	@Test
	public void testStringPermutation5() {
		// tests for case sensitive words
		String s1 = "batman";
		String s2 = "BATMAN";
		assertFalse(HW1_Part2.isStringPermutation(s1, s2));
	}

	@Test
	public void testPairsThatEqualSums1() {
		/*
		 * Tests for a general set of numbers
		 */
		int[] arr = { 1, 2, 3, 4, 5 };
		int tgt = 6;

		ArrayList<int[]> result = HW1_Part2.pairsThatEqualSum(arr, tgt);
		System.out.println("Test 1-");
		// checks if the resulting pairs actually add up to the target
		for (int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + tgt);
			assertEquals(a[0] + a[1], tgt);
		}
		System.out.println("");
	}

	@Test
	public void testPairsThatEqualSums2() {

		/*
		 * Tests with negative numbers
		 */
		int[] arr = { 10, -10, 100, -200, 50, 60 };
		int tgt = -210;

		ArrayList<int[]> result = HW1_Part2.pairsThatEqualSum(arr, tgt);
		System.out.println("Test 2-");
		// checks if the resulting pairs actually add up to the target
		for (int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + tgt);
			assertEquals(a[0] + a[1], tgt);
		}
		System.out.println("");
	}

	@Test
	public void testPairsThatEqualSums3() {

		/*
		 * Test with multiple iterations of numbers
		 */
		int[] arr = { 2, 2, 3, 6, 5, 6, 7, -3, 9, -5 };
		int tgt = 4;
		ArrayList<int[]> result = HW1_Part2.pairsThatEqualSum(arr, tgt);
		System.out.println("Test 3-");
		// checks if the resulting pairs actually add up to the target
		for (int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + tgt);
			assertEquals(a[0] + a[1], tgt);
		}
		System.out.println("");

	}

	@Test
	public void testPairsThatEqualSums4() {
		/*
		 * Test with multiple iterations of numbers
		 */
		int[] arr = { 5 };
		int tgt = 10;
		ArrayList<int[]> result = HW1_Part2.pairsThatEqualSum(arr, tgt);
		System.out.println("Test 4-");
		// checks if the resulting pairs actually add up to the target
		if (result.size() == 0) {
			System.out.println("No pairs found!");
		}
		for (int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + tgt);
			assertEquals(a[0] + a[1], tgt);
		}
		System.out.println("");

	}

	@Test
	public void testPairsThatEqualSums5() {
		/*
		 * Test with multiple iterations of numbers
		 */
		int[] arr = { 5, 5 };
		int tgt = 10;
		ArrayList<int[]> result = HW1_Part2.pairsThatEqualSum(arr, tgt);
		System.out.println("Test 5-");
		// checks if the resulting pairs actually add up to the target
		if (result.size() == 0) {
			System.out.println("No pairs found!");
		}
		for (int[] a : result) {
			System.out.println(a[0] + " + " + a[1] + " = " + tgt);
			assertEquals(a[0] + a[1], tgt);
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
		stack.pop();
		assertEquals(stack.pop(), Integer.valueOf(10));
		assertFalse(stack.isEmpty());
		assertEquals(stack.pop(), Integer.valueOf(1));
		assertTrue(stack.isEmpty());
	}

	/*
	 * Testing if the stack follows ordering properties. Testing pop and top from an
	 * empty stack. Testing pop(T ele) for an element that does not exist.
	 */
	@Test
	public void testStack2() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(10);
		stack.push(20);

		assertEquals(stack.top(), Integer.valueOf(20));
		stack.pop();
		stack.push(50);
		stack.push(70);
		assertEquals(stack.pop(), Integer.valueOf(70));
		assertEquals(stack.pop(100), null);
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty());
		assertEquals(stack.top(), null);
		assertEquals(stack.pop(), null);
	}

	@Test
	public void testStack3() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30);
		stack.push(20);
		stack.push(10);

		assertEquals(stack.min(), Integer.valueOf(10));
		assertEquals(stack.top(), Integer.valueOf(10));
		stack.pop();
		assertEquals(stack.top(), Integer.valueOf(20));
		assertEquals(stack.min(), Integer.valueOf(20));

		stack.push(1);
		stack.push(50);
		stack.push(70);

		assertEquals(stack.min(), Integer.valueOf(1));
		stack.pop(1);
		assertEquals(stack.min(), Integer.valueOf(20));

	}

	@Test
	public void testQueue1() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		assertEquals(queue.dequeue(), Integer.valueOf(10));
		assertFalse(queue.isEmpty());
		assertEquals(queue.dequeue(), Integer.valueOf(20));
		assertEquals(queue.dequeue(), Integer.valueOf(30));
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testQueue2() {
		Queue<String> queue = new Queue<String>();
		queue.enqueue("abcd");
		queue.enqueue("acde");
		queue.enqueue("aabr");
		
		System.out.println(queue.min());
	}


}
