package thievery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Thievery {
	private static Integer[][] matrix;
	private static Integer[] weights;
	private static Integer[] values;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("Knapsack.dat"));

		scan.nextInt();
		scan.nextLine();

		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
			String[] line = scan.nextLine().split(" - ");
			int maxWeight = Integer.parseInt(line[1]);
			matrix = new Integer[Integer.parseInt(line[0])][Integer.parseInt(line[1]) + 1]; // value by weight
			scan.nextLine();
			weights = new Integer[matrix.length];
			values = new Integer[matrix.length];
			line = scan.nextLine().split(", ");
			for (int i = 0; i < matrix.length; i++) {
				weights[i] = Integer.parseInt(line[i]);
			}
			line = scan.nextLine().split(", ");
			for (int i = 0; i < matrix.length; i++) {
				values[i] = Integer.parseInt(line[i]);
			}

			System.out.println("Max Weight: " + maxWeight);
			System.out.println("Max Value: " + (knapsack(0, maxWeight)));
		}

	}

	/**
	 * preforms the 0/1 knapsack problem by dividing the problem into sub-problems
	 * 
	 * @param index    iteration we are currently on
	 * @param capacity the max quantity to fill remaining
	 * @return int the max value or max weight
	 */
	public static int knapsack(int index, int capacity) {
		if (capacity == 0 || index == weights.length) {
			return 0;
		} else if (matrix[index][capacity] == null) {
			int tempVal1 = -1;
			if (weights[index] <= capacity)
				tempVal1 = values[index] + knapsack(index + 1, capacity - weights[index]); // value then weight
			matrix[index][capacity] = Math.max(tempVal1, knapsack(index + 1, capacity)); // TE
			return matrix[index][capacity];
		}
		return matrix[index][capacity];
	}
}