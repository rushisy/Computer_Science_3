package evensFirst;

import java.util.LinkedList;
import java.util.Queue;

public class EvensFirstRunner {

	public static void main(String[] args) {
		EvensFirst obj = new EvensFirst();
		Queue<Integer> temp = new LinkedList<Integer>();

		temp.add(101);
		temp.add(13);
		temp.add(12);
		temp.add(0);
		temp.add(947);
		temp.add(311);
		temp.add(312);
		temp.add(42);
		temp.add(18);
		temp.add(64);
		temp.add(256);
		temp.add(601);
		temp.add(2);

		System.out.println(temp.toString() + " >>> head" + obj.putEvensFirst(temp) + "tail");
	}

}
