package countPaths;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountPaths {
	private static int[][] matrix;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("paths.dat"));
		int iterations = key.nextInt();
		key.nextLine();
		for (int i = 0; i < iterations; i++) {
			try {
				matrix = new int[key.nextInt()][key.nextInt()];
				numberOfPaths(0, 0);
				System.out.println(matrix[matrix.length - 1][matrix[0].length - 1]);
			} catch (Exception e) {
				System.out.println("error"); // starting cell = ending cell or not matrix
			}

		}
	}

	/**
	 * outputs number of paths from starting cell to ending cell
	 * 
	 * @param row the current row
	 * @param col the current column
	 */
	public static void numberOfPaths(int row, int col) {
		if (row == 0 || col == 0)
			matrix[row][col] = 1;
		else
			matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1] + matrix[row - 1][col - 1];
		if (row >= 0 && row < matrix.length - 1) {
			numberOfPaths(row + 1, col);
		}
		if (col >= 0 && col < matrix[0].length - 1) {
			numberOfPaths(row, col + 1);
		}
		if (row >= 0 && row < matrix.length - 1 && col >= 0 && col < matrix[0].length - 1) {
			numberOfPaths(row + 1, col + 1);
		}
	}
}
