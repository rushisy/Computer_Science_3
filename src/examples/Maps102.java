package examples;

import java.util.Map;
import java.util.TreeMap;

public class Maps102 {
	public static void main(String[] args) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		String line = "hawk pride never dies";

		for (char c : line.toCharArray()) {
			if (map.get(c) == null)
				map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}

		System.out.println(map);

		Map<Character, Integer> map1 = new TreeMap<Character, Integer>();

		for (char c : line.toCharArray()) {
			if (!map1.containsKey(c))
				map1.put(c, 0);
			map1.put(c, map1.get(c) + 1);
		}
		
		System.out.println(map);
	}
}
