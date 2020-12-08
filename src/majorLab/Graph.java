package majorLab;

import java.util.Scanner;

public class Graph {
	public int vertices;
	public int edges;
	public Vertex[] array;

	public Graph(Scanner key) {
		vertices = key.nextInt();
		edges = key.nextInt();
		array = new Vertex[vertices];

		key.nextLine();
		for (int i = 0; i < vertices; i++) {
			array[i] = new Vertex(key.nextInt(), key.nextInt(), key.nextInt());
		}

		key.nextLine();
		for (int i = 0; i <= edges; i++) {
			array[key.nextInt()].edges.add(key.nextInt());
		}
	}

	public double distance(int from, int to) {
		return array[from].distance(array[to]);
	}
}
