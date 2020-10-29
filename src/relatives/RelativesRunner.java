package relatives;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RelativesRunner {
	public static void main(String args[]) throws IOException {
		Scanner key = new Scanner(new File("relatives.dat"));
		int relatives = key.nextInt();
		Relatives obj = new Relatives();

		for (int i = 0; i <= relatives; i++) {
			String line = key.nextLine();
			if (!line.equals(""))
				obj.setPersonRelative(line);
		}

		System.out.println(obj.toString());
	}
}