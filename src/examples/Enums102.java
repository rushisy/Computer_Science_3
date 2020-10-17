package examples;

public class Enums102 {
	public static void main(String[] args) {
		Element arr[] = Element.values();

		for (Element e : arr) {
			System.out.println(e + " at index " + e.ordinal());
		}

		System.out.println(Element.valueOf("FIRE")); // Using value0f() returns an object of element with given constant
	}
}
