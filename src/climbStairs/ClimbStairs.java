package climbStairs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClimbStairs {
	private static int[] staircase;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("steps.dat"));
		int num = key.nextInt();
		key.nextLine();
		for (int i = 0; i < num; i++) {
			staircase = new int[key.nextInt()];
			if (staircase.length > 1) {
				staircase[0] = 1;
				staircase[1] = 2;
				staircase[2] = 4;
				System.out.println(climbSteps(3));
				continue;
			}
			System.out.println(1);
		}
	}

	/**
	 * a recursive helper method to show the possible combinations of climbing the
	 * stairs
	 * 
	 * @param position the current iteration
	 */
	public static int climbSteps(int position) {
		if (position == staircase.length) {
			return staircase[staircase.length - 1];
		} else {
			staircase[position] = staircase[position - 3] + staircase[position - 2] + staircase[--position];
			return climbSteps(position + 2);
		}
	}
}
