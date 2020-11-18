package binPacking;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFit {
	public static void main(String[] args) throws IOException {
		Scanner key = new Scanner(new File("input20.txt"));
		PriorityQueue<Disk> queue = new PriorityQueue<Disk>();
		Disk current = new Disk(0);
		int position = 1;
		int total = 0;

		queue.add(current);
		while (key.hasNextLine()) {
			int line = key.nextInt();
			current = queue.poll();

			if (current.getTotal() - line < 0) {
				Disk newDisk = new Disk(position++);
				newDisk.add(line);
				queue.add(newDisk);
			} else
				current.add(line);
			queue.add(current);
			total += line;
		}

		System.out.println("Total size: " + (double) total / 1000000 + " GB");
		System.out.println("Disks req'd = " + queue.size() + "\n");
		System.out.println("# Avail");

		while (!queue.isEmpty())
			System.out.println(queue.poll());
	}
}
