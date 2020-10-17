package evensFirst;

import java.util.LinkedList;
import java.util.Queue;

public class EvensFirst {

	/**
	 * outputs the separated queue
	 * 
	 * @param nums the mixed queue
	 * @return the separated the queue
	 */
	public Queue<Integer> putEvensFirst(Queue<Integer> nums) {
		Queue<Integer> alpha = new LinkedList<Integer>(); // evens
		Queue<Integer> beta = new LinkedList<Integer>(); // odds
		int size = nums.size(); // i have no clue why i cant do nums.size (ask stites)

		for (int i = 0; i < size; i++) {
			if (nums.peek() % 2 == 0) { // seperate the values into the two queues
				alpha.add(nums.peek());
			} else {
				beta.add(nums.peek());
			}
			nums.remove(nums.peek());
		}

		nums = alpha; // add evens
		size = beta.size(); // i have no clue why i cant do beta.size (ask stites)

		for (int i = 0; i < size; i++) { // add odds
			nums.add(beta.poll());
		}

		return nums;

	}
}
