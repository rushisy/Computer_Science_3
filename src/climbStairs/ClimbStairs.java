package climbStairs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClimbStairs {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("steps.dat"));
		int iterations = key.nextInt();
		for (int i = 0; i < iterations; i++) {
			System.out.println(climbStairsHelper(key.nextInt()));
		}
	}

	/**
	 * a recursive helper method to show the possible combinations of climbing the
	 * stairs
	 * 
	 * @param steps the number of steps left to take
	 */
	public static int climbStairsHelper(int n) {
		if (n == 1 || n == 0)
			return 1;
		else if (n == 2)
			return 2;

		else
			return climbStairsHelper(n - 3) + climbStairsHelper(n - 2) + climbStairsHelper(n - 1);

	}
}
