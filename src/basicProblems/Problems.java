package basicProblems;

import java.util.Arrays;
import java.util.List;

public class Problems {
	public static void main(String[] args) {
		int num = 4;
		System.out.println("climbStairs(" + num + "):\n");
		climbStairs(num);

		int x = 2;
		int y = 1;
		System.out.println("\n\ncampsite(" + x + ", " + y + "):\n");
		campsite(x, y);

		List<Integer> list = Arrays.asList(30, 2, 8, 22, 6, 4, 20);
		int limit = 19;
		System.out.println("getMax(" + list.toString() + ", " + limit + "):\n");
		System.out.println(getMax(list, limit));

		int quantity = 25;
		System.out.println("\nmakeChange(" + quantity + "):\n");
		System.out.println(makeChange(quantity));
		quantity = 100;
		System.out.println("\nmakeChange(" + quantity + "):\n");
		System.out.println(makeChange(quantity));
		quantity = 11;
		System.out.println("\nmakeChangeCoinCount(" + quantity + "):");
		System.out.println("\n P  N  D  Q");
		System.out.println("------------");
		makeChangeCoinCount(quantity);

		String a = "ABCDEFG";
		String b = "BGCEHAF";
		System.out.println("\nlongestCommonSub(" + a + ", " + b + "):\n");
		System.out.println(longestCommonSub(a, b));
	}

	/**
	 * shows all the possible combinations of climbing a number of stairs
	 * 
	 * @param steps the number of steps
	 */
	public static void climbStairs(int steps) {
		climbStairsHelper("", steps);
	}

	/**
	 * a recursive helper method to show the possible combinations of climbing the
	 * stairs
	 * 
	 * @param path  the path take to climb the stairs
	 * @param steps the number of steps left to take
	 */
	private static void climbStairsHelper(String path, int steps) {
		if (steps == 0)
			System.out.print(path);
		else if (steps == 1)
			System.out.print(path + 1);
		else {
			climbStairsHelper(path + "1, ", steps - 1);
			System.out.println();
			climbStairsHelper(path + "2, ", steps - 2);
		}
	}

	/**
	 * shows the number of ways to reach a point
	 * 
	 * @param x the x coordinate of the point
	 * @param y the y coordinate of the point
	 */
	public static void campsite(int x, int y) {
		campsiteHelper("", x, y, 0, 0);
	}

	/**
	 * a recursive helper method to find all the paths to the point
	 * 
	 * @param path     the current path taken
	 * @param x        the x coordinate of the final point
	 * @param y        the y coordinate of the final point
	 * @param currentX the current x coordinate
	 * @param currentY the current y coordinate
	 */
	private static void campsiteHelper(String path, int x, int y, int currentX, int currentY) {
		if (currentX == x && currentY == y) {
			System.out.print(path);
		} else if (currentX + 1 == x && currentY == y) {
			System.out.print(path + "E ");
		} else if (currentY + 1 == y && currentX == x) {
			System.out.print(path + "N ");
		} else if (currentX <= x && currentY <= y) {
			campsiteHelper(path + "E ", x, y, currentX + 1, currentY);
			System.out.println();
			campsiteHelper(path + "NE ", x, y, currentX + 1, currentY + 1); // its the same values but in different
																			// order -- did this for formating bcuz idk
																			// why it doesnt work with extra spaces
			System.out.println();
			campsiteHelper(path + "N ", x, y, currentX, currentY + 1);
		}
	}

	/**
	 * a recurisve method that outputs the maximum sum that can be generated of the
	 * elements in the list less than the limit
	 * 
	 * @param nums  the list of numbers to create the maximum sum
	 * @param limit the max number of the sum
	 * @return int the sum generated that is less than or equal to limit
	 */
	public static int getMax(List<Integer> nums, int limit) {
		if (nums.size() == 0)
			return 0;
		if (nums.get(0) > limit)
			return getMax(nums.subList(1, nums.size()), limit);
		return Math.max(nums.get(0) + getMax(nums.subList(1, nums.size()), limit - nums.get(0)),
				getMax(nums.subList(1, nums.size()), limit));
	}

	/**
	 * outputs the possible ways to make change for the amount inputed
	 * 
	 * @param amount the value to make the sum for
	 * @return int the value of possible ways to make change for the amount
	 */
	public static int makeChange(int amount) {
		return makeChangeHelper(new int[] { 1, 5, 10, 25 }, 4, amount);
	}

	/**
	 * recursive helper method to make different types of change
	 * 
	 * @param coins     the US coins to use to make change from
	 * @param remaining the number left
	 * @param amount    the amount needed to create
	 * @return int the possible ways
	 */
	private static int makeChangeHelper(int coins[], int remaining, int amount) {
		if (amount == 0)
			return 1;
		else if (amount <= 0 || remaining <= 0 && amount >= 1)
			return 0;
		else
			return makeChangeHelper(coins, remaining - 1, amount)
					+ makeChangeHelper(coins, remaining, amount - coins[remaining - 1]);
	}

	/**
	 * outputs the coins used to make the different types of combinations for the
	 * amount
	 * 
	 * @param amount the value of change to make
	 */
	public static void makeChangeCoinCount(int amount) {
		makeChangeCoinCountHelper(new int[4], new int[] { 1, 5, 10, 25 }, amount, 0, 0, 0, 0, 0, 0);
	}

	/**
	 * a recursive helper method to print the type of combinations for the amount
	 * 
	 * @param stack    the values used to make the amount
	 * @param coins    the coins used
	 * @param amount   the total amount to create up till
	 * @param total    the total money used so far
	 * @param position the type of coin used
	 * @param penny    coin worth one cent
	 * @param nickel   coin worth five cents
	 * @param dime     coin worth ten cents
	 * @param quarter  coin worth twenty five cents
	 */
	private static void makeChangeCoinCountHelper(int[] stack, int[] coins, int amount, int total, int position,
			int penny, int nickel, int dime, int quarter) {
		if (position == coins.length) {
			if (total == amount) {
				stack[0] = penny;
				stack[1] = nickel;
				stack[2] = dime;
				stack[3] = quarter;
				System.out.println(Arrays.toString(stack));
				stack = new int[4];
			}
		} else if (total <= amount) {
			makeChangeCoinCountHelper(stack, coins, amount, total, position + 1, penny, nickel, dime, quarter);
			if (coins[position] == 1)
				penny++;
			else if (coins[position] == 5)
				nickel++;
			else if (coins[position] == 10)
				dime++;
			else
				quarter++;
			makeChangeCoinCountHelper(stack, coins, amount, total + coins[position], position, penny, nickel, dime,
					quarter);
		}
	}

	/**
	 * recursive method to output the max continuous characters of both inputs
	 * 
	 * @param a the first String to compare with
	 * @param b the second String to compare with
	 * @return String the longest common substring
	 */
	public static String longestCommonSub(String a, String b) {
		try {
			if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1))
				return longestCommonSub(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1))
						+ a.charAt(a.length() - 1);
			else if (longestCommonSub(a, b.substring(0, b.length() - 1))
					.length() > longestCommonSub(a.substring(0, a.length() - 1), b).length())
				return longestCommonSub(a, b.substring(0, b.length() - 1));
			else
				return longestCommonSub(a.substring(0, a.length() - 1), b);
		} catch (Exception e) {
			return "";
		}

	}
}
