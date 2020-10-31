package relatives;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives {
	private Map<String, Set<String>> map;

	/**
	 * default constructor
	 */
	public Relatives() {
		map = new TreeMap<String, Set<String>>();
	}

	/**
	 * adds the relatives to the map
	 * 
	 * @param line person to add
	 */
	public void setPersonRelative(String line) {
		String[] personRelative = line.split(" ");
		Set<String> set = new TreeSet<String>();

		if (map.containsKey(personRelative[0]))
			set = map.get(personRelative[0]);

		set.add(personRelative[1]);
		map.put(personRelative[0], set);

	}

	/**
	 * outputs the relatives of the input
	 * 
	 * @param person the input to find relatives of
	 * @return String the relatives of the person
	 */
	public String getRelatives(String person) {
		return person + " is related to "
				+ map.get(person).toString().substring(1, map.get(person).toString().length() - 1) + "\n";
	}

	/**
	 * outputs the map in the desired format
	 * 
	 * @return String the map
	 */
	public String toString() {
		String output = "";
		for (String item : map.keySet())
			output += getRelatives(item);
		return output;
	}
}