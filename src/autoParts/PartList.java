package autoParts;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class PartList {
	private TreeMap<Part, Integer> partsMap;

	public PartList() {
		partsMap = new TreeMap<Part, Integer>();
	}

	public PartList(String fileName) {
		this();
		try {
			Scanner scan = new Scanner(new File(fileName));

			while (scan.hasNext()) {
				String[] list = scan.nextLine().split(" ");
				Part part = null;

				if (list.length == 6) {
					part = new Part(
							list[3] + " " + list[4] + " " + list[5] + " " + list[0] + " " + list[1] + " " + list[2]);
				} else {
					part = new Part(list[2] + " " + list[3] + " " + list[4] + " " + list[0] + " " + list[1]);
				}

				if (partsMap.containsKey(part))
					partsMap.put(part, partsMap.get(part) + 1);
				else
					partsMap.put(part, 1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String toString() {
		String output = "";
		for (Part part : partsMap.keySet())
			output += part.toString() + "- " + partsMap.get(part) + "\n";
		return output.toString();
	}
}