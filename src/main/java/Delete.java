package main.java;

import java.util.Arrays;

public class Delete {
	public static void main(String[] args) {
		String s = "javajavajava";
		s = s.replaceFirst("\\w?[java]{2}.", "coffee");
		System.out.println(s);

	}
}
