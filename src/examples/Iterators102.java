package examples;

import java.util.*;

public class Iterators102 {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();

		for (int i = 0; i < 11; i++) {
			int math = (int) ((Math.random() * 10) + 1);
			list1.add(math);
		}
		
		System.out.println("ArrayList :");
		for(Iterator<Integer> i = list1.iterator(); i.hasNext();) {
			System.out.print(i.next());
		}
	}

}
