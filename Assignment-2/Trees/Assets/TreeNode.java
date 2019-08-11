package homework2.Trees.Assets;

/*
 * Given Starter Code
 */
public class TreeNode<T extends Comparable<T>> {
	// Global Variables
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;

	// Constructor
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// Constructor
	public TreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
