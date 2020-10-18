package examples;

import java.util.ArrayList;
import java.util.ListIterator;

public class Tester {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(11);
		System.out.println(a);
		a.add(18);
		System.out.println(a);
		a.add(80);
		System.out.println(a);
		a.add(22);
		System.out.println(a);
		a.add(3);
		System.out.println(a);
		ListIterator<Integer> iterator = a.listIterator();
		iterator.next();
		System.out.println(a);
		iterator.next();
		System.out.println(a);
		iterator.set(99);
		System.out.println(a);
		iterator.next();
		System.out.println(a);
		iterator.previous();
		System.out.println(a);
		iterator.set(33);
		
		System.out.println(a);
	}

}
