package spanish2english;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SpanishToEnglish {
	private Map<String, String> pairs;

	public SpanishToEnglish() {
		pairs = new TreeMap<String, String>();
	}

	public void putEntry(String entry) {
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
	}

	public String translate(String sent) {
		List<String> list = Arrays.asList(sent.split(" "));
		String output = "";

		for (int i = 0; i < list.size(); i++)
			output += pairs.get(list.get(i)) + " ";

		return output;
	}

	public String toString() {
		return pairs.toString().replaceAll("\\,", "\n");
	}
}