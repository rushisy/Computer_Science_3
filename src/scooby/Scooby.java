package scooby;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Scooby {
	private static String output;
	private static String[] array;
	private static String path;
	private static LinkedList<String>[] matrix;

	public static void main(String args[]) throws FileNotFoundException {
		Scanner key = new Scanner(new File("scooby.dat"));
		key.nextInt();
		key.nextLine();

		while (key.hasNextLine()) {
			array = key.nextLine().split(" ");
			path = key.nextLine();

			matrix = new LinkedList[array.length];
			for (int j = 0; j < array.length; j++) {
				matrix[j] = new LinkedList<String>();
				matrix[j].add(array[j]);
			}

			dfs(path.charAt(0), 0); // starting
			System.out.println(output);
		}
	}

	/**
	 * the actual depth first search
	 * 
	 * @param source    the current position to start looking from
	 * @param iteration the number of times at a given moment the dfs method is
	 *                  iterating
	 */
	public static void dfs(char source, int iteration) {
		try {
			if (matrix[iteration].toString().contains(path.charAt(1) + "")) {
				output = "yes";
			} else {
				for (int k = 0; k < matrix.length; k++) // iterating thru to find source to start next iteration
					if (matrix[k].toString().contains(source + ""))
						dfs(matrix[k].toString().charAt(0), ++iteration);
			}
		} catch (Exception e) {
			output = "no";
		}
	}
}
