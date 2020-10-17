package majorLab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WordChain {

	private String original; // starting input
	private String answer; // end result
	private Queue<Stack<String>> paths; // all paths
	private boolean flag; // when to stop

	/**
	 * preferred constructor
	 * 
	 * @param original the word we start with
	 * @param answer   the end result we want
	 */
	public WordChain(String original, String answer) {
		this.original = original.toUpperCase();
		this.answer = answer;
		paths = new LinkedList<Stack<String>>();
	}

	/**
	 * outputs a possible path
	 */
	public void firstLayer() throws IOException {
		checkFlag();
		Scanner key = new Scanner(new File("newDictionary.txt"));
		ArrayList<String> list = new ArrayList<String>();

		while (key.hasNextLine()) {

			int counter = 0;
			String line = key.nextLine();
			for (int i = 0; i < answer.length(); i++) {
				if (line.charAt(i) == original.charAt(i)) {
					counter++;
				}

			}
			if (counter == (original.length() - 1)) {
				paths.add(new Stack<String>());
				list.add(line);

			}

		}

		int counter = 0;
		for (Stack<String> s : paths) {

			if (counter < list.size()) {
				s.push(original);
				s.push(list.get(counter));
				counter++;

			}

		}

	}

	public void layer() throws IOException {
		checkFlag();
		Scanner key = new Scanner(new File("newDictionary.txt"));
		ArrayList<String> list = new ArrayList<String>();

		Queue<Stack<String>> queue = new LinkedList<Stack<String>>();
		Stack<String> temp = new Stack<String>();
		temp = paths.remove();
		queue.add(temp);

		while (key.hasNextLine()) {
			int counter = 0;
			String line = key.nextLine();
			for (int i = 0; i < answer.length(); i++) {
				if (line.charAt(i) == queue.peek().peek().charAt(i)) {
					counter++;
				}
			}
			if (counter == (original.length() - 1)) {
				queue.add(new Stack<String>());
				list.add(line);
				removeTerm("newDictionary.txt", line);

			}
		}

		int counter = 0;
		for (Stack<String> s : queue) {

			int size = temp.size();
			for (int i = 0; i < size; i++) {
				s.push(temp.get(i));
				// System.out.println(temp.get(i));
			}
			removeDupes(s);
			// s.setSize(size / 2 + 1);
			if (counter < list.size()) {
				s.push(list.get(counter));
				counter++;
			}
		}
		((LinkedList<Stack<String>>) queue).removeLast();

		for (Stack<String> s : queue) {
			paths.add(s);
		}
	}

	/**
	 * removes terms that have been used
	 * 
	 * @param filepath   the old file name
	 * @param removeTerm the term to look for and remove
	 * 
	 */
	public void removeTerm(String filepath, String removeTerm) throws IOException {
		File oldFile = new File(filepath);
		File newFile = new File("temp.txt");

		FileWriter fw = new FileWriter("temp.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		String line = "";

		Scanner key = new Scanner(new File(filepath));

		key.useDelimiter("[\n]");

		while (key.hasNext()) {
			line = key.next();
			if (!line.equals(removeTerm)) {
				pw.println(line);
			}
		}
		pw.close();

		oldFile.delete();
		File dump = new File(filepath);
		newFile.renameTo(dump);
	}

	/**
	 * removes the duplicates
	 */
	public void removeDupes(Stack<String> s) {
		int size = s.size();
		
		for (int i = 0; i < size; i++) {
			if (s.contains(s.get(i))) {
				s.remove(i);
			}
		}
	}

	/**
	 * outputs the stack with the shortest length
	 * 
	 * @return Queue<String> the shortest path
	 */
	public Stack<String> getShortestPath() {
		for (Stack<String> s : paths) {
			if (s.contains(answer)) {
				return s;
			}
		}
		return null;
	}

	/**
	 * creates txt file to use as the new dictionary
	 */
	public void newDictionary() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(new File("newDictionary.txt")));
		Scanner key = new Scanner(new File("dictionary.txt"));

		while (key.hasNextLine()) {
			String line = key.nextLine();

			if (line.length() == original.length()) {
				pw.println(line);
			}

		}

		pw.close();
	}

	public void checkFlag() {
		for (Stack<String> s : paths) {
			if (s.contains(answer)) {
				flag = true;
			}
		}
	}

	/**
	 * outputs a queue with all the possible paths
	 * 
	 * @return Queue<Stack<String>> the queue of stacks
	 */
	public Queue<Stack<String>> getPaths() {
		return this.paths;
	}

	/**
	 * outputs the original input
	 * 
	 * @return String the input variable
	 */
	public String getOriginal() {
		return this.original;
	}

	/**
	 * outputs the desired output
	 * 
	 * @return String the answer variable
	 */
	public String getAnswer() {
		return this.answer;
	}

	/**
	 * outputs the flag variable
	 * 
	 * @return boolean the flag variable
	 */
	public boolean getFlag() {
		return this.flag;
	}

	/**
	 * sets the original variable to the input
	 * 
	 * @param input the content to assign original
	 */
	public void setOriginal(String input) {
		this.original = input;
	}

	/**
	 * sets the answer variable to the input
	 * 
	 * @param input the content to assign answer
	 */
	public void setAnswer(String input) {
		this.answer = input;
	}

	/**
	 * outputs the paths in desired format
	 * 
	 * @return String the desired formatting
	 */
}
