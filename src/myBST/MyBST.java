package myBST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

import examples.IntTreeNode;

public class MyBST {
	private BSTNode root;
	private int counter;
	private ArrayList<BSTNode> list = new ArrayList<BSTNode>();

	/************************** INSERT PAIR **************************/

	public void insert(int i) {
		root = helperInsert(root, i);
	}

	public BSTNode helperInsert(BSTNode node, int value) {
		if (node == null)
			node = new BSTNode(value);
		else if (node.data > value)
			node.left = helperInsert(node.left, value);
		else if (node.data < value)
			node.right = helperInsert(node.right, value);
		return node;
	}

	/************************** SIZE PAIR **************************/

	public int size() {
		counter = 0;
		return helperSize(root);
	}

	public int helperSize(BSTNode node) {
		if (node != null) {
			helperSize(node.left);
			counter++;
			helperSize(node.right);
		}
		return counter;
	}

	/************************** CONTAINS PAIR **************************/

	public boolean contains(int i) {
		return helperContains(root, i);
	}

	public boolean helperContains(BSTNode node, int value) {
		if (node == null) {
			return false;
		} else if (node.data == value) {
			return true;
		}
		return helperContains(node.left, value) || helperContains(node.right, value);
	}

	/************************** MIN PAIR **************************/

	public int getMin() {
		if (root == null)
			throw new NoSuchElementException();
		else
			return helperMin(root);
	}

	private int helperMin(BSTNode node) {
		if (node.left == null)
			return node.data;
		else
			return helperMin(node.left);
	}

	/************************** MAX PAIR **************************/

	public int getMax() {
		if (root == null)
			throw new NoSuchElementException();
		else
			return helperMax(root);
	}

	private int helperMax(BSTNode node) {
		if (node.right == null)
			return node.data;
		else
			return helperMax(node.right);
	}

	/************************** PRINT PAIR **************************/

	public void print() {
		helperPrint(root, 1);
	}

	public void helperPrint(BSTNode node, int level) {
		if (node != null) {
			helperPrint(node.right, level + 1);
			for (int i = 0; i < level * 4; i++) {
				System.out.print(" ");
			}
			System.out.print(node.data + "\n");
			helperPrint(node.left, level + 1);
		}
	}

	/************************** IN ORDER PAIR **************************/

	public void inOrder() {
		helperInOrder(root, 1);
		Collections.reverse(list);
		System.out.println(list.toString());
	}

	public void helperInOrder(BSTNode node, int level) {
		if (node != null) {
			helperInOrder(node.right, level + 1);
			list.add(node);
			helperInOrder(node.left, level + 1);
		}
	}

	/************************** DELETE PAIR **************************/

	public void delete(int i) {
		if (!contains(i))
			return;
		deleteNode(root, i);
	}

	public BSTNode deleteNode(BSTNode node, int value) {
		if (node == null)
			return root;
		BSTNode position = search(node, value);
		if (position.left == node)
			position.left = del(node);
		else
			position.right = del(node);
		return root;
	}

	private BSTNode search(BSTNode node, int key) {
		if (node == null) {
			return null;
		} else if (root.data == key) {
			return node;
		} else {
			if (root.data > key)
				return search(node.left, key);
			else
				return search(node.right, key);
		}
	}

	private BSTNode del(BSTNode node) {
		if (node.left == null && node.right == null) {
			return null;
		}
		if (node.left == null) {
			return node.right;
		}
		if (node.right == null) {
			return node.left;
		}
		BSTNode pre = node;
		BSTNode curr = node.right;
		while (curr.left != null) {
			pre = curr;
			curr = curr.left;
		}
		node.data = curr.data;
		if (pre.left == curr) {
			pre.left = curr.right;
		} else {
			pre.right = curr.right;
		}
		return node;
	}

	private class BSTNode {
		Integer data;
		BSTNode left, right;

		public BSTNode(Integer val) {
			this.data = val;
			left = right = null;
		}

		@Override
		public String toString() {
			return "" + this.data;
		}
	}

}
