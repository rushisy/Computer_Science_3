package myBST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MyBST {
	private BSTNode root;
	private int counter;
	private ArrayList<BSTNode> list = new ArrayList<BSTNode>();

	/************************** INSERT PAIR **************************/

	/**
	 * adds the value to the tree
	 * 
	 * @param i the value to add
	 */
	public void insert(int i) {
		root = helperInsert(root, i);
	}

	/**
	 * helper method to add the value to the tree
	 * 
	 * @param node  current node
	 * @param value value to add
	 * @return BSTNode the current node
	 */
	private BSTNode helperInsert(BSTNode node, int value) {
		if (node == null)
			node = new BSTNode(value);
		else if (node.data > value)
			node.left = helperInsert(node.left, value);
		else if (node.data < value)
			node.right = helperInsert(node.right, value);
		return node;
	}

	/************************** SIZE PAIR **************************/

	/**
	 * size of the tree
	 * 
	 * @return int the size of the tree
	 */
	public int size() {
		counter = 0;
		return helperSize(root);
	}

	/**
	 * outputs the total size of the tree
	 * 
	 * @param node the current node
	 * @return int the size of the tree
	 */
	private int helperSize(BSTNode node) {
		if (node != null) {
			helperSize(node.left);
			counter++;
			helperSize(node.right);
		}
		return counter;
	}

	/************************** CONTAINS PAIR **************************/

	/**
	 * checks if value is present in tree
	 * 
	 * @param i the value to check for
	 * @return boolean if the node is present in the tree
	 */
	public boolean contains(int i) {
		return helperContains(root, i);
	}

	/**
	 * ehlper method for the contains method
	 * 
	 * @param node  the current node
	 * @param value the value to add
	 * @return boolean if the value is present or not
	 */
	private boolean helperContains(BSTNode node, int value) {
		if (node == null) {
			return false;
		} else if (node.data == value) {
			return true;
		}
		return helperContains(node.left, value) || helperContains(node.right, value);
	}

	/************************** MIN PAIR **************************/

	/**
	 * outputs the left most node
	 * 
	 * @return the smallest node
	 */
	public int getMin() {
		if (root == null)
			throw new NoSuchElementException();
		else
			return helperMin(root);
	}

	/**
	 * helper method that outputs the smallest node
	 * 
	 * @param node the current node
	 * @return int the smallest node
	 */
	private int helperMin(BSTNode node) {
		if (node.left == null)
			return node.data;
		else
			return helperMin(node.left);
	}

	/************************** MAX PAIR **************************/

	/**
	 * method that outputs the greatest node
	 * 
	 * @param node the current node
	 * @return int the greatest node
	 */
	public int getMax() {
		if (root == null)
			throw new NoSuchElementException();
		else
			return helperMax(root);
	}

	/**
	 * helper method that outputs the greatest node
	 * 
	 * @param node the current node
	 * @return int the greatest node
	 */
	private int helperMax(BSTNode node) {
		if (node.right == null)
			return node.data;
		else
			return helperMax(node.right);
	}

	/************************** PRINT PAIR **************************/

	/**
	 * prints the tree
	 */
	public void print() {
		helperPrint(root, 1);
	}

	/**
	 * prints the tree
	 * 
	 * @param node  the current tree
	 * @param level the current level
	 */
	private void helperPrint(BSTNode node, int level) {
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

	/**
	 * prints the tree in order traversal
	 */
	public void inOrder() {
		helperInOrder(root, 1);
		Collections.reverse(list);
		System.out.println(list);
	}

	/**
	 * helper method that prints the tree in order traversal
	 * 
	 * @param node  the current node
	 * @param level the current level
	 */
	private void helperInOrder(BSTNode node, int level) {
		if (node != null) {
			helperInOrder(node.right, level + 1);
			list.add(node);
			helperInOrder(node.left, level + 1);
		}
	}

	/************************** DELETE PAIR **************************/

	/**
	 * deletes the node from the tree
	 * 
	 * @param i the value to delete
	 */
	public void delete(int i) {
		if (contains(i))
			deleteNode(root, i);
	}

	/**
	 * removes the node
	 * 
	 * @param node  the current node
	 * @param value the value to look for
	 * @return BSTNode the current node
	 */
	private BSTNode deleteNode(BSTNode node, int value) {
		if (node == null)
			return node;
		BSTNode smallest = new BSTNode(9); // replacement
		while (smallest.left != null)
			smallest = smallest.left;
		if (node.data > value) // go left to find the node
			node.left = deleteNode(node.left, value);
		else if (node.data < value) // go right to find the node
			node.right = deleteNode(node.right, value);
		else {
			if (node.left == null) // right to current
				return node.right;
			else if (node.right == null) // left to current
				return node.left;
			node.data = smallest.data;
			node.right = deleteNode(node.right, node.data);
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
	}

}
