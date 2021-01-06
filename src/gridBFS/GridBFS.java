package gridBFS;

import java.util.LinkedList;
import java.util.Queue;

public class GridBFS {
	private static int r;
	private static int c;
	private static int x;
	private static int y;
	private static int[][] matrix;

	public static void main(String[] args) {
		r = 5;
		c = 5;
		x = 2;
		y = 2;
		matrix = new int[r][c];

		populate(x, y);
	}

	public static void populate(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] popped = q.remove();
			for (int i = 0; i < dir.length; i++) {
				int dx = popped[0] + dir[i][0];
				int dy = popped[1] + dir[i][1];

				if (dx >= r || dy >= c || dx < 0 || dy < 0)
					continue;

				if (matrix[dx][dy] == 0) {
					matrix[dx][dy] = matrix[popped[0]][popped[1]] + 1;
					q.add(new int[] { dx, dy });
				}
			}
		}
		matrix[x][y] = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				max = Math.max(max, matrix[i][j]);
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (max == matrix[i][j])
					System.out.print("(" + i + ", " + j + ") ");
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * x,y = 2,2
	 * 
	 * 1,1 2,1 3,1 3,2 3,3 0,0 0,1
	 */
}
