package homework2.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import homework2.Trees.Tree;
import homework2.Trees.Assets.TreeNode;

public class Tree_Tests {
	
	// Creates a tree from pg 5 on the assignment
	public static TreeNode<Integer> generateTree() {
		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		return root;
	}
	
	// Tests inorder traversal
	@Test
	public void treePrint1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> root = generateTree();
		Tree<Integer> tree = new Tree<Integer>(root);
		tree.print();

		String ans = "7 1 6 17 3";
		assertEquals(outContent.toString().trim(), ans);
	}

	// Tests preorder traversal
	@Test
	public void treePrint2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> root = generateTree();
		Tree<Integer> tree = new Tree<Integer>(root);
		tree.print(2);

		String ans = "1 7 17 6 3";
		assertEquals(outContent.toString().trim(), ans);
	}

	// Tests postorder traversal
	@Test
	public void treePrint3() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> root = generateTree();
		Tree<Integer> tree = new Tree<Integer>(root);
		tree.print(3);

		String ans = "7 6 3 17 1";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	// Test empty tree
	@Test
	public void treePrint4() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		TreeNode<Integer> root = null;
		Tree<Integer> tree = new Tree<Integer>(root);
		tree.print();

		String ans = "";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	// Test tree with missing children in the middle
	@Test
	public void treePrint5() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		TreeNode<Integer> n1 = new TreeNode<Integer>(1, null, null);
		TreeNode<Integer> n2 = new TreeNode<Integer>(2, n1, null);
		TreeNode<Integer> n3 = new TreeNode<Integer>(3, n2, null);
		TreeNode<Integer> n4 = new TreeNode<Integer>(4, n3, null);

		TreeNode<Integer> n9 = new TreeNode<Integer>(9, null, null);
		TreeNode<Integer> n8 = new TreeNode<Integer>(8, null, n9);
		TreeNode<Integer> n7 = new TreeNode<Integer>(7, null, n8);
		TreeNode<Integer> n6 = new TreeNode<Integer>(6, null, n7);
		
		TreeNode<Integer> n5 = new TreeNode<Integer>(5, n4, n6);
		
		Tree<Integer> tree = new Tree<Integer>(n5);
		tree.print();

		String ans = "1 2 3 4 5 6 7 8 9";
		assertEquals(outContent.toString().trim(), ans);
	}
}
