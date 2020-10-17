package examples;

import java.util.LinkedList;
import java.util.Queue;

public class Queues102 {
	public static void main(String[] args) {
		Queue<String> names = new LinkedList<String>();

		names.add("David");
		names.add("Nick");
		System.out.println(names.add("Raymond"));
		System.out.println(names.add("Nhat-The"));
		System.out.println(names.add("Ari!!!"));

		System.out.println("\nNumber of elements: " + names.size());

		System.out.println("\nPrinting queue with loop: ");

		/**
		 * Cannot use a basic for loop because there is not get() method in the Queue
		 * Interface for(int i = 0; i < names.size(); i++) { System.out.println(i + ". "
		 * + names.; }
		 */

		for (String name : names) {
			System.out.println("" + name);
		}

		// peek() will return the element at the front of the queue but won't remove it
		System.out.println("\nThe element at the front of the queue (index 0) is: " + names.peek());

		// isEmpty() returns true if there is nothing in the queue
		System.out.println("-* Dequeuing until (isEmpty() == true) *-\n");

		while (!names.isEmpty()) {
			System.out.println(
					"Removing " + names.remove() + " from head of the queue. \nEmpty Queue: " + names.isEmpty() + "\n");
		}

		System.out.println("\n" + names + "\n");

		// peek() returns null if this queue is empty.
		System.out.println("\nThe element at the front of the queue (index 0) is: " + names.peek());

		// remove() trhows an exception if the queue is empty
		// names.remove();
	}

}