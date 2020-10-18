package examples;

import java.util.*;

public class ListIterator101 {

	private static List<Integer> convertToIntegerList(String input) {
		String[] stringArray = input.split(" ");
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < stringArray.length; i++) {
			list.add(Integer.parseInt(stringArray[i]));
		}
		
		return list;
	}
	
	public static void printForwardsThenBackwords(List<Integer> input) {
		ListIterator<Integer> here = input.listIterator();
		System.out.println("ArrayList: ");
		for(Iterator<Integer> i = input.iterator(); i.hasNext();) {
			System.out.print(i.next());
		}
		
		for(Iterator<Integer> i = input.iterator(); i.hasNext();) {
			System.out.print(i.next());
		}
	}

	public static void main(String[] args) {
		String input = "15 25 33 10 21 10";
		List<Integer> list = convertToIntegerList(input);
		printForwardsThenBackwords(list);
	}
	
	

}
