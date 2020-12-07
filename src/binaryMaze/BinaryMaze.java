package binaryMaze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryMaze {
	private static Queue<ShortestPosition> queue = new LinkedList<ShortestPosition>();
	private static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String args[]) throws IOException {
		compile("maze1.txt");
		compile("maze2.txt");
		compile("maze3.txt");
	}

	/**
	 * method that preforms the dfs search using relative neighbors
	 * 
	 * @param filename the file to preform the action with
	 */
	public static void compile(String filename) throws FileNotFoundException {
		Scanner key = new Scanner(new File(filename));
		int[][] matrix = new int[key.nextInt()][key.nextInt()];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = key.nextInt();

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		queue.add(new ShortestPosition(new Position(key.nextInt(), key.nextInt()), 0));

		while (!queue.isEmpty()) {
			ShortestPosition polledLocation = queue.poll();

			for (int i = 0; i < 4; i++) {
				int[][] binaryNeighbors = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
				list.add(polledLocation.position.xCoordinate + binaryNeighbors[i][0]);
				try {
					while (polledLocation.position.xCoordinate + binaryNeighbors[i][0] < matrix[0].length
							&& polledLocation.position.xCoordinate + binaryNeighbors[i][0] >= 0
							&& polledLocation.position.yCoordinate + binaryNeighbors[i][1] < matrix.length
							&& polledLocation.position.yCoordinate + binaryNeighbors[i][1] >= 0
							&& matrix[polledLocation.position.xCoordinate
									+ binaryNeighbors[i][0]][polledLocation.position.yCoordinate
											+ binaryNeighbors[i][1]] == 1
							&& !visited[polledLocation.position.xCoordinate
									+ binaryNeighbors[i][0]][polledLocation.position.yCoordinate
											+ binaryNeighbors[i][1]]) {
						visited[polledLocation.position.xCoordinate
								+ binaryNeighbors[i][0]][polledLocation.position.yCoordinate
										+ binaryNeighbors[i][1]] = true;
						queue.add(new ShortestPosition(
								new Position(polledLocation.position.xCoordinate + binaryNeighbors[i][0],
										polledLocation.position.yCoordinate + binaryNeighbors[i][1]),
								polledLocation.distance + 1));
					}
				} catch (Exception e) {
				}
			}
		}
		if (list.get(list.size() - 3) == 1)
			System.out.println(filename.substring(0, filename.length() - 4) + ": -1");
		else
			System.out.println(filename.substring(0, filename.length() - 4) + ": " + (list.get(list.size() - 3) + 2));
	}
}

class ShortestPosition {
	int distance;
	Position position;

	/**
	 * preferred constructor
	 * 
	 * @param position the position object to refer
	 * @param distance the distance of the object
	 */
	public ShortestPosition(Position position, int distance) {
		this.position = position;
		this.distance = distance;
	}
}

class Position {
	int xCoordinate;
	int yCoordinate;

	/**
	 * preferred constructor
	 * 
	 * @param xCoordinate the x value of the position
	 * @param yCoordinate the y value of the position
	 */
	public Position(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
}
