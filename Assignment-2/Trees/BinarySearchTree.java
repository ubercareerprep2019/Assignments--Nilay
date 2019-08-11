package homework2.Trees;

import homework2.Trees.Assets.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

	public static void main(String[] args) {
		BinarySearchTree<Integer> t1 = new BinarySearchTree<Integer>();

		t1.insert(5);
		t1.insert(1);
		t1.insert(6);
		t1.insert(3);
		t1.insert(9);

		t1.print();
		System.out.println(t1.find(9));
	}

	// Variables
	private int size;

	// Constructor
	public BinarySearchTree() {
		super();
		size = 0;
	}

	/**
	 * Inserts a key into this binary search tree. If there are n nodes in the tree,
	 * then the average runtime of this method should be log(n).
	 * 
	 * @param key
	 *            The key to insert.
	 */
	public void insert(T key) {
		root = insertHelper(root, key);
		size++;
	}

	// Helper Method
	private TreeNode<T> insertHelper(TreeNode<T> root, T key) {
		if (root == null) {
			root = new TreeNode<T>(key);
			return root;
		} else if (key.compareTo(root.data) < 0) {
			root.left = insertHelper(root.left, key);
		} else if (key.compareTo(root.data) > 0) {
			root.right = insertHelper(root.right, key);
		}
		return root;
	}

	/**
	 * Checks whether or not a key exists in this binary search tree. If there are n
	 * nodes in the tree, then the average runtime of this method should be log(n).
	 * 
	 * @param key
	 *            The key to check for.
	 * @return true if the key is present in this binary search tree, false
	 *         otherwise.
	 */
	public boolean find(T key) {
		return findHelper(this.root, key);
	}

	// Helper Method
	public boolean findHelper(TreeNode<T> r, T k) {
		TreeNode<T> curr = r;
		if (curr == null) {
			return false;
		} else if (curr.data.compareTo(k) == 0) {
			return true;
		} else if (curr.data.compareTo(k) > 0) {
			return findHelper(curr.left, k);
		} else {
			return findHelper(curr.right, k);
		}
	}

	/*
	 * Additional methods-
	 */

	/*
	 * It searches the tree with the key passed in and returns an
	 * object with a matching key. If there is no object with the same key, it
	 * return null. Used for the phonebook part.
	 * NOTE: Only makes sense when the Tree consists of objects like Pair which have
	 * a key and value.
	 */
	public T search(T key) {
		return searchHelper(this.root, key);
	}

	// Helper Method
	private T searchHelper(TreeNode<T> r, T k) {
		TreeNode<T> curr = r;
		if (curr == null) {
			return null;
		} else if (curr.data.compareTo(k) == 0) {
			return curr.data;
		} else if (curr.data.compareTo(k) > 0) {
			return searchHelper(curr.left, k);
		} else {
			return searchHelper(curr.right, k);
		}
	}

	// Returns the size of the tree
	public int size() {
		return size;
	}
}