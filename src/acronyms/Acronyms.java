package acronyms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Acronyms {
	private Map<String, String> acronymTable;

	public Acronyms() {
		acronymTable = new TreeMap<String, String>();
	}

	public void putEntry(String entry) {
		String[] list = entry.split(" - ");
		acronymTable.put(list[0], list[1]);
	}

	public String convert(String sent) {
		List<String> list = Arrays.asList(sent.split(" "));

		for(int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i).trim());
		}
		
		String output = "";

		for (int i = 0; i < list.size(); i++)
			if (acronymTable.get(list.get(i)) != null)
				output += acronymTable.get(list.get(i)) + " ";
			else if (list.get(i).contains("HD")) {
				output += acronymTable.get("HD") + ". ";
			} else if (list.get(i).contains("FG")) {
				output += acronymTable.get("FG") + ". ";
			} else
				output += list.get(i) + " ";

		return output;

	}

	public String toString() {
		String output = "";

		for (String item : acronymTable.keySet())
			output += item + " - " + acronymTable.get(item) + "\n";

		return "====    MAP CONTENTS    ====\n\n" + output + "\n\n====    READ LINES      ====\n\n";
	}
}