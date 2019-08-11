package homework2.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework2.Trees.BinarySearchTree;

public class BST_Tests {

	@Test
	public void testBST1() {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();
		t1.insert(5);
		t1.insert(1);
		t1.insert(6);
		t1.insert(3);
		t1.insert(9);

		assertTrue(t1.find(3));
		assertTrue(t1.find(5));
		assertTrue(t1.find(1));
		assertFalse(t1.find(10));
		assertFalse(t1.find(-1));
		assertFalse(t1.find(18));
	}

	@Test
	public void testBST2() {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();
		t1.insert(50);
		t1.insert(10);
		t1.insert(60);
		t1.insert(60);
		t1.insert(90);

		assertTrue(t1.find(60));
		assertTrue(t1.find(50));
		assertTrue(t1.find(10));
		assertFalse(t1.find(100));
		assertFalse(t1.find(-10));
		assertFalse(t1.find(108));
	}

}
