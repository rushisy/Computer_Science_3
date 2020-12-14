package bottles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bottles {
	private static int[] bestCase;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("bottles.dat"));
		int iterations = key.nextInt();
		key.nextLine();
		for (int i = 0; i < iterations; i++) {
			String[] numbers = key.nextLine().split(" ");
			bestCase = new int[numbers.length];
			bestCase[0] = Integer.parseInt(numbers[1]);
			bestCase[1] = Math.max(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));

			ArrayList<Integer> bottles = new ArrayList<Integer>();
			for (int j = 1; j < numbers.length; j++)
				bottles.add(Integer.parseInt(numbers[j]));
			System.out.println(bottles(bottles, 2)); // skip iteration one bcuz of first number in each line
														// of dat file
		}
	}

	/**
	 * outputs the max value that follows the guidelines
	 * 
	 * @param list     list of all the values
	 * @param position the current iteration
	 * @return int the max value
	 */
	public static int bottles(ArrayList<Integer> list, int position) {
		if (position == list.size()) {
			return bestCase[list.size() - 1];
		} else {
			bestCase[position] = Math.max(bestCase[position - 2] + list.get(position), bestCase[--position]);
			return bottles(list, position + 2); // compromise from previous minus one
		}
	}
}
