package homework2.Trees;

import homework2.Trees.Assets.TreeNode;

public class Tree<T extends Comparable<T>> {

	public static void main(String[] args) {
		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print();
		tree.print(2);
		tree.print(3);
	}
	
	/*
	 * 	Class methods and variables
	 */

	// Variables
	protected TreeNode<T> root;

	// Constructor
	public Tree(TreeNode<T> root) {
		this.root = root;
	}
	
	// Constructor
	public Tree() {
		this.root = null;
	}
	
	// Default print
	public void print() {
		print(this.root, 1);
		System.out.println();
	}
	
	// Print method with traversal selector
	public void print(int num) {
		print(this.root, num);
		System.out.println();
	}

	private void print(TreeNode<T> root, int t) {
		TreeNode<T> curr = root;
		if (curr == null) {
			return;
		}
		switch (t) {
		// Inorder Traversal
		case 1:
			print(root.left, t);
			System.out.print(root.data.toString() + " ");
			print(root.right, t);
			break;
		// Preorder Traversal
		case 2:
			System.out.print(root.data.toString() + " ");
			print(root.left, t);
			print(root.right, t);
			break;
		// Postorder Traversal
		case 3:
			print(root.left, t);
			print(root.right, t);
			System.out.print(root.data.toString() + " ");
			break;
		}
	}

}
