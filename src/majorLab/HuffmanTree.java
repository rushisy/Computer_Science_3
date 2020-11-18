package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanTree {
	private Node root;
	private PriorityQueue<Node> tree;

	/**
	 * preferred constructor
	 * 
	 * @param count array of values to add to the queue
	 */
	public HuffmanTree(int[] count) {
		tree = new PriorityQueue<Node>();

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				tree.add(new Node(i, count[i], null, null));
		}
		tree.add(new Node(256, 1, null, null));
		while (tree.size() >= 2) {
			Node left = tree.poll();
			Node right = tree.poll();
			tree.add(new Node(-1, left.frequency + right.frequency, left, right));
		}
		root = tree.poll();
	}

	/**
	 * encodes the tree
	 * 
	 * @param filename the data to create the code off of
	 */
	public void write(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new File(filename));
		writeHelper(writer, root, "");
		writer.close();
	}

	/**
	 * creates the coded file by using binary
	 * 
	 * @param output  the PrintWriter to create a coded file
	 * @param current the current position of the node
	 * @param binary  the path
	 */
	private void writeHelper(PrintWriter output, Node current, String binary) {
		if (current.left == null & current.right == null)
			output.println(current.letter + "\n" + binary);
		else {
			writeHelper(output, current.left, binary + 0);
			writeHelper(output, current.right, binary + 1);
		}
	}

	/**
	 * populates the tree from the file
	 * 
	 * @param filename the file to create the tree based off of
	 */
	public HuffmanTree(String filename) throws FileNotFoundException {
		Scanner key = new Scanner(new File(filename));
		root = new Node(-1, 0, null, null);
		while (key.hasNextLine()) {
			int line = Integer.parseInt(key.nextLine());
			String code = key.nextLine();
			Node node = root;
			for (int i = 0; i < code.length(); i++) {
				if (code.charAt(i) == '0') {
					if (node.left == null)
						node.left = new Node(-1, 0, null, null);
					node = node.left;
				} else {
					if (node.right == null)
						node.right = new Node(-1, 0, null, null);
					node = node.right;
				}
			}
			node.letter = line;
		}
	}

	/**
	 * decodes the file
	 * 
	 * @param input    the BitInputStream object of the binary code
	 * @param filename the outfile to write to
	 */
	public void decode(BitInputStream input, String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new File(filename));
		int bits = 0;
		String line = "";

		while (1 != 0) {
			Node position = root;
			while (1 != 0) {
				if (input.readBit() == 0)
					position = position.left;
				else
					position = position.right;
				if (position.letter >= 0)
					break;
			}
			bits = position.letter;
			if (bits < 256)
				line += (char) bits;
			else
				break;
		}
		writer.print(line);
		writer.close();
	}
}