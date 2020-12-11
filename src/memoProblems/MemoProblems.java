package memoProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoProblems {
	public static HashMap<Integer, Integer> mapCoins = new HashMap<Integer, Integer>();
	public static int[] minCoins = { 0, 1 };
	public static Integer[][] numPaths;
	static Map<Pair, Integer> pascal = new HashMap<>();

	public static void main(String args[]) {
		try {
			mapCoins.put(0, 0);
			mapCoins.put(1, 1);
			printPascalRow(9);
			printPascalRow(40);

			System.out.println();

			System.out.println(numPaths(2, 4));
			System.out.println(numPaths(3, 4));
			System.out.println(numPaths(20, 12));

			System.out.println();

			minCoinsMap(11, new int[] { 9, 6, 5, 1 });
			minCoinsMap(1000, new int[] { 12, 8, 5, 2, 1 });

			System.out.println();

			minCoinsArray(11, new int[] { 9, 6, 5, 1 });
			minCoinsArray(1000, new int[] { 12, 8, 5, 2, 1 });

		} catch (Exception e) {

		}

	}

	/**
	 * triangle pascal memoized method
	 * 
	 * @param row the row of the obj
	 * @param col the col of the obj
	 * @return int the numbers of the row
	 */
	private static int pascal(int row, int col) {
		Pair obj = new Pair(row, col);
		if (col == 0 || col == row)
			return 1;
		else if (pascal.containsKey(obj)) {
			return pascal.get(obj);
		} else {
			int result = pascal(row - 1, col - 1) + pascal(row - 1, col);
			pascal.put(obj, result);
			return Math.abs(result);
		}
	}

	/**
	 * outputs in the desired format
	 * 
	 * @param n the row
	 */
	public static void printPascalRow(int n) {
		System.out.print("PASCAL -> printPascalRow(" + n + ") >>> ");
		for (int j = 0; j <= n; j++) {
			System.out.print(pascal(n, j) + " ");
		}
		System.out.println();
	}

	/**
	 * a memoized algo to return the paths between top left and bottom right
	 * 
	 * @param m the x for the x by y
	 * @param n the y for the x by y
	 * @return int the paths
	 */
	public static int numPaths(int m, int n) {
		System.out.print("NUMPATHS -> numPaths(new int[" + m + "][" + n + "]) >>> ");
		numPaths = new Integer[m][n];

		for (int down = 0; down < numPaths.length; down++) {
			numPaths[down][0] = 1;
			for (int right = 0; right < numPaths[down].length; right++)
				numPaths[0][right] = 1;
		}

		for (int i = 1; i < numPaths.length; i++)
			for (int j = 1; j < numPaths[i].length; j++)
				numPaths[i][j] = numPaths[i - 1][j] + numPaths[i][j - 1];
		return numPaths[m - 1][n - 1];
	}

	/**
	 * printer method for minimum coins map
	 * 
	 * @param total the quantity to reach
	 * @param coins the array to use coins from
	 */
	public static void minCoinsMap(int total, int[] coins) {
		System.out.println("MAP -> minCoinsMap(" + total + ", new int[]" + Arrays.toString(coins) + ") >>> "
				+ minCoinsMapHelper(total, coins));
	}

	/**
	 * outputs the minimum coins used to reach a total map
	 * 
	 * @param total the value to reach
	 * @param coins the coins to choose from
	 * @return int the number of coins used
	 */
	private static int minCoinsMapHelper(int total, int[] coins) {
		if (mapCoins.containsKey(total)) {
			return mapCoins.get(total);
		}
		int quantity = Integer.MAX_VALUE;
		int amount = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (total - coins[i] >= 0)
				amount = minCoinsMapHelper(total - coins[i], coins) + 1;
			if (amount < quantity)
				quantity = amount;
		}
		mapCoins.put(total, quantity);
		return quantity;
	}

	/**
	 * printer method for minimum coins array
	 * 
	 * @param total the quantity to reach
	 * @param coins the array to use coins from
	 */
	public static void minCoinsArray(int total, int[] coins) {
		minCoinsArrayHelper(total, coins);
		System.out.println("ARRAY -> minCoinsArray(" + total + ", new int[]" + Arrays.toString(coins) + ") >>> "
				+ minCoinsMapHelper(total, coins));
	}

	/**
	 * outputs the minimum coins used to reach a total array
	 * 
	 * @param total the value to reach
	 * @param coins the coins to choose from
	 * @return int the number of coins used
	 */
	private static int minCoinsArrayHelper(int total, int[] coins) {
		try {
			if (minCoins[total] != -1) {
				return minCoins[total];
			}
			int numCoins = Integer.MAX_VALUE;
			int coinVal = Integer.MAX_VALUE;
			for (int i = 0; i < coins.length; i++) {
				int r = total - coins[i];

				if (r >= 0) {
					coinVal = minCoinsArrayHelper(coinVal, coins) + 1;
				}
				if (coinVal < numCoins) {
					numCoins = coinVal;
				}
			}
			minCoins[total] = numCoins;
			return numCoins;
		} catch (Exception e) {
			return -1;
		}
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
