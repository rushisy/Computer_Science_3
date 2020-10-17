package myStack;

import java.util.EmptyStackException;

public class MyStack {
	private Integer[] stack;
	private int size;

	/**
	 * default constructor
	 */
	public MyStack() { // link this constructor to the one below
		stack = new Integer[1];
		size = 1;
	}

	/**
	 * preferred constructor
	 * 
	 * @param initCap the length of the size
	 */
	public MyStack(int initCap) {
		stack = new Integer[initCap];
		size = initCap;
	}

	/**
	 * checks if the array is empty or not
	 * 
	 * @return boolean true if empty else false
	 */
	public boolean isEmpty() {
		if (stack[0] == null || size == 0)
			return true;
		return false;
	}

	/**
	 * outputs the last value of the array
	 * 
	 * @return Integer the last value of the array
	 */
	public Integer peek() {
		if (isEmpty() == true) {
			throw new EmptyStackException();
		}
		return stack[size - 1];
	}

	/**
	 * removes the top value
	 * 
	 * @return Integer the value that gets popped
	 */
	public Integer pop() {

		Integer[] temp = new Integer[size]; // new
		if (isEmpty() == true) {
			throw new EmptyStackException();
		}

		int output = 0;
		int length = size - 1;
		for (int i = 0; i < stack.length; i++) {
			if (stack[length - i] != null) {
				output = stack[length - i]; // change
				break;
			}
		}

		for (int i = 0; i < size; i++) { // transfer
			temp[i] = stack[i];
		}

		size--;
		stack = new Integer[size]; // re-instantiate

		for (int i = 0; i < size; i++) { // switch again
			stack[i] = temp[i];
		}
		return output;

		/**
		 * int output = 0; // output int counter = 1; // length for new array
		 * 
		 * for (int i = 0; i < stack.length; i++) {
		 * 
		 * if (stack[i] != null) { counter++; output = stack[i]; } }
		 * 
		 * size = counter; Integer[] temp = new Integer[counter]; // new
		 * 
		 * for (int i = 0; i < temp.length - 1; i++) { temp[i] = stack[i]; }
		 * 
		 * stack = new Integer[counter];
		 * 
		 * for (int i = 0; i < stack.length - 1; i++) { stack[i] = temp[i]; }
		 * 
		 * return output;
		 **/
	}

	/**
	 * adds an item to the array
	 * 
	 * @param item the integer object to add
	 */
	public void push(Integer item) {
		for (int i = 0; i < stack.length; i++) { // checks first then add
			if (stack[i] == null) {
				stack[i] = item;
				return;
			}
		}

		doubleCapacity(); // size change
		for (int i = 0; i < stack.length; i++) { // add if not before
			if (stack[i] == null) {
				stack[i] = item;
				return;
			}
		}
	}

	/**
	 * helper method to double size of array
	 */
	private void doubleCapacity() {
		Integer[] temp = new Integer[size * 2]; // new

		for (int i = 0; i < stack.length; i++) { // switch current values
			temp[i] = stack[i];
		}

		stack = new Integer[temp.length]; // re-size current

		for (int i = 0; i < stack.length; i++) { // switch again
			stack[i] = temp[i];
		}
		size *= 2;
	}

	/**
	 * the array in the desired format
	 * 
	 * @return String output is in string format
	 */
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < stack.length - 1; i++) {
			output += stack[i] + ", ";
		}
		return "[" + output + stack[stack.length - 1] + "] <----- TOP";
	}

}
