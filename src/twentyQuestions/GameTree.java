package twentyQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GameTree {
	private String output, filename, insertion;
	private ArrayList<String> list;
	private static Choice choice;
	private Node root, position;

	/************************* CONSTRUCTOR PAIR *************************/

	/**
	 * preferred constructor
	 * 
	 * @param fileName the file to make a tree of
	 */
	public GameTree(String fileName) {
		list = new ArrayList<String>();
		insertion = output = "";
		filename = fileName;
		choice = null;

		try {
			Scanner scan = new Scanner(new File(fileName));
			while (scan.hasNextLine())
				root = fileHelper(scan);
			position = root;
		} catch (FileNotFoundException s) {
			System.out.println("File does Not Exist Please Try Again: ");
		}
	}

	/**
	 * a helper method to add the content to the tree
	 * 
	 * @param key the position in the file
	 * @return Node the current node
	 */
	private Node fileHelper(Scanner key) {
		Node node = null;
		if (key.hasNextLine()) {
			String line = key.nextLine().trim();
			if (line.endsWith("?")) {
				node = new Node(line);
				node.left = fileHelper(key);
				node.right = fileHelper(key);
			} else
				node = new Node(line);
		}
		return node;
	}

	/************************* INSERTION PAIR *************************/

	/**
	 * method that adds values to the tree
	 * 
	 * @param newQ the question to add
	 * @param newA the answer to add
	 */
	public void add(String newQ, String newA) {
		if (!insertion.equals(""))
			insertion += "\n" + newQ + "\n" + newA;
		else
			insertion = newQ + "\n" + newA;

		helperAdd(position, newQ, newA);
		position = root;
	}

	/**
	 * the helper method to add the data to the tree
	 * 
	 * @param node     the current node
	 * @param question the question to add to the tree
	 * @param answer   the answer to add to the tree
	 * @return Node the current node
	 */
	private Node helperAdd(Node node, String question, String answer) {
		if (node.left == null && node.right == null) { // left and right are empty
			String entry = node.data;
			node.data = question;
			node.left = new Node(answer);
			node.right = new Node(entry);
		} else if (choice == Choice.Yes) // left tree
			node.left = helperAdd(node.left, question, answer);
		else if (choice == Choice.No) // right tree
			node.right = helperAdd(node.right, question, answer);
		return node;
	}

	/************************* GETTER METHODS *************************/

	/**
	 * outputs if the answer is found
	 * 
	 * @return boolean true if the answer is found else false
	 */
	public boolean foundAnswer() {
		return position.left == null && position.right == null;
	}

	/**
	 * the current node at the tree
	 * 
	 * @return String the data at the current node
	 */
	public String getCurrent() {
		if (choice == Choice.Yes && position.left != null)
			position = position.left;
		else if (choice == Choice.No && position.right != null)
			position = position.right;
		return position.data;
	}

	/************************* ATTRIBUTE METHODS *************************/

	/**
	 * method to update the choice variable
	 * 
	 * @param yesOrNo the value to update the choice variable with
	 */
	public void playerSelected(Choice yesOrNo) {
		choice = yesOrNo;
	}

	/**
	 * resets some of the values of class
	 */
	public void reStart() {
		position = root;
		choice = null;
		output = "";
	}

	/**
	 * adds the current tree to the file
	 */
	public void saveGame() {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			list = new ArrayList<String>();
			helperSave(root);

			for (int i = 0; i < list.size(); i++)
				output.println(list.get(i));
			output.close();
		} catch (Exception e) {
		}
	}

	/**
	 * a helper method that saves the binary tree
	 * 
	 * @param node the current node
	 * @return Node the current node
	 */
	public Node helperSave(Node node) {
		if (node != null) {
			list.add(node.data);
			node.left = helperSave(node.left);
			node.right = helperSave(node.right);
		}
		return node;
	}

	/************************* PRINTING PAIR *************************/

	/**
	 * the data in the preferred format
	 * 
	 * @return String the data to print
	 */
	@Override
	public String toString() {
		return helperPrint(root, 0);
	}

	/**
	 * a helper method to print the tree
	 * 
	 * @param node  the current node
	 * @param level the level of the current node
	 * @return String the data at the current node
	 */
	public String helperPrint(Node node, int level) {
		if (node != null) {
			helperPrint(node.right, level + 1);
			for (int i = 0; i < level; i++) {
				output += "- ";
			}
			output += node.data + "\n";
			helperPrint(node.left, level + 1);
		}
		return output;
	}

	/************************* PRIVATE NODE CLASS *************************/

	private class Node {
		String data;
		Node left, right;

		/**
		 * preferred constructor
		 * 
		 * @param data the value to set the data variable
		 */
		public Node(String data) {
			this.data = data;
			left = right = null;
		}
	}
}
