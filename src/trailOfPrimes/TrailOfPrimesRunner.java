package trailOfPrimes;

import java.io.IOException;
import java.util.Stack;

public class TrailOfPrimesRunner {
	public static void main(String[] args) throws IOException {

		String one = "1033";
		String two = "8179";
		TrailOfPrimes obj = new TrailOfPrimes(one, two);
		obj.dictionary();

		Stack<String> stack = obj.layer();
		if (stack != null) {
			System.out.println("Input  : 1033 8179\nOutput : " + (stack.size() - 1) + "\n");
		}

		one = "1373";
		two = "8017";
		obj = new TrailOfPrimes(one, two);
		obj.dictionary();

		stack = obj.layer();
		if (stack != null) {
			System.out.println("Input  : 1373 8017\nOutput : " + (stack.size() - 1) + "\n");
		}

		one = "1033";
		two = "1033";
		obj = new TrailOfPrimes(one, two);
		obj.dictionary();

		stack = obj.layer();
		if (stack != null) {
			System.out.println("Input  : 1033 1033\nOutput : " + (stack.size() - 1) + "\n");
		} else {
			System.out.println("Input  : 1033 1033\nOutput : 0");
		}

	}
}
