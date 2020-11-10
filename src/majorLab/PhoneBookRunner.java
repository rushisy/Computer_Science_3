package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBookRunner {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner key = new Scanner(new File("White Pages.txt"));
		PhoneBook obj = new PhoneBook();

		while (key.hasNextLine()) {
			String[] list = key.nextLine().split(",");
			obj.put(new Person(list[0], list[1]), new PhoneNumber(list[2]));
		}
	}
}
