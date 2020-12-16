package minCoins;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class MinimumCoins {
	private static int value;
	private static int[] array;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("coins.dat"));
		int iterations = key.nextInt();
		for (int i = 0; i < iterations; i++) {
			value = key.nextInt();
			array = Stream.of((key.next() + key.nextLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
			if (minCoins() == Integer.MAX_VALUE) // highest value and is impossible to reach
				System.out.println("Not possible with the given denominations\n");
			else
				System.out.println(minCoins() + " coins\n");
		}
	}

	/**
	 * Fetches and compares with previous item in array to find the least amount of
	 * coins needed to reach the value inputed; however, if the value is unreachable
	 * then it will say so. Makes sure the combination is the least by comparing
	 * with max value-- regular substitution method.
	 * 
	 * @return int the least possible way to make a value
	 */
	public static int minCoins() {
		int table[] = new int[value + 1];

		for (int i = 1; i < table.length; i++) {
			table[i] = Integer.MAX_VALUE;
			for (int j = 0; j < array.length; j++)
				if (array[j] <= i && table[i - array[j]] != Integer.MAX_VALUE && table[i - array[j]] + 1 < table[i])
					table[i] = table[i - array[j]] + 1;
		}
		return table[value];

	}
}
