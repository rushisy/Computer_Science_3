package memoProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoProblems {
	private static Map<Pair, Integer> memo = new HashMap<>();
	private static Integer[][] memo2;
	private static int[] memo3;

	public static void main(String[] args) {
		printPascalRow(9);
		printPascalRow(40);

		System.out.println();
		System.out.println(numPaths(2, 4));
		System.out.println(numPaths(3, 4));
		System.out.println(numPaths(20, 12));
		System.out.println();

		System.out.println(minCoinsArray(1, new int[] { 12, 8, 5, 2, 1 }));

	}

	public static int minCoinsArray(int total, int[] coins) {
		memo3 = new int[total + 1];
		for (int i = 2; i < total + 1; i++) {
			memo3[i] = -1;
		}
		minCoinsArrayHelper(total, coins);
		return memo3[total];
	}

	private static int minCoinsArrayHelper(int total, int[] coins) {
		if (memo3[total] != -1) {
			return memo3[total];
		}
		int minCoinsNeeded = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int result = total - coins[i];
			int val = Integer.MAX_VALUE;
			if (result >= 0) {
				val = minCoinsArrayHelper(result, coins) + 1;
			}
			if (val < minCoinsNeeded) {
				minCoinsNeeded = val;
			}
		}
		memo3[total] = minCoinsNeeded;
		return minCoinsNeeded;
	}

	public static int numPaths(int m, int n) {
		System.out.print("numPaths(new int[" + m + "][" + n + "]): ");
		memo2 = new Integer[m][n];
		for (int right = 0; right < memo2[0].length; right++)
			memo2[0][right] = 1;

		for (int down = 0; down < memo2.length; down++)
			memo2[down][0] = 1;

		for (int i = 1; i < memo2.length; i++)
			for (int j = 1; j < memo2[i].length; j++)
				memo2[i][j] = memo2[i - 1][j] + memo2[i][j - 1];
		return memo2[m - 1][n - 1];
	}

	private static int pascal(int row, int col) {
		Pair obj = new Pair(row, col);
		if (col == 0 || col == row)
			return 1;
		else if (memo.containsKey(obj)) {
			return memo.get(obj);
		} else {
			int result = pascal(row - 1, col - 1) + pascal(row - 1, col);
			memo.put(obj, result);
			return Math.abs(result);
		}
	}

	public static void printPascalRow(int n) {
		System.out.print("printPascalRow(" + n + "): ");
		for (int j = 0; j <= n; j++) {
			System.out.print(pascal(n, j) + " ");
		}
		System.out.println();
	}
}

class Pair {
	public List<Integer> list;

	public Pair(int row, int col) {
		list = new ArrayList<Integer>();
		list.add(row);
		list.add(col);
	}

	@Override
	public boolean equals(Object pair) {
		Pair obj = (Pair) pair;
		return this.list.contains(obj.list.get(0)) && this.list.contains(obj.list.get(1));
	}

	@Override
	public int hashCode() {
		return (list.get(0) - list.get(1)) % 10;
	}

	@Override
	public String toString() {
		return list.get(0) + " " + list.get(1);
	}
}
