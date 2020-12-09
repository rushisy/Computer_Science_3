package majorLab;

import java.util.Scanner;

public class Graph {
	public int vertices;
	public int edges;
	public Vertex[] array;

	/**
	 * preferred constructor
	 * 
	 * @param key the scanner to the file
	 */
	public Graph(Scanner key) {
		vertices = key.nextInt();
		edges = key.nextInt();
		array = new Vertex[vertices];

		key.nextLine();
		for (int i = 0; i < vertices; i++) {
			array[i] = new Vertex(key.nextInt(), key.nextInt(), key.nextInt());
		}

		key.nextLine();
		for (int i = 0; i < edges; i++) {
			array[key.nextInt()].edges.add(key.nextInt());
		}
	}

	/**
	 * returns the euclidean distance between to points
	 * 
	 * @param from point one
	 * @param to   point two
	 * @return the distance between two points
	 */
	public double distance(int from, int to) {
		return array[from].distance(array[to]);
	}
}
