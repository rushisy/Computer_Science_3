package bst;

public class BinarySearchTree {
	private static Node root;
	private static Node root2;
	private static Node root3;
	private static int counter = 0;

	public static void main(String[] args) {
		root = new Node(10);
		insert(root, 5);
		insert(root, 15);
		insert(root, 20);
		insert(root, 1);
		insert(root, 3);

		root2 = new Node(5);
		insert(root2, 1);
		insert(root2, 3);

		root3 = new Node(5);
		root3.left = new Node(3);
		root3.right = new Node(1);

//		print(root);
//		System.out.println();
//		print(root2);
//		System.out.println("\n" + predecessor(root));
//		System.out.println(successor(root));
//		delete(root, 10);
//		print(root);
//		System.out.println("\n" + search(root, 3));
//		System.out.println(minimum(root));
//		System.out.println(maximum(root));
//		secondMinimum(root);
//		counter = 0;
//		secondMaximum(root);
//		counter = 0;
//		kthMin(root, 3);
//		counter = 0;
//		kthMax(root, 4);
//		print(root);
//		System.out.println();
//		counter = 0;
//		kthMinElements(root, 3);
//		System.out.println();
//		counter = 0;
//		kthMaxElements(root, 3);
//		System.out.println(isBSTComplete(root, null, null));
//		System.out.println("\n" + isValidTrees(root, root2));
//		System.out.println(isValidSubTree(root, root2));
//		print(root);
//		mirror(root);
//		System.out.println();
//		print(root);
//		print(root2);
//		System.out.println();
//		System.out.println(isMirrorTrees(root2, root3));

	}

	public static Node insert(Node root, int value) {
		if (root == null)
			root = new Node(value);
		else if (root.data >= value)
			root.left = insert(root.left, value);
		else if (root.data < value)
			root.right = insert(root.right, value);
		return root;
	}

	/**
	 * deletion rules deletion of leaf nodes - delete it deletion of one child -
	 * replace current node and delete child deletion of two children - replace with
	 * successor/predecessor and delete respective node
	 */
	public static Node delete(Node root, int value) {
		if (root == null)
			return null;
		else if (root.data > value)
			root.left = delete(root.left, value);
		else if (root.data < value)
			root.right = delete(root.right, value);
		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.data = predecessor(root);
			root.left = delete(root.left, root.data);
		}
		return root;
	}

	public static void print(Node root) {
		if (root == null)
			return;
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);

	}

	/**
	 * predecessor is defined maximum in the left subtree successor is defined as
	 * minimum in the right subtree
	 */

	public static int predecessor(Node root) {
		Node temp = null;
		if (root.left != null)
			temp = root.left;
		while (temp.right != null)
			temp = temp.right;
		return temp.data;
	}

	public static int successor(Node root) {
		Node temp = null;
		if (root.right != null)
			temp = root.right;
		while (temp.left != null)
			temp = temp.left;
		return temp.data;
	}

	public static boolean search(Node root, int value) {
		if (root == null)
			return false;
		else if (root.data == value)
			return true;
		else if (value > root.data)
			return search(root.right, value);
		else
			return search(root.left, value);
	}

	public static int minimum(Node root) {
		if (root.left == null)
			return root.data;
		else
			return minimum(root.left);
	}

	public static int maximum(Node root) {
		if (root.right == null)
			return root.data;
		else
			return maximum(root.right);
	}

	public static void secondMinimum(Node root) {
		if (root == null || counter > 2)
			return;
		secondMinimum(root.left);
		counter++;
		if (counter == 2)
			System.out.print(root.data + " ");
		secondMinimum(root.right);
	}

	public static void secondMaximum(Node root) {
		if (root == null || counter > 2)
			return;
		secondMaximum(root.right);
		counter++;
		if (counter == 2)
			System.out.print(root.data + " ");
		secondMaximum(root.left);
	}

	public static void kthMin(Node root, int k) {
		if (root == null || counter > k)
			return;
		kthMin(root.left, k);
		counter++;
		if (counter == k)
			System.out.print(root.data + " ");
		kthMin(root.right, k);
	}

	public static void kthMax(Node root, int k) {
		if (root == null || counter > k)
			return;
		kthMax(root.right, k);
		counter++;
		if (counter == k)
			System.out.print(root.data + " ");
		kthMax(root.left, k);
	}

	public static void kthMinElements(Node root, int k) {
		if (root == null || counter > k)
			return;
		kthMinElements(root.left, k);
		counter++;
		if (counter <= k)
			System.out.print(root.data + " ");
		kthMinElements(root.right, k);
	}

	public static void kthMaxElements(Node root, int k) {
		if (root == null || counter > k)
			return;
		kthMaxElements(root.right, k);
		counter++;
		if (counter <= k)
			System.out.print(root.data + " ");
		kthMaxElements(root.left, k);
	}

	public static boolean isBST(Node root) {
		if (root == null)
			return true;
		if (root.left != null && root.data < root.left.data)
			return false;
		if (root.right != null && root.data > root.right.data)
			return false;
		return isBST(root.left) && isBST(root.right);

	}

	public static boolean isBSTComplete(Node root, Integer min, Integer max) {
		if (root == null)
			return true;
		if ((min != null && root.data < min) || (max != null && root.data > max))
			return false;
		return isBSTComplete(root.left, min, root.data) && isBSTComplete(root.right, root.data, max);
	}

	public static boolean isEqualTrees(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && isEqualTrees(root1.left, root2.left)
				&& isEqualTrees(root1.right, root2.right);
	}

	public static boolean isValidSubTree(Node root1, Node root2) {
		return root1 != null && (isValidSubTree(root1.left, root2) || isValidSubTree(root1.right, root2)
				|| isEqualTrees(root1, root2));
	}

	public static void mirror(Node root) {
		if (root == null)
			return;
		mirror(root.left);
		mirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static boolean isMirrorTrees(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && isMirrorTrees(root1.left, root2.right)
				&& isMirrorTrees(root1.right, root2.left);
	}

	public static boolean symetric(Node root) {
		return isMirrorTrees(root, root);
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}
