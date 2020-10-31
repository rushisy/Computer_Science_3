package histogram;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Histogram {
	private Map<String, Integer> histogram;

	/**
	 * default constructor
	 */
	public Histogram() {
		histogram = new TreeMap<String, Integer>();
	}

	/**
	 * preferred constructor
	 * 
	 * @param sent value of the sentence
	 */
	public Histogram(String sent) {
		histogram = new TreeMap<String, Integer>();
		setSentence(sent);
	}

	/**
	 * adds the sentence to the map
	 * 
	 * @param sentence the variable to add to the map
	 */
	public void setSentence(String sentence) {
		for (String item : sentence.split(" ")) {
			if (histogram.get(item) == null)
				histogram.put(item, 1);
			else
				histogram.put(item, histogram.get(item) + 1);
		}
	}

	/**
	 * outputs the map in the desired format
	 * 
	 * @return String the map
	 */
	public String toString() {
		String output = "char    1---5----10\n";
		Iterator<String> iterator = histogram.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String stars = "";

			for (int i = 0; i < histogram.get(key); i++) {
				stars += "*";
			}

			output += key + "       " + stars + "\n";
		}

		return output;
	}
}