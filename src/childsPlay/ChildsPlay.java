package childsPlay;

import java.util.*;
import java.io.*;

public class ChildsPlay {
	private static ArrayList<Integer>[] matrix;
	private static boolean[] visited;
	private static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String args[]) throws IOException {
		try {
			Scanner key = new Scanner(new File("play.dat"));
			key.nextInt();
			while (key.hasNextLine()) {
				int occurances = key.nextInt();
				visited = new boolean[occurances];
				key.nextInt();

				matrix = new ArrayList[occurances];
				for (int i = 0; i < occurances; i++) // default initialization
					matrix[i] = new ArrayList<Integer>();

				for (int i = 1; i < occurances; i++) { // fallen dominoes?
					matrix[key.nextInt()].add(key.nextInt());
					if (!visited[i]) {
						visited[i] = true;
						dfs(i);
					}
				}

				visited = new boolean[occurances]; // resets the grid
				int output = 0;
				while (!stack.isEmpty()) { // repeats the dfs
					int poped = stack.pop();
					if (!visited[poped]) {
						output++;
						visited[poped] = true;
						dfs(poped);
					}
				}
				System.out.println(output);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * the actual depth first search
	 * 
	 * @param position the specific row to search in
	 */
	public static void dfs(int position) {
		for (Integer v : matrix[position])
			if (!visited[v]) {
				visited[v] = true;
				dfs(v);
			}
		stack.push(position);
	}
}
