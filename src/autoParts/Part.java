package autoParts;

public class Part implements Comparable<Part> {
	private String make, mode, rest;
	private int year;

	public Part(String line) {
		String[] list = line.split(" ");
		make = list[0];
		mode = list[1];
		year = Integer.parseInt(list[2]);

		rest = "";
		for (int i = 3; i < list.length; i++) {
			rest += list[i] + " ";
		}
	}

	public int compareTo(Part rhs) {
		String currentCompare = make + mode + year + rest;
		String inputCompare = rhs.make + rhs.mode + rhs.year + rhs.rest;
		return currentCompare.compareTo(inputCompare);
	}

	public String toString() {
		return make + " " + mode + " " + year + " " + rest;
	}
}