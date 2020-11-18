package binPacking;

import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
	private ArrayList<Integer> list;
	private int position;
	private int total;

	public Disk(int position) {
		total = 1000000;
		list = new ArrayList<Integer>();
		this.position = position;
	}

	public int add(int input) {
		list.add(input);
		return total -= input;
	}

	public int getTotal() {
		return total;
	}

	@Override
	public int compareTo(Disk obj) {
		if (total == obj.total) {
			return 0;
		} else if (total > obj.total)
			return -1;
		return 1;
	}

	@Override
	public String toString() {
		return position + " " + total + ": "
				+ list.toString().substring(1, list.toString().length() - 1).replaceAll(",", "");
	}
}
