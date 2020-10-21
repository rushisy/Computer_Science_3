package searchTree;

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

	public static void main(String[] args) {

	}
}
