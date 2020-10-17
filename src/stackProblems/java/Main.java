package stackProblems.java;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		StackProbs obj = new StackProbs();

		int[] nums = { 1, 3, 5, 0, -1 };
		System.out.println("(1, 3, 5, 0, -1) >>> " + obj.doubleUp(makeStack(nums)));

		int[] nums1 = { 2, 9, -4, 3, -1, 0, -6 };
		System.out.println("(2, 9, -4, 3, -1, 0, -6) >>> " + obj.posAndNeg(makeStack(nums1)));

		int[] nums2 = { 7, 23, -7, 0, 22, -8, 4, 5 };
		System.out.println("(7, 23, -7, 0, 22, -8, 4, 5) >>> " + obj.shiftByN(makeStack(nums2), 3));

		System.out.println("\"hello how are you\" >>> " + obj.reverseVowels("hello how are you"));
	}

	/**
	 * converts an array into a stack
	 * 
	 * @param nums an array of integers
	 * @return Stack<Integer> the version of the stack with integers
	 */
	public static Stack<Integer> makeStack(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			stack.push(num);
		}
		return stack;
	}
}