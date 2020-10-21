package searchTree;

import java.util.NoSuchElementException;

import examples.IntTreeNode;

public class SearchTree {
	private IntTreeNode overallRoot; // null for an empty tree

	public void printContains() {
		contains(overallRoot, 5);
		System.out.println();
	}

	private boolean contains(IntTreeNode root, int key) {
		if (root == null) {
			return false;
		} else if (root.data == key) {
			return true;
		} else {
			if (root.data > key)
				return contains(root.left, key);
			else
				return contains(root.right, key);
		}
	}

	public void printAdd() {
		add(overallRoot, new IntTreeNode(49));
	}

	private IntTreeNode add(IntTreeNode root, IntTreeNode input) {
		if (root == null || root.data == input.data)
			root = input;
		else if (root.data > input.data)
			root.left = add(root.left, input);
		else if (root.data < input.data)
			root.right = add(root.right, input);
		return root;
	}

	public int printGetMin() {
		if (overallRoot == null) {
			throw new NoSuchElementException();
		} else {
			return getMin(overallRoot);
		}
	}

	private int getMin(IntTreeNode root) {
		if (root.left == null)
			return root.data;
		else
			return getMin(root.left);
	}
	
	
	/**
	 * Removal Hacks
	 * 
	 * 1. a leaf                               : replace with null
	 * 2. a node with a left/right child only  : replace with left/right child
	 * 4. a node with both children            : replace with minimum value from right
	 */
}
