package majorLab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.PriorityQueue;

public class HuffmanTree {
	private Node root;
	private PriorityQueue<Node> tree = new PriorityQueue<Node>();

	public HuffmanTree(int[] count) {

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0 && i > 10)
				System.out.println("index: " + i + ", char: " + i + ", count: " + count[i]);
			if (count[i] != 0) {
				tree.add(new Node(i, (char) count[i], null, null));
			}
		}
		tree.add(new Node(256, (char) 1, null, null));
		while (tree.size() > 1) {
			Node left = tree.poll();
			Node right = tree.poll();

			tree.add(new Node(-1, (char) (left.frequency + right.frequency), left, right));
		}
		root = tree.poll();
	}
	
	public Node getRoot() {
		return root;
	}

	public void write(String filename) throws IOException {
		FileOutputStream writer = new FileOutputStream(filename, true);
		writeHelper(writer, root, "");
	}

	public void writeHelper(FileOutputStream writer, Node current, String binary) throws IOException {
		if (current.left == null & current.right == null) {
			System.out.print(current.letter + "\n" + binary);
		} else {
			writeHelper(writer, current.left, binary + 0);
			writeHelper(writer, current.right, binary + 1);
		}
	}

}

class Node implements Comparable<Node> {
	public int frequency;
	public char letter;
	public Node left, right;

	public Node(int frequency, char letter, Node left, Node right) {
		this.frequency = frequency;
		this.letter = letter;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Node obj) {
		return frequency - obj.frequency;
	}

	@Override
	public String toString() {
		return "here";
	}

}