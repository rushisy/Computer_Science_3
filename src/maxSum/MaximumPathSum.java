package maxSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class MaximumPathSum {
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void main(String args[]) throws FileNotFoundException {
		Scanner key = new Scanner(new File("triangle.txt"));

		while (key.hasNextLine()) {
			int[] array = Stream.of((key.nextLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
			ArrayList<Integer> line = new ArrayList<Integer>();

			for (int i = 0; i < array.length; i++)
				line.add(array[i]);
			list.add(line);
		}
		System.out.print(maxPathSum());
	}

	/**
	 * finds the max sum of the triangle by comparing with the each row and its
	 * adjacent cells.
	 * 
	 * @return int the maximum path of the triangle
	 */
	public static int maxPathSum() {
		ArrayList<Integer> path = list.get(list.size() - 1);
		for (int i = list.size() - 2; i >= 0; i--)
			for (int j = 0; j < list.get(i).size();)
				path.set(j, list.get(i).get(j) + Math.max(path.get(j), path.get(++j))); // max in row and current TB
		return path.get(0); // backwards
	}

}
