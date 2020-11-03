package tableOfIntegers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTableRunner {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			Scanner key = new Scanner(new File("numbers.dat"));
			HashTable obj = new HashTable();

			while (key.hasNextInt()) {
				Number number = new Number(key.nextInt());
				obj.add(number);
			}
			System.out.println(obj.toString());
		} catch (Exception e) {
			System.out.println("Houston, we have a problem!");
		}
	}
}