package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bfs {
	private static ArrayList<int[]> list;
	private static HashMap<Integer, ArrayList<Integer>> adjMap;
	private static int[][] matrix;

	public static void main(String[] args) {
		adjMap = new HashMap<Integer, ArrayList<Integer>>();
		list = new ArrayList<int[]>();
		list.add(new int[] { 0, 1 });
		list.add(new int[] { 1, 7 });
		list.add(new int[] { 1, 2 });
		list.add(new int[] { 7, 6 });
		list.add(new int[] { 7, 5 });
		list.add(new int[] { 7, 4 });
		list.add(new int[] { 2, 5 });
		list.add(new int[] { 2, 4 });
		list.add(new int[] { 2, 3 });
		list.add(new int[] { 6, 5 });
		list.add(new int[] { 5, 2 });
		list.add(new int[] { 5, 4 });
		list.add(new int[] { 4, 3 });

		populate();

		for (Integer key : adjMap.keySet()) {
			System.out.println(key + " -> " + adjMap.get(key).toString());
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Set<Integer> set = new LinkedHashSet<Integer>();
		dfs(1, set, result);
		System.out.println("dfs: " + result.toString());
		bfs(1);
		matrix();
		islands();

	}

	private static void populate() {
		for (int[] i : list) {
			int x = i[0];
			int y = i[1];

			if (!adjMap.containsKey(x)) {
				adjMap.put(x, new ArrayList<Integer>());
			}

			if (!adjMap.containsKey(y)) {
				adjMap.put(y, new ArrayList<Integer>());
			}

			adjMap.get(y).add(x);
			adjMap.get(x).add(y);
		}
	}

	/**
	 * Queue Visited Output 1 1 _ 1 1 7,2 7,2 1 2, 1,7 2,6,5,4 6,5,4 1,7 6,5,4,3 3
	 * 1,7,2 5,4,3 7 1,7,2,6 4,3 _ 1,7,2,6,5 3 _ 1,7,2,6,5,4 _ _ 1,7,2,6,5,4,3
	 */
	private static void bfs(int source) {
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		q.add(source);
		visited.add(source);
		while (!q.isEmpty()) {
			int popped = q.remove();
			path.add(popped);
			ArrayList<Integer> neighbors = adjMap.get(popped);
			for (int i : neighbors) {
				if (!visited.contains(i)) {
					visited.add(i);
					q.add(i);
				}
			}
		}
		System.out.println("bfs: " + path.toString());
	}

	/**
	 * dfs(1, _, _) dfs(7, 1, 1) dfs(2, 1, 1) dfs(1, 1,7, 1) dfs(6, 1,7, 1,7) dfs(5,
	 * 1,7, 1,7)
	 */
	private static void dfs(int source, Set<Integer> visited, ArrayList<Integer> result) {
		if (visited.contains(source))
			return;
		result.add(source);
		visited.add(source);
		ArrayList<Integer> neighbors = adjMap.get(source);
		for (int i : neighbors)
			dfs(i, visited, result);
	}

	private static void matrix() {
		matrix = new int[8][8];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			matrix[list.get(i)[0]][list.get(i)[1]] = 1;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void islands() {
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					counter++;
					islandsDFS(i, j);
				}

			}
		}
		System.out.println("Counter: " + counter);

	}

	private static void islandsDFS(int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0)
			return;
		matrix[i][j] = 0;
		islandsDFS(i + 1, j);
		islandsDFS(i + 1, j + 1);
		islandsDFS(i, j + 1);
		islandsDFS(i - 1, j);
		islandsDFS(i - 1, j + 1);
		islandsDFS(i + 1, j - 1);
		islandsDFS(i, j - 1);
		islandsDFS(i - 1, j - 1);
	}
	
	// traverse and get neighbors
	// bfs: iterative using queue
	// dfs: recurrsion 
}
