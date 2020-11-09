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
		System.out.println(obj.toString());

		System.out.println(String.join("\u0332", "Getter Method Test".split("", -1)) + "\n"); // for formatting

		System.out.println(obj.get(new Person("Ann", "Vinas"))); // 114-200-1786
		System.out.println(obj.get(new Person("Ludkfjsldk", "LKfdikdkf"))); // null
		System.out.println(obj.get(new Person("Tiphanie", "Cossor"))); // 776-938-4664

		System.out.println("\n" + String.join("\u0332", "Remove Method Test".split("", -1)) + "\n");

		System.out.println(obj.remove(new Person("Glenden", "Asser"))); // 250-429-2291
		System.out.println(obj.remove(new Person("Ardath", "Tizard"))); // 250-429-2291
		System.out.println(obj.remove(new Person("SDKFJKSJDLF", "DFKLJkdfjr"))); // null

		//test case for generic
		//delete method
	}
}
