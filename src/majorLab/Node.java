package majorLab;

public class Node implements Comparable<Node> {
	public int frequency;
	public int letter;
	public Node left;
	public Node right;

	public Node(int letter, int frequency, Node left, Node right) {
		this.frequency = frequency;
		this.letter = letter;
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Node obj) {
		return frequency - obj.frequency;
	}
}