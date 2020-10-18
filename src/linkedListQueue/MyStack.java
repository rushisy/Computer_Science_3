package linkedListQueue;

public class MyStack implements StackADT {
	private Square[] stack;
	private int size;

	/**
	 * default constructor
	 */
	public MyStack() {
		size = -1; // default for empty
		stack = new Square[1];
	}

	/**
	 * preferred constructor
	 * 
	 * @param initCap the length of the size
	 */
	public MyStack(int initCap) {
		if (initCap > 1) {
			stack = new Square[initCap];
		} else {
			stack = new Square[1];
		}
	}

	/**
	 * checks if the array is empty or not
	 * 
	 * @return boolean true if empty else false
	 */
	public boolean isEmpty() {
		if (stack.length < 0) {
			return true;
		}
		return false;
	}

	/**
	 * outputs the last value of the array
	 * 
	 * @return Integer the last value of the array
	 */
	public Square peek() {
		if (size > -1) {
			return stack[size];
		}
		return null;

	}

	/**
	 * removes the top value
	 * 
	 * @return Integer the value that gets popped
	 */
	public Square pop() {
		int temp = size;
		size--;
		if (temp > -1)
			return stack[temp];
		return null;

	}

	/**
	 * outputs the element in the stack
	 * 
	 * @return Square the top element in the stack
	 */
	public void push(Square item) {
		if (size < stack.length + 1) {
			doubleCapacity();
			size++;
		}

		stack[size] = item;

	}

	/**
	 * helper method to double size of array
	 */
	private void doubleCapacity() {
		int length = stack.length + 1;
		Square[] temp = new Square[length];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = new Square[temp.length];
		stack = temp;
	}

	/**
	 * the array in the desired format
	 * 
	 * @return String output is in string format
	 */
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < stack.length; i++) {
			output += stack[i] + ", ";
		}
		return "[" + output + "]";
	}

	/**
	 * outputs the size of the stack
	 * 
	 * @return int the size of the stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * resets the stack
	 */
	@Override
	public void clear() {
		stack = new Square[1];
	}
}
