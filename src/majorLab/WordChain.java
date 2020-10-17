package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WordChain {
	private String original; // starting input
	private String answer; // end result
	private Queue<Stack<String>> paths; // all paths
	private ArrayList<String> dictionary; // the words

	/**
	 * preferred constructor
	 * 
	 * @param original the word we start with
	 * @param answer   the end result we want
	 */
	public WordChain(String original, String answer) {
		this.original = original.toUpperCase(); // matches the formatting of dictionary
		this.answer = answer.toUpperCase(); // matches the formatting of dictionary
		paths = new LinkedList<Stack<String>>();
		dictionary = new ArrayList<String>();
	}

	/**
	 * checks if original and answer are in the dictionary
	 * 
	 * @return true if both variables are in the dictionary, false if not
	 * @throws FileNotFoundException
	 */
	public boolean valid() throws FileNotFoundException {
		int counter = 0;
		Scanner key = new Scanner(new File("dictionary.txt"));

		while (key.hasNext()) {
			String line = key.nextLine();
			if (line.equals(original) || line.equals(answer))
				counter++; // increments if line is original or answer

		}
		return counter == 2;
	}

	/**
	 * keeps checking for path until the queue is empty
	 * 
	 * @return Stack<String> the working path
	 */
	public Stack<String> layer() throws FileNotFoundException {
		if (!valid())
			return null;

		if (original.equals(answer)) {
			paths.add(new Stack<String>());
			paths.peek().add(original);
			return paths.peek();
		}

		paths.add(new Stack<String>()); // adding first word
		paths.peek().add(original);
		dictionary.remove(original);

		while (!paths.isEmpty()) {
			for (int i = 0; i < dictionary.size(); i++) { // iterate thru each word
				if (compare(dictionary.get(i), paths.peek().peek())) { // check if off by one
					Stack<String> stack = new Stack<String>();

					int size = paths.peek().size();
					for (int k = 0; k < size; k++) // copying stacks and transferring
						stack.add(paths.peek().get(k));

					stack.add(dictionary.get(i));
					paths.add(stack);

					if (dictionary.get(i).equals(answer)) // if the stack has the answer
						return stack;

					dictionary.remove(i);
					i--;
				}
			}
			paths.remove(); // stack is does not contain answer
		}
		return null;
	}

	/**
	 * checks if the two words are off by one
	 * 
	 * @param source      word one to compare (dictionary.get(i))
	 * @param destination word two to compare (word)
	 * @return boolean true if the words are off by one
	 */
	public boolean compare(String source, String destination) {
		int errorCount = 0;

		for (int i = 0; i < source.length(); i++) {
			if (source.charAt(i) != destination.charAt(i)) // the position does not match
				errorCount++;
		}

		if (errorCount == 1) // words can only be off by one
			return true;

		return false;
	}

	/**
	 * populates the dictionary list with potential words
	 */
	public void dictionary() throws FileNotFoundException {
		Scanner key = new Scanner(new File("dictionary.txt"));

		while (key.hasNextLine()) {
			String line = key.nextLine();
			if (line.length() == original.length()) // add only if same length
				dictionary.add(line);
		}
	}
}
