package bottles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Bottles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("bottles.dat"));
		int iterations = key.nextInt();
		key.nextLine();
		for (int i = 0; i < iterations; i++) {
			System.out.println(bottles(Stream.of(key.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()));
		}
	}

	public static int bottles(int[] list) {
		int base1 = list[1];
		int base2 = 0;

		for (int i = 2; i < list.length; i++) {
			int value = Math.max(base1, base2);
			base1 = base2 + list[i];
			base2 = value;
		}

		return Math.max(base1, base2);
	}
}
