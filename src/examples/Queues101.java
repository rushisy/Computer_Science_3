package examples;

import java.util.LinkedList;
import java.util.Queue;

public class Queues101 {
	public static void main(String[] args) {

		// A queue is an interface
		Queue<Integer> queue;

		// LinkedList implements the queue interface (ie a queue reference to a linked
		// list)**on test**
		queue = new LinkedList<Integer>();

		// Elements are added at the tail (back) of the queue
		// To add an element is to "enqueue" it
		queue.add(42);
		queue.add(23);
		queue.add(90);
		queue.add(13);
		queue.add(21);

		System.out.println(queue);

		// Removing elements in a first in first out (FIFO) order
		// The remove method returns the element that was removed which is to "dequeue"
		queue.remove();

		System.out.println(queue);

		queue.remove();
		queue.remove();

		queue.add(1);

		System.out.println(queue);
	}
}
