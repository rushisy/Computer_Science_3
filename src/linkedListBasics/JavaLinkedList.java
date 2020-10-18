package linkedListBasics;

import java.util.LinkedList;
import static java.lang.System.*;

public class JavaLinkedList {
	private LinkedList<Integer> list;

	/**
	 * default constructor
	 */
	public JavaLinkedList() {
		list = new LinkedList<Integer>();
	}

	/**
	 * preferred constructor
	 * 
	 * @param nums the array to translate into the list
	 */
	public JavaLinkedList(int[] nums) {
		list = new LinkedList<Integer>();
		for (int num : nums) {
			list.add(num);
		}
	}

	/**
	 * adds the numbers in the list
	 * 
	 * @return double the total sum
	 */
	public double getSum() {
		double total = 0;
		for (int num : list) {
			total += num;
		}
		return total;
	}

	/**
	 * returns the average of the list
	 * 
	 * @return double the sum divided by the size of the list
	 */
	public double getAvg() {
		return getSum() / list.size();
	}

	/**
	 * the largest number on the list
	 * 
	 * @return int the largest number
	 */
	public int getLargest() {
		int largest = Integer.MIN_VALUE;
		for (int num : list) {
			if (num > largest)
				largest = num;
		}
		return largest;
	}

	/**
	 * the smallest number on the list
	 * 
	 * @return int the smallest number
	 */
	public int getSmallest() {
		int smallest = Integer.MAX_VALUE;
		for (int num : list) {
			if (num < smallest)
				smallest = num;
		}
		return smallest;
	}

	/**
	 * string representation of everything
	 * 
	 * @return String the preferred formatting of the data
	 */
	public String toString() {
		return "SUM :: " + getSum() + "\nAVERAGE :: " + getAvg() + "\nSMALLEST :: " + getSmallest() + "\nLARGEST :: "
				+ getLargest() + "\n";
	}
}