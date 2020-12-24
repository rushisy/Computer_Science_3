package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	private static ArrayList<int[]> list;
	private static HashMap<Integer, ArrayList<Integer>> adjMap;
	private static Queue<Integer> q;

	public static void main(String[] args) {
		adjMap = new HashMap<Integer, ArrayList<Integer>>();
		q = new LinkedList<Integer>();
		list = new ArrayList<int[]>();
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

		bfs();
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

	private static void bfs() {
		int source = 1;
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		q.add(source);
		while (!q.isEmpty()) {
			ArrayList<Integer> nList = adjMap.get(source);
			result.add(source);
			for (int i = 0; i < nList.size(); i++) {
				if (!visited.contains(nList.get(i))) {
					q.add(nList.get(i));
					visited.add(nList.get(i));
				} else
					nList.remove(i);
			}
			source = nList.get(0);
			q.remove();
		}

		System.out.println(result.toString());
	}
}
