package twentyQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameTree {
	private Node root;
	private static Choice choice;
	private String output;

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName) {
		output = "";
		try {
			Scanner key = new Scanner(new File(fileName));
			root = new Node(key.nextLine());
			root.left = new Node(key.nextLine());
			root.right = new Node(key.nextLine());
			root.right.left = new Node(key.nextLine());
			root.right.right = new Node(key.nextLine());
		} catch (FileNotFoundException s) {
			System.out.println("File does Not Exist Please Try Again: ");
			root = null;
		}

	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */

	public void add(String newQ, String newA) {
		if (root == null) {
			root = new Node(newQ);
			root.left = new Node(newA);
		}
		helperAdd(root, newQ, newA);

	}

	public Node helperAdd(Node node, String question, String answer) {
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

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer() {
		return getCurrent().contains("?");
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		return ""; // replace
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		choice = yesOrNo;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart() {
	}

	@Override
	public String toString() {
		String output = helperPrint(root, 0);
		return output;
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

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame() {
	}

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
