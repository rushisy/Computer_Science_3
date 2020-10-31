package spanish2english;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SpanishToEnglish {
	private Map<String, String> pairs;

	/**
	 * default constructor
	 */
	public SpanishToEnglish() {
		pairs = new TreeMap<String, String>();
	}

	/**
	 * adds the string to the map
	 * 
	 * @param entry the pair to add
	 */
	public void putEntry(String entry) {
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
	}

	/**
	 * translates text from spanish to english
	 * 
	 * @param sent spanish text
	 * @return String english text
	 */
	public String translate(String sent) {
		List<String> list = Arrays.asList(sent.split(" "));
		String output = "";

		for (int i = 0; i < list.size(); i++)
			output += pairs.get(list.get(i)) + " ";

		return output;
	}

	/**
	 * outputs the spanish text in english
	 * 
	 * @return String the sentence in english
	 */
	public String toString() {
		return pairs.toString().replaceAll("\\,", "\n");
	}
}