package examples;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue101 {

	public static void main(String[] args) {
		Queue<Integer> pQueue = new PriorityQueue<Integer>();

		pQueue.add(2);
		pQueue.add(3);
		pQueue.add(6);
		pQueue.add(1);
		pQueue.add(8);
		pQueue.add(4);
		pQueue.add(5);
		pQueue.add(9);

		System.out.println("Head: " + pQueue.peek());
		System.out.println("Head: " + pQueue.element() + "\n");

		System.out.println(pQueue);

		for (Integer num : pQueue)
			System.out.print(num + " ");

		System.out.println();

		while (!pQueue.isEmpty())
			System.out.println(pQueue.poll() + " ");
	}
}
