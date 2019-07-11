package homework2.Trees;

import java.util.*;
import java.util.stream.IntStream;
import org.w3c.dom.Node;

public class Trees_Ex1 {

	public static void main(String[] args) {
		TreeNode leftChild = new TreeNode(6, null, null);
		TreeNode rightChild = new TreeNode(3, null, null);
		TreeNode left = new TreeNode(7, null, null);
		TreeNode right = new TreeNode(17, leftChild, rightChild);
		TreeNode root = new TreeNode(1, left, right);
		Tree tree = new Tree(root);

		print(root, 1);
	}

	/*
	 *  Ex 1
	 */
	public static void print(TreeNode root, int t) {
		TreeNode curr = root;
		if (curr == null) {
			return;
		}
		switch (t) {
		// Inorder Traversal
		case 1:
			print(root.left, t);
			System.out.println(root.data);
			print(root.right, t);
			break;
		// Preorder Traversal
		case 2:
			System.out.println(root.data);
			print(root.left, t);
			print(root.right, t);
			break;
		// Postorder Traversal
		case 3:
			print(root.left, t);
			print(root.right, t);
			System.out.println(root.data);
			break;
		}
	}

}

/*
 * Given Starter Code
 */
class TreeNode {
	// Global Variables
	public int data;
	public TreeNode left;
	public TreeNode right;

	// Constructor
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class Tree {
	// Variables
	public TreeNode root;

	// Constructor
	public Tree(TreeNode root) {
		this.root = root;
	}
}
