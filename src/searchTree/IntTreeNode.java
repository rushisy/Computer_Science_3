package searchTree;

//An IntTreeNode object is one node in a binary tree of ints.
public class IntTreeNode {

	int data; // data stored at this node
	IntTreeNode left; // reference to the left subtree
	IntTreeNode right; // reference to the right subtree

	public IntTreeNode(int data) {
		this.data = data;
	}

	public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
