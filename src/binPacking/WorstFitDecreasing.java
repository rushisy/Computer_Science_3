package binPacking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFitDecreasing {

	public static void main(String[] args) throws IOException {
		Scanner key = new Scanner(new File("input20.txt"));
		PriorityQueue<Disk> queue = new PriorityQueue<Disk>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Disk current = new Disk(0);
		int total = 0;
		int position = 1;

		while (key.hasNextLine()) {
			int value = key.nextInt();
			list.add(value);
			total += value;
		}

		Collections.sort(list);
		Collections.reverse(list);
		queue.add(current);

		for (int i = 0; i < list.size(); i++) {
			current = queue.poll();
			if (current.getTotal() - list.get(i) < 0) {
				queue.add(current);
				current = new Disk(position++);
			}
			current.add(list.get(i));
			queue.add(current);
		}

		System.out.println("Total size: " + (double) total / 1000000 + " GB");
		System.out.println("pDisk req'd = " + queue.size() + "\n");
		System.out.println("# Avail");

		while (!queue.isEmpty())
			System.out.println(queue.poll());
	}
}
