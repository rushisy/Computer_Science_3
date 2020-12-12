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
	public static int climbStairsHelper(int steps) {
		if (steps == 1 || steps == 0)
			return 1;
		else if (steps == 2)
			return 2;
		else
			return climbStairsHelper(steps - 3) + climbStairsHelper(steps - 2) + climbStairsHelper(steps - 1);

	}
}
