package majorLab;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
	public int x;
	public int y;
	public int id;
	public ArrayList<Integer> edges;
	public boolean visited;
	public double distance;

	/**
	 * preferred constructor
	 * 
	 * @param id the name of the node
	 * @param x  the x position
	 * @param y  the y position
	 */
	public Vertex(int id, int x, int y) {
		this.x = x;
		this.y = y;
		this.id = id;
		edges = new ArrayList<Integer>();
		distance = Double.POSITIVE_INFINITY;
	}

	/**
	 * outputs the euclidean distance between two points
	 * 
	 * @param vertex the input point to find the distance between
	 * @return double the distance between the two points
	 */
	public double distance(Vertex vertex) {
		return Math.pow(Math.pow(this.x - vertex.x, 2) + Math.pow(this.y - vertex.y, 2), 0.5);
	}

	/**
	 * override compare to method
	 */
	@Override
	public int compareTo(Vertex vertex) {
		if (this.distance > vertex.distance)
			return 1;
		else if (this.distance < vertex.distance)
			return -1;
		else
			return 0;
	}

	/**
	 * overriden tostring that outputs all variables
	 */
	@Override
	public String toString() {
		return id + ": (" + x + ", " + y + ") " + edges.toString() + " " + distance;
	}
}
