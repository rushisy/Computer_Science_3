package binPacking;

import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private int total;
	private int position;

	public Disk(int size) {
		if (size == 0)
			return;
		list.add(size);
		total += size;
	}

	public void setPosition(int input) {
		position = input;
	}

	public int getPosition() {
		return position;
	}

	public int compareTo(Disk obj) {
		if (this.getTotal() == obj.getTotal())
			return 0;
		else if (this.getTotal() > obj.getTotal())
			return 1;
		return -1;
	}

	public void add(int input) {
		list.add(input);
		total += input;
	}

	public int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		String output = list.toString();
		return output.substring(1, output.length() - 1);
	}
}
