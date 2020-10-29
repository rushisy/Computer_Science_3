package acronyms;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AcroRunner {
	public static void main(String args[]) throws IOException {
		Scanner key = new Scanner(new File("acro.dat"));
		Acronyms obj = new Acronyms();
		int words = key.nextInt();

		for (int i = 0; i <= words; i++) {
			String line = key.nextLine();
			if (!line.equals(""))
				obj.putEntry(line);
		}
		System.out.println(obj.toString());
		while (key.hasNextLine()) {
			System.out.println(obj.convert(key.nextLine()));
		}
	}
}