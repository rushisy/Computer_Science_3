package spanish2english;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpanRunner {
	public static void main(String args[]) throws IOException {
		Scanner key = new Scanner(new File("spantoeng.dat"));
		SpanishToEnglish obj = new SpanishToEnglish();
		int words = key.nextInt();

		for (int i = 0; i <= words; i++) {
			String line = key.nextLine();
			if (!line.equals(""))
				obj.putEntry(line);
		}

		while (key.hasNextLine()) {
			System.out.println(obj.translate(key.nextLine()));
		}
	}
}