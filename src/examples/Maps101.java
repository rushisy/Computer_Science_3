package examples;

import java.util.Map;
import java.util.TreeMap;

public class Maps101 {
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "Raymond");
		map.put(11, "Michael");
		map.put(8, "David");
		map.put(3, "Numair");
		map.put(5, "Chloe");

		System.out.println("Map: " + map + "\n");

		System.out.println("Element @ key 1: " + map.get(1));
		System.out.println("Element @ key 5: " + map.get(5));
		System.out.println("Element @ key 2: " + map.get(2));
		System.out.println("Element @ key 99: " + map.get(99) + "\n");

		System.out.println(map.put(2, "Rushi"));
		System.out.println(map.put(3, "Nat-The")); // printing put method returns whatever was present before
		System.out.println("Map: " + map
				+ "\n\n\\****************************************************************************\\\n");

		Map<Integer, String> map1 = new TreeMap<Integer, String>();
		map1.put(1, "Raymond");
		map1.put(11, "Michael");
		map1.put(8, "David");
		map1.put(3, "Numair");
		map1.put(5, "Chloe");

		System.out.println("map1: " + map1 + "\n");

		System.out.println("Element @ key 1: " + map1.get(1));
		System.out.println("Element @ key 5: " + map1.get(5));
		System.out.println("Element @ key 2: " + map1.get(2));
		System.out.println("Element @ key 99: " + map1.get(99) + "\n");

		System.out.println(map1.put(2, "Rushi"));
		System.out.println(map1.put(3, "Nat-The")); // printing put method returns whatever was present before

	}
}
