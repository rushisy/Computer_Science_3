package stackProblems.java;

import java.util.*;

public class StackProbs {
	/**
	 * returns a doubled version of the stack
	 * 
	 * @param nums a stack of integers
	 * @return Stack<Integer> the doubled version of the stack
	 */
	public Stack<Integer> doubleUp(Stack<Integer> nums) {
		Stack<Integer> output = new Stack<Integer>();
		for (int i = 0; i < nums.size(); i++) {
			output.push(nums.get(i));
			output.push(nums.get(i));
		}
		return output;
	}

	/**
	 * returns a seperated version of the stack
	 * 
	 * @param nums a stack of integers
	 * @return Stack<Integer> the seperated version of the stack
	 */
	public Stack<Integer> posAndNeg(Stack<Integer> nums) {

		Stack<Integer> output = new Stack<Integer>();

		while (!nums.isEmpty()) {
			int value = nums.pop();
			while (!output.isEmpty() && output.peek() > value) {
				nums.push(output.pop());
			}
			output.push(value);
		}
		return output;
	}

	/**
	 * returns a shifted version of the stack
	 * 
	 * @param nums a stack of integers
	 * @param n    the integer to shift by
	 * @return Stack<Integer> the shifted version of the stack
	 */
	public Stack<Integer> shiftByN(Stack<Integer> nums, int n) {
		for (int i = 0; i < n; i++) {
			int temp = nums.get(0);
			for (int j = 0; j < nums.size() - 1; j++) {
				nums.set(j, nums.get(j + 1));
			}
			nums.set(nums.size() - 1, temp);
		}

		return nums;
	}

	/**
	 * returns a reversed vowels version of the string
	 * 
	 * @param str the string of letters
	 * @return String the changed version of the string
	 */
	public String reverseVowels(String str) {
		Stack<Character> output = new Stack<Character>();
		int left = 0;
		output.setSize(str.length());
		int right = output.size()-1;
		
		for (int i = 0; i < str.length(); i++) {
			output.set(i, str.charAt(i));
		}

		while (left < right || left == right) {

			if ((str.charAt(left) == 'a' || str.charAt(left) == 'e' || str.charAt(left) == 'i'
					|| str.charAt(left) == 'o' || str.charAt(left) == 'u')
					&& (str.charAt(right) == 'a' || str.charAt(right) == 'e' || str.charAt(right) == 'i'
							|| str.charAt(right) == 'o' || str.charAt(right) == 'u')) {
				char temp = str.charAt(left);
				output.set(left, str.charAt(right));
				output.set(right, temp);
				left++;
				right--;
			} else if (str.charAt(left) == 'a' || str.charAt(left) == 'e' || str.charAt(left) == 'i'
					|| str.charAt(left) == 'o' || str.charAt(left) == 'u') {
				right--;
			} else if (str.charAt(right) == 'a' || str.charAt(right) == 'e' || str.charAt(right) == 'i'
					|| str.charAt(right) == 'o' || str.charAt(right) == 'u') {
				left++;
			} else {
				left++;
				right--;
			}
		}
		String sup = "";
		for (int i = 0; i < output.size(); i++) {
			sup += output.get(i);
		}
		return sup;
	}
}