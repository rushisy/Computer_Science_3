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

	public static void climbStairs(int steps) {
		climbStairsHelper("", steps);
	}

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

	public static void campsite(int x, int y) {
		campsiteHelper("", x, y, 0, 0);
	}

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
			campsiteHelper(path + "NE ", x, y, currentX + 1, currentY + 1);
			System.out.println();
			campsiteHelper(path + "N ", x, y, currentX, currentY + 1);
		}
	}

	public static int getMax(List<Integer> nums, int limit) {
		if (nums.size() == 0)
			return 0;
		if (nums.get(0) > limit)
			return getMax(nums.subList(1, nums.size()), limit);
		return Math.max(nums.get(0) + getMax(nums.subList(1, nums.size()), limit - nums.get(0)),
				getMax(nums.subList(1, nums.size()), limit));
	}

	public static int makeChange(int amount) {
		return makeChangeHelper(new int[] { 1, 5, 10, 25 }, 4, amount);
	}

	private static int makeChangeHelper(int coins[], int remaining, int amount) {
		if (amount == 0)
			return 1;
		else if (amount < 0 || remaining <= 0 && amount >= 1)
			return 0;
		else
			return makeChangeHelper(coins, remaining - 1, amount)
					+ makeChangeHelper(coins, remaining, amount - coins[remaining - 1]);
	}

	public static void makeChangeCoinCount(int amount) {
		makeChangeCoinCountHelper(new int[4], new int[] { 1, 5, 10, 25 }, amount, 0, 0, 0, 0, 0, 0);
	}

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

	public static String longestCommonSub(String a, String b) {
		try {
			String aLast = "";
			String bLast = "";

			aLast = a.substring(0, a.length() - 1);
			bLast = b.substring(0, b.length() - 1);

			if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1))
				return longestCommonSub(aLast, bLast) + a.charAt(a.length() - 1);
			else if (longestCommonSub(a, bLast).length() > longestCommonSub(aLast, b).length())
				return longestCommonSub(a, bLast);
			else
				return longestCommonSub(aLast, b);
		} catch (Exception e) {
			return "";
		}

	}
}
