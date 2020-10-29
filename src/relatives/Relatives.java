package relatives;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives {
	private Map<String, Set<String>> map;

	public Relatives() {
		map = new TreeMap<String, Set<String>>();
	}

	public void setPersonRelative(String line) {
		String[] personRelative = line.split(" ");
		Set<String> set = new TreeSet<String>();

		if (map.containsKey(personRelative[0]))
			set = map.get(personRelative[0]);

		set.add(personRelative[1]);
		map.put(personRelative[0], set);

	}

	public String getRelatives(String person) {
		return person + " is related to "
				+ map.get(person).toString().substring(1, map.get(person).toString().length() - 1) + "\n";
	}

	public String toString() {
		String output = "";
		for (String item : map.keySet())
			output += getRelatives(item);
		return output;
	}
}