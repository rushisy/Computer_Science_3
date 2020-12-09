package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Dijkstra {
	private Graph graph;
	private PriorityQueue<Vertex> queue;
	private Set<Integer> set;
	private int start;
	private int end;

	/**
	 * preferred constructor
	 * 
	 * @param graph the graph object of the nodes
	 * @param start the starting place
	 * @param end   the ending place
	 */
	public Dijkstra(Graph graph, int start, int end) {
		this.graph = graph;
		queue = new PriorityQueue<Vertex>();
		set = new HashSet<Integer>();
		this.start = start;
		this.end = end;
		dijkstra(start, end);
	}

	/**
	 * dijkstra algorithm that returns the shortest path between two nodes
	 * 
	 * @param source      the starting node
	 * @param destination the ending node
	 */
	public void dijkstra(int source, int destination) {
		graph.array[source].distance = 0;
		queue.add(graph.array[source]);

		while (!queue.isEmpty()) {
			Vertex smallest = queue.poll();
			smallest.visited = true;
			for (Integer index : smallest.edges) {
				if (!graph.array[index].visited
						&& smallest.distance + smallest.distance(graph.array[index]) < graph.array[index].distance) {
					graph.array[index].distance = graph.array[index].distance(smallest) + smallest.distance;
				}
				queue.add(graph.array[index]);
			}

		}

		for (int i = 0; i < graph.array.length; i++) {
			System.out.println("process node " + i + " (dist " + graph.array[i].distance + ")");
			for (Integer j : graph.array[i].edges) {
				if (!set.contains(j))
					System.out.println("\tprocess node " + j + " (dist " + graph.array[j].distance + ")");
				set.add(j);
			}
		}
		System.out.println();
		path(source, destination);
		System.out.println();
		for (int i = 0; i < graph.array.length; i++) {
			System.out.println(graph.array[i].toString());
		}
	}

	private void path(int source, int destination) {
		String output = "Shortest path from " + source + " and " + destination + "\n\n" + source;

		while (source != destination) {
			if (graph.array[source].edges.contains(destination)) {
				output += " -> " + destination;
				source = destination;
			} else {
				output += " -> " + graph.array[source].edges.get(0);
				source = graph.array[source].edges.get(0);
			}

		}
		System.out.println(output);

	}

	public static void main(String[] args) throws FileNotFoundException {
		Graph obj = new Graph(new Scanner(new File("input6.txt")));
		Dijkstra obj2 = new Dijkstra(obj, 0, 5);

	}
}