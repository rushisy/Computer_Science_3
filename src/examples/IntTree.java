package examples;

// An IntTree object represents an entire binary tree of ints.
public class IntTree {
	private IntTreeNode overallRoot; // null for an empty tree

	public void print() { // most methods are paired with private public pair
		print(overallRoot); // mini runner method
		System.out.println();
	}

	private void print(IntTreeNode root) {
		if (root != null) {
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}

	public void printContains() {
		contains(overallRoot, 5);
		System.out.println();
	}

	private boolean contains(IntTreeNode root, int key) {
		if (root == null) {
			return false;
		} else if (root.data == key) {
			return true;
		}
		return contains(root.left, key) || contains(root.right, key);
	}
}
