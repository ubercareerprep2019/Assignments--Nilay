package homework1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import homework1.Homework1;


import org.junit.Test;

public class Homework1Test {

	@Test
	public void testStringPermutation1() {
		// tests for a basic anagram
		String s1 = "listen";
		String s2 = "silent";
		assertTrue(Homework1.isStringPermutation(s1, s2));
		
		// tests with numbers
		s1 = "nilay1808";
		s2 = "18nilay08";
		assertTrue(Homework1.isStringPermutation(s1, s2));
		
		// tests between alphabets and numbers
		s1 = "2019";
		s2 = "two";
		assertFalse(Homework1.isStringPermutation(s1, s2));
		
		// tests compared to null string
		s1 = "";
		s2 = "ironman";
		assertFalse(Homework1.isStringPermutation(s1, s2));
		
		// tests for case sensitive words
		s1 = "batman";
		s2 = "BATMAN";
		assertFalse(Homework1.isStringPermutation(s1, s2));
	}
	
	@Test
	public void testPairsThatEqualSums() {
		/* 
		 * 		Tests for a general set of numbers
		 */
		int[] arr1 = {1, 2, 3, 4, 5};
		int target1 = 6;
		
		ArrayList<int[]> result = Homework1.pairsThatEqualSum(arr1, target1);
		
		// checks if the resulting pairs actually add up to the target
		for(int[] a : result) {
			assertEquals(a[0] + a[1], target1);
		}
		
		
		
		/*
		 * 		Tests with negative numbers
		 */
		int[] arr2 = {10, -10, 100, -200, 50, 60};
		int target2 = -210;
	
		result = Homework1.pairsThatEqualSum(arr2, target2);
		
		// checks if the resulting pairs actually add up to the target
		for(int[] a : result) {
			assertEquals(a[0] + a[1], target2);
		}
		
		
		
		/*
		 * 		A crazy randomized way to check the function.
		 */	
		int n = 100;
		int[] a = IntStream.range(0, n).toArray();
		
		for(int i = 0; i < n; i++) {
			Random rand = new Random();
			int num1 = rand.nextInt(50);
			int num2 = rand.nextInt(50);
			
			int target = a[num1] + a[num2];
			
			result = Homework1.pairsThatEqualSum(a, target);
			
			// checks if the resulting pairs actually add up to the target
			for(int[] array : result) {
				assertEquals(array[0] + array[1], target);
			}
		}
		
		
	}



}
