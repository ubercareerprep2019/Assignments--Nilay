package homework2.Trees;

public class Tree {

	public static void main(String[] args) {
		TreeNode leftChild = new TreeNode(6, null, null);
		TreeNode rightChild = new TreeNode(3, null, null);
		TreeNode left = new TreeNode(7, null, null);
		TreeNode right = new TreeNode(17, leftChild, rightChild);
		TreeNode root = new TreeNode(1, left, right);
		Tree tree = new Tree(root);

		tree.print();
		tree.print(2);
		tree.print(3);
		
	}
	
	/*
	 * 	Class methods and variables
	 */

	// Variables
	protected TreeNode root;

	// Constructor
	public Tree(TreeNode root) {
		this.root = root;
	}
	
	// Constructor
	public Tree() {
		this.root = null;
	}
	
	public void print() {
		print(this.root, 1);
		System.out.println();
	}
	
	public void print(int num) {
		print(this.root, num);
		System.out.println();
	}

	private void print(TreeNode root, int t) {
		TreeNode curr = root;
		if (curr == null) {
			return;
		}
		switch (t) {
		// Inorder Traversal
		case 1:
			print(root.left, t);
			System.out.print(root.data + " ");
			print(root.right, t);
			break;
		// Preorder Traversal
		case 2:
			System.out.print(root.data + " ");
			print(root.left, t);
			print(root.right, t);
			break;
		// Postorder Traversal
		case 3:
			print(root.left, t);
			print(root.right, t);
			System.out.print(root.data + " ");
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
	
	// Constructor
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

/*
 *
 * class Node<T extends BookEntry> {
	public T value;
	public Node<T> left, right;

	public Node(T val) {
		value = val;
		left = null;
		right = null;
	}
}
 */
