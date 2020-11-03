package tableOfWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTableRunner {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			Scanner key = new Scanner(new File("words.dat"));
			HashTable obj = new HashTable();
			int num = key.nextInt();

			while (key.hasNextLine()) {
				Word number = new Word(key.nextLine());
				obj.add(number);
			}
			System.out.println(obj.toString());
		} catch (Exception e) {
			System.out.println("Houston, we have a problem!");
		}
	}
}