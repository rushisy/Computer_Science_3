package examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Iterators101 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Double> list2 = new LinkedList<Double>();
		Set<Integer> list3 = new HashSet<Integer>();
		Set<Double> list4 = new HashSet<Double>();

		for (int i = 0; i < 11; i++) {
			int math = (int) ((Math.random() * 10) + 1);
			list1.add(math);
		}

		for (int i = 0; i < 11; i++) {
			double math = ((Math.random() * 100) / 100.00);
			list2.add(math);
		}

		for (int i = 0; i < 11; i++) {
			double math = ((Math.random() * 11) + 2);
			list3.add((int) math);
		}

		for (int i = 0; i < 11; i++) {
			double math = ((Math.random() * 100) / 100.00) + 1;
			list4.add(math);
		}

		Iterator<Integer> here1 = list1.iterator(); // arraylist
		Iterator<Integer> here2 = list1.iterator(); // linked
		Iterator<Integer> here3 = list1.iterator(); // hashset
		Iterator<Integer> here4 = list1.iterator(); // tree

		System.out.print("ArrayList:");
		while (here1.hasNext()) {
			System.out.print(here1.next() + " ");
		}
		
		System.out.print("\nLinked List:");
		while (here2.hasNext()) {
			System.out.print(here2.next() + " ");
		}
		
		System.out.print("\nHash Set:");
		while (here3.hasNext()) {
			System.out.print(here3.next() + " ");
		}
		
		System.out.print("\nTree Set:");
		while (here4.hasNext()) {
			System.out.print(here4.next() + " ");
		}

	}
}
