package listOfLIst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListOfList {
	private static ArrayList<int[]> list;
	private static int[][] matrix;
	private static HashMap<Integer, List<List<Integer>>> adjMap;
	private static HashMap<Integer[], Integer> adjWeightMap;
	private static HashMap<Integer, List<Integer>> adjNeighborMap;

	public static void main(String[] args) {
		list = new ArrayList<int[]>();
		matrix = new int[5][5];
		adjMap = new HashMap<Integer, List<List<Integer>>>();
		adjWeightMap = new HashMap<Integer[], Integer>();
		adjNeighborMap = new HashMap<Integer, List<Integer>>();

		list.add(new int[] { 1, 4, 2 });
		list.add(new int[] { 1, 2, 6 });
		list.add(new int[] { 1, 3, 8 });
		list.add(new int[] { 2, 3, 1 });
		list.add(new int[] { 4, 2, 0 });
		list.add(new int[] { 4, 5, 9 });
		list.add(new int[] { 5, 2, -1 });
		list.add(new int[] { 5, 3, 3 });
		// (1,4), (1,2), (1,3)
		// (2,3)
		// (4,5), (4,2)
		// (5,2), (5,3)

		populateList();
		populateMatrix();
		populateWeightedList();
		populateUnWeightedList();

		for (int key : adjMap.keySet()) {
			System.out.println(key + " -> " + adjMap.get(key).toString());
		}

		for (Integer[] key : adjWeightMap.keySet()) {
			System.out.println(Arrays.toString(key) + " -> " + adjWeightMap.get(key));
		}

		for (int key : adjNeighborMap.keySet()) {
			System.out.println(key + " -> " + adjNeighborMap.get(key).toString());
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void populateWeightedList() {
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			int weight = list.get(i)[2];
			adjWeightMap.put(new Integer[] { x, y }, weight);
		}
	}

	private static void populateUnWeightedList() {
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			if (!adjNeighborMap.containsKey(x)) {
				adjNeighborMap.put(x, new ArrayList<Integer>());
			}
			if (!adjNeighborMap.containsKey(y)) {
				adjNeighborMap.put(y, new ArrayList<Integer>());
			}

			adjNeighborMap.get(x).add(y);
			adjNeighborMap.get(y).add(x);
		}
	}

	private static void populateList() {
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			int weight = list.get(i)[2];
			if (!adjMap.containsKey(x)) {
				adjMap.put(x, new ArrayList<List<Integer>>());
			}
			if (!adjMap.containsKey(y)) {
				adjMap.put(y, new ArrayList<List<Integer>>());
			}

			adjMap.get(x).add(Arrays.asList(y, weight));
			adjMap.get(y).add(Arrays.asList(x, weight));
		}
	}

	// 1 -> [[4, w1],[2, w2],[3, w3]]
	// 1 -> [] [4]
	// 1 -> [[4]] [4, w1]

	// 1 -> 4,2,3
	// 1,4 -> w1
	// 1,2 -> w2

	private static void populateMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			matrix[list.get(i)[0] - 1][list.get(i)[1] - 1] = list.get(i)[2];
			matrix[list.get(i)[1] - 1][list.get(i)[0] - 1] = list.get(i)[2]; // undirected
		}
	}

}