package histogram;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HistogramRunner {
	public static void main(String args[]) throws IOException {
		Scanner key = new Scanner(new File("histogram.dat"));

		while (key.hasNextLine()) {
			String line = key.nextLine();
			Histogram obj = new Histogram();
			obj.setSentence(line);
			System.out.println(obj);
		}
	}
}