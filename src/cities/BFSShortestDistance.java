package cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSShortestDistance {
	private static ArrayList<char[]> list;
	private static HashMap<Character, ArrayList<Character>> adjMap;
	private static Node root;
	private static ArrayList<ArrayList<Integer>> path;
	private static int maxLevel = 0;
	private static int height = 0;
	private static int diameter = 0;

	public static void main(String[] args) {
		list = new ArrayList<char[]>();
		adjMap = new HashMap<Character, ArrayList<Character>>();
		list.add(new char[] { 'a', 'b' });
		list.add(new char[] { 'b', 'c' });
		list.add(new char[] { 'b', 'd' });
		list.add(new char[] { 'd', 'e' });
		list.add(new char[] { 'c', 'e' });
		populate();

		for (char i : adjMap.keySet()) {
			System.out.println(i + " -> " + adjMap.get(i));
		}

		root = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		Node f = new Node(7);
		root.left = a;
		root.right = b;

		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;

		treeBFS(root);
		treeBFSLevelbyLevel(root);
		bfs('a', 'e');
		treeLevelByLevelRightView(root);
		// treeRecursionLeft(root, 1);
		// maxLevel = 0;
		// treeRecursionRight(root, 1);
		path = new ArrayList<ArrayList<Integer>>();
		// zigzagLevelOrder(root, 1);
		System.out.println(treeHeight(root));
		treeWidth(root);
		treePrintByLevel(root, 2);
		printLeaves(root);
		printOneChildNodes(root);
		diameterOfTriangle(root);
		System.out.println("diameter: " + --diameter);
	}

	// a
	// b
	// c d
	// e

	public static void populate() {
		for (char[] i : list) {
			char source = i[0];
			char destination = i[1];

			if (!adjMap.containsKey(source))
				adjMap.put(source, new ArrayList<Character>());
			adjMap.get(source).add(destination);
		}
	}

	public static void bfs(char source, char destination) {
		Queue<Character> q = new LinkedList<Character>();
		Set<Character> visited = new HashSet<Character>();
		int counter = -1;
		q.add(source);

		while (!q.isEmpty()) {
			counter++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				char popped = q.remove();
				if (popped == destination) {
					System.out.println(counter);
					return;

				}
				visited.add(popped);
				if (adjMap.containsKey(popped))
					for (char j : adjMap.get(popped))
						if (!visited.contains(j))
							q.add(j);
			}
		}
	}

	public static void treeBFS(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		q.add(root);

		while (!q.isEmpty()) {
			Node popped = q.remove();
			path.add(popped.data);

			if (popped.left != null)
				q.add(popped.left);
			if (popped.right != null)
				q.add(popped.right);
		}
		System.out.println(path);
	}

	public static void treeBFSLevelbyLevel(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		path = new ArrayList<ArrayList<Integer>>();
		q.add(root);
		int counter = -1;
		while (!q.isEmpty()) {
			counter++;

			int size = q.size();
			ArrayList<Integer> d = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				Node popped = q.remove();
				d.add(popped.data);
				if (popped.left != null)
					q.add(popped.left);
				if (popped.right != null)
					q.add(popped.right);
			}
			path.add(d);

		}
		System.out.println(path + " " + counter);
	}

	/**
	 * level: [[1], [2,3], [4,5,6,7]] 1 2 3 4 5 6 7 zigzag: [[1], [3,2], [4,5,6,7]]
	 */

	public static void treeLevelByLevelRightView(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		path = new ArrayList<ArrayList<Integer>>();
		q.add(root);
		int counter = -1;
		while (!q.isEmpty()) {
			counter++;

			int size = q.size();
			ArrayList<Integer> d = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				Node popped = q.remove();
				if (i == size - 1)
					d.add(popped.data);

				if (popped.left != null)
					q.add(popped.left);
				if (popped.right != null)
					q.add(popped.right);
			}
			path.add(d);

		}
		System.out.println(path + " " + counter);
	}

	public static void zigzagLevelOrder(Node root, int level) {

		Queue<Node> q = new LinkedList<Node>();
		int counter = -1;
		q.add(root);
		while (!q.isEmpty()) {
			counter++;
			int size = q.size();
			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				Node popped = q.remove();
				if (counter % 2 == 0)
					neighbors.add(popped.data);
				else
					neighbors.add(0, popped.data);

				if (popped.left != null)
					q.add(popped.left);
				if (popped.right != null)
					q.add(popped.right);
			}
			path.add(neighbors);
		}
		System.out.println(path + " " + counter);
	}

	public static void treeRecursionLeft(Node root, int level) {
		if (root == null)
			return;
		if (level > maxLevel) {
			System.out.println(root.data);
			maxLevel = level;
		}
		treeRecursionLeft(root.left, level + 1);
		treeRecursionLeft(root.right, level + 1);
	}

	private static void treeRecursionRight(Node root, int level) {
		if (root == null)
			return;

		if (level > maxLevel) {
			System.out.println(root.data);
			maxLevel = level;
		}
		treeRecursionRight(root.right, level + 1);
		treeRecursionRight(root.left, level + 1);
	}

	public static int treeHeight(Node root) {
		if (root == null)
			return 0;
		return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
	}

	public static void treeWidth(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		int width = 0;
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			width = Math.max(size, width);
			for (int i = 0; i < size; i++) {
				Node popped = q.remove();
				if (popped.left != null) {
					q.add(popped.left);
				}
				if (popped.right != null) {
					q.add(popped.right);
				}
			}
		}
		System.out.println(width);
	}

	public static void treePrintByLevel(Node root, int level) {
		Queue<Node> q = new LinkedList<Node>();
		int counter = 0;
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			counter++;
			ArrayList<Integer> output = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				Node popped = q.remove();
				output.add(popped.data);
				if (popped.left != null) {
					q.add(popped.left);
				}
				if (popped.right != null) {
					q.add(popped.right);
				}
			}
			if (counter == level) {
				System.out.println(output);
			}
		}
	}

	public static void printLeaves(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.println(root.data);

		printLeaves(root.left);
		printLeaves(root.right);
	}

	public static void printOneChildNodes(Node root) {
		if (root == null)
			return;

		int counter = 0;
		if (root.left == null)
			counter++;
		if (root.right == null)
			counter++;
		if (counter == 1)
			System.out.println(root.data);

		printOneChildNodes(root.left);
		printOneChildNodes(root.right);
	}

	public static int diameterOfTriangle(Node root) {
		if (root == null)
			return 0;
		int l = diameterOfTriangle(root.left);
		int r = diameterOfTriangle(root.right);
		diameter = Math.max(diameter, l + r + 1);
		return Math.max(l, r) + 1;
	}

	/**
	 * 
	 * th(1) -> 3 max(th(2) -> 2, th(3) -> 2) +1 th(4) -> 1 th(5) -> 1 -> 2 th(null)
	 * th(null) th(null) th(null) 0 0 0 0
	 * 
	 * th(6) -> 1 th(7) -> 1 -> 2 th(null) th(null) th(null) th(null) 0 0 0 0
	 */

	/**
	 * 1 2 3 45 67
	 * 
	 * tr(1, 1,0) -> 1 tr(2, 2, 1) tr(3,2,1) sys(2)
	 * 
	 */

}

class Node {
	int data;
	Node right;
	Node left;

	public Node(int data) {
		this.data = data;
		right = left = null;
	}

}
