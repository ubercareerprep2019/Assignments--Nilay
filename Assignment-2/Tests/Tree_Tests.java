package homework2.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import homework2.Trees.Tree;
import homework2.Trees.Assets.TreeNode;

public class Tree_Tests {

	@Test
	public void treePrint1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print();

		String ans = "7 1 6 17 3";
		assertEquals(outContent.toString().trim(), ans);
	}

	@Test
	public void treePrint2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print(2);

		String ans = "1 7 17 6 3";
		assertEquals(outContent.toString().trim(), ans);
	}

	@Test
	public void treePrint3() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print(3);

		String ans = "7 6 3 17 1";
		assertEquals(outContent.toString().trim(), ans);
	}


}
