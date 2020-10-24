package twentyQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameTree {
	private Node root;
	private static Choice choice;
	private String output;

	/************************* CONSTRUCTOR PAIR *************************/

	public GameTree(String fileName) {
		output = "";
		try {
			Scanner scan = new Scanner(new File(fileName));
			while (scan.hasNextLine()) {
				root = fileHelper(scan);
			}
		} catch (FileNotFoundException s) {
			System.out.println("File does Not Exist Please Try Again: ");
			root = null;
		}
	}

	private Node fileHelper(Scanner key) {
		Node node = null;
		if (key.hasNextLine()) {
			String line = key.nextLine();
			if (line.contains("?")) {
				node = new Node(line);
				node.left = fileHelper(key);
				node.right = fileHelper(key);
			} else {
				node = new Node(line);
			}
		}
		return node;
	}

	/************************* INSERTION PAIR *************************/

	public void add(String newQ, String newA) {
		if (root == null) {
			root = new Node(newQ);
			root.left = new Node(newA);
		}
		helperAdd(root, newQ, newA);

	}

	private Node helperAdd(Node node, String question, String answer) {
		if (node == null) {
			node = new Node(question); // question
			node.left = new Node(answer); // correct answer
		} else if (node.left == null && node.right == null) {
			String entry = node.data; // question
			node.data = question;
			node.left = new Node(answer); // correct answer
			node.right = new Node(entry); // incorrect answer
		} else if (choice == Choice.Yes)
			node.left = helperAdd(node.left, question, answer);
		else if (choice == Choice.No)
			node.right = helperAdd(node.right, question, answer);
		return node;
	}

	/************************* GETTER METHODS *************************/

	public boolean foundAnswer() {
		return !getCurrent().contains("?");
	}

	public String getCurrent() {
		return null;
	}

	private Node helperCurrent(Node node) {
		return null;
	}

	/************************* ATTRIBUTE METHODS *************************/

	public void playerSelected(Choice yesOrNo) {
		choice = yesOrNo;
	}

	public void reStart() {
	}

	public void saveGame() {
	}

	/************************* PRINTING PAIR *************************/

	@Override
	public String toString() {
		String string = helperPrint(root, 0);
		output = "";
		return string;
	}

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
		Node left;
		Node right;

		public Node(String data) {
			this.data = data;
			left = right = null;
		}
	}
}
