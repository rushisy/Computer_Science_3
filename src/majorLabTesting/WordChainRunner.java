package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class WordChainRunner {
	public static void main(String[] args) throws FileNotFoundException {
		long start = System.nanoTime();

		Scanner key = new Scanner(new File("input.txt"));

		while (key.hasNext()) {
			String original = key.next();
			String answer = key.next();
			WordChain obj = new WordChain(original, answer);
			obj.dictionary();

			Stack<String> stack = obj.layer();
			if (stack != null) {
				System.out.println("Found a ladder! >>> " + stack);
			} else {
				System.out.println("No ladder between " + original + " and " + answer);
			}
		}

		long stop = System.nanoTime();
		System.out.println("Execution Time: " + (double) (stop - start) / 1000000000 + " seconds!");
	}
}
