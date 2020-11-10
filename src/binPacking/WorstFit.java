package binPacking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFit {
	public static void main(String[] args) throws FileNotFoundException {
		PriorityQueue<Disk> queue = new PriorityQueue<Disk>();
		Scanner key = new Scanner(new File("input20.txt"));
		int total = 0;
		int position = 0;
		Disk current = new Disk(0);

		while (key.hasNextInt()) {
			int line = key.nextInt();
			total += line;
			if (queue.isEmpty()) {
				current.add(line);
				queue.add(current);
			} else if (current.getTotal() + line < 1000000) {
				current.add(line);
			} else {
				queue.add(current);
				current = new Disk(line);
				position++;
			}
			current.setPosition(position);
		}
		current.setPosition(position);

		int size = queue.size();
		System.out.println("Total Size = " + ((double) total / 1000000) + "GB");
		System.out.println("Disks req'd = " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(queue.peek().getPosition() + " " + (1000000 - queue.peek().getTotal()) + ": "
					+ queue.peek().toString());
			queue.remove();
		}
	}
}
