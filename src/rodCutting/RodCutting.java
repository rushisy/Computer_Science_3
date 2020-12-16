package rodCutting;

import java.util.ArrayList;

public class RodCutting {
	private static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String args[]) {

		Integer[] array = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };

		for (Integer number : array)
			list.add(number);

		rods();
	}

	public static void rods() {
		System.out.print("Max value for rod of length ");
		if (list.size() > 0 && list.contains((Integer) 0)) { // length zero will always give us zero dollars
			list.remove((Integer) 0); // type cast for recognition of object not index
		}
		System.out.print(list.size() + " -> ");
		int cuts[] = new int[list.size() + 1];

		for (int i = 1; i <= list.size(); i++) { // no negatives
			int rn = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				rn = Math.max(rn, list.get(j) + cuts[i - j - 1]); // keeping max from previous iteration of Rn
			cuts[i] = rn;
		}

		System.out.print(cuts[cuts.length - 1]);
	}
}
