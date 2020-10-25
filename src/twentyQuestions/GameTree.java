package twentyQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameTree {
	private Node root, position;
	private String output, filename, question;
	private static Choice choice;

	/************************* CONSTRUCTOR PAIR *************************/

	public GameTree(String fileName) {
		filename = fileName;
		question = output = "";
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

	private Node fileHelper(Scanner key) {
		Node node = null;
		if (key.hasNextLine()) {
			String line = key.nextLine().trim();
			if (line.contains("?")) {
				node = new Node(line);
				node.left = fileHelper(key);
				node.right = fileHelper(key);
			} else
				node = new Node(line);
		}
		return node;
	}

	/************************* INSERTION PAIR *************************/

	public void add(String newQ, String newA) {
		if (!question.equals(""))
			question += "\n" + newQ + "\n" + newA;
		else
			question = newQ + "\n" + newA;
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
		return position.left == null && position.right == null;
	}

	public String getCurrent() {
		if (choice == Choice.Yes && position.left != null)
			position = position.left;
		else if (choice == Choice.No && position.right != null)
			position = position.right;
		return position.data;
	}

	/************************* ATTRIBUTE METHODS *************************/

	public void playerSelected(Choice yesOrNo) {
		choice = yesOrNo;
	}

	public void reStart() {
		position = root;
		choice = null;
		output = "";
	}

	public void saveGame() {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(filename, true));
			output.println(question);
			output.close();
			question = "";
		} catch (Exception e) {
		}
	}

	/************************* PRINTING PAIR *************************/

	@Override
	public String toString() {
		return helperPrint(root, 0);
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
		Node left, right;

		public Node(String data) {
			this.data = data;
			left = right = null;
		}
	}
}
