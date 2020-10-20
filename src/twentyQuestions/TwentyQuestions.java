package twentyQuestions;

import java.io.File;

public class TwentyQuestions {

	private static final String FILE_NAME = "TwentyQuestionsDataCS225.txt";

	private static class TreeNode {
		boolean finalAnswer;
		String question;
		TreeNode yes;
		TreeNode no;
	}

	public static void main(String[] args) {
		TreeNode root; // Pointer to the root of the question tree.
		String homeDir = System.getProperty("user.home");
		String fullFileName = homeDir + File.separatorChar + FILE_NAME;
		System.out.println(fullFileName);
		try {
			TextIO.readFile(fullFileName); // Tree will be read from this file.
			root = readTree(); // Read the question tree.
		} catch (Exception e) {
			// Couldn't read the tree. Start with a one-node tree.
			System.out.println("No data file found.");
			System.out.println("Starting from scratch.");
			System.out.println();
			root = new TreeNode();
			root.question = "a dog";
			root.finalAnswer = true;
		}
		TextIO.readStandardInput();
		System.out.println();
		System.out.println("Welcome to the game of Twenty Questions!");
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("Think of any item in the category \"animal\"...");
			System.out.println("OK, let's begin.");
			System.out.println();
			play(root);
			System.out.println();
			System.out.println();
			System.out.print("Do you want to play again? ");
			if (TextIO.getlnBoolean() == false)
				break;
		}
		System.out.println();
		System.out.println("OK.  Bye for now!");
		System.out.println();
		try {
			TextIO.writeFile(fullFileName);
			writeTree(root);
		} catch (Exception e) {
			System.out.println("Error while saving data to file " + fullFileName + ":");
			System.out.println(e);
		}
		TextIO.writeStandardOutput();
	}

	private static TreeNode readTree() {
		TreeNode node; // Pointer to the tree that will be read from the file.
		node = new TreeNode();
		node.finalAnswer = TextIO.getBoolean();
		node.question = TextIO.getln().trim();
		if (!node.finalAnswer) {
			node.yes = readTree(); // Read the "yes" subtree for this question.
			node.no = readTree(); // Read the "no" subtree for this question.
		}
		return node;
	}

	private static void writeTree(TreeNode tree) {

	}

	private static void play(TreeNode root) {
  
	}

}
