package examples;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Maps103 {
	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String line = "dog1cat2pig3dog1cat2pig7dog3dog6cat8dog4pig";
		for (String item : line.split("\\d+")) {
			if (map.get(item) == null)
				map.put(item, 1);
			else
				map.put(item, map.get(item) + 1);
		}

		for (String key : map.keySet()) {
			System.out.print(key + "\t");
		}
		System.out.println();
		for (Integer value : map.values()) {
			System.out.print(value + "\t");
		}
		
		System.out.println();

		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " - " + map.get(key));
		}
	}
}
