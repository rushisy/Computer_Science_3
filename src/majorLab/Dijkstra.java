package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	private Graph graph;
	private PriorityQueue<Vertex> queue;

	public Dijkstra(Graph graph) {
		this.graph = graph;
		queue = new PriorityQueue<Vertex>();
		dijkstra(0, 1);
	}

	private void dijkstra(int source, int destination) {
		graph.array[source].distance = 0;
		queue.add(graph.array[source]);

		while (!queue.isEmpty()) {
			Vertex smallest = queue.poll();
			smallest.visited = true;
			for (Integer index : smallest.edges) {
				graph.array[index].distance = graph.array[index].distance(smallest);
//				if (queue.peek() != null && graph.array[index].visited == false && smallest.distance < queue.peek().distance)
//					queue.add(graph.array[index]);
			}
			System.out.println(queue.toString());
		}

		for (int i = 0; i < graph.array.length; i++) {
			System.out.println(graph.array[i].toString());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Graph obj = new Graph(new Scanner(new File("input6.txt")));
		Dijkstra obj2 = new Dijkstra(obj);

	}
}