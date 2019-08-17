package homework2.Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import homework2.Trees.BinarySearchTree;

public class BST_Tests {

	public BinarySearchTree<Integer> generateTree() {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();
		t1.insert(5);
		t1.insert(1);
		t1.insert(6);
		t1.insert(3);
		t1.insert(9);
		return t1;
	}

	// Tests find for elements that exist in the tree
	@Test
	public void testBST1() {
		BinarySearchTree<Integer> tree = generateTree();
		assertTrue(tree.find(3));
		assertTrue(tree.find(5));
		assertTrue(tree.find(1));
	}

	// Tests find for elements that don't exist in the tree
	@Test
	public void testBST2() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertFalse(tree.find(10));
		assertFalse(tree.find(-1));
		assertFalse(tree.find(18));
	}

	// Tests insert by trying to find the inserted elements
	@Test
	public void testBST3() {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();
		int[] arr = { 50, 10, 60, 70, 90 };
		// Inserts all numbers from the array
		for (int i : arr) {
			t1.insert(i);
		}
		// Uses find to check if all the numbers from the array exist in the BST
		for (int i : arr) {
			assertTrue(t1.find(i));
		}

		// Checks if other numbers that are not inserted exist or not
		assertFalse(t1.find(100));
		assertFalse(t1.find(-10));
		assertFalse(t1.find(108));
	}

	// Tests the speed of the BST and makes sure its faster than a list
	@Test
	public void testBST4() {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		// Limit for numbers
		int c = 10000;
		int left = c / 2, right = left;

		// Populate the tree and list
		while (left > 0 && right < c) {
			if (left == right) {
				list.add(left);
				t1.insert(left);
			} else {
				list.add(left);
				list.add(right);
				t1.insert(left);
				t1.insert(right);
			}
			left--;
			right++;
		}

		// Calculate the search time for tree
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < c; i++) {
			assertTrue(t1.find(i));
		}
		long endTime = System.currentTimeMillis();
		long treeTime = endTime - startTime;

		// Calculate the search time for list
		startTime = System.currentTimeMillis();
		for (int i = 1; i < c; i++) {
			// Check if list contains i
			boolean contains = false;
			for (int n : list) {
				if (n == i) {
					contains = true;
				}
			}
			assertTrue(contains);
		}
		endTime = System.currentTimeMillis();
		long listTime = endTime - startTime;

		// Compare the times. Tree should be faster
		assertTrue(treeTime <= listTime);
	}

}
