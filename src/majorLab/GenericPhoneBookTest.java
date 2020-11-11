package majorLab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class GenericPhoneBookTest {
	private static GenericPhoneBook<Person, PhoneNumber> obj = new GenericPhoneBook<Person, PhoneNumber>();
	private static Scanner key;

	public static void setUp() throws FileNotFoundException {
		key = new Scanner(new File("White Pages.txt"));

		while (key.hasNextLine()) {
			String[] list = key.nextLine().split(",");
			obj.put(new Person(list[0], list[1]), new PhoneNumber(list[2]));
		}
	}

	@Test
	void size() throws FileNotFoundException {
		assertEquals(obj.size(), 10);
	}

	@Test
	void get1() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Ardath", "Tizard")).toString(), "814-623-3296");
	}

	@Test
	void get2() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Sharyl", "Nind")).toString(), "622-246-5527");
	}

	@Test
	void get3() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Culley", "Dytham")).toString(), "127-445-9055");
	}

	@Test
	void get4() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Blank", "Value")), null);
	}

	@Test
	void get5() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person(null, null)), null);
	}

	@Test
	void remove1() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Bryn", "O'Scanlan")).toString(), "345-372-4210");
	}

	@Test
	void remove2() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Ray", "Sawden")).toString(), "376-405-6672");
	}

	@Test
	void remove3() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Nathaniel", "Koubu")).toString(), "146-672-4389");
	}

	@Test
	void remove4() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person("Blank", "Value")), null);
	}

	@Test
	void remove5() throws FileNotFoundException {
		setUp();
		assertEquals(obj.get(new Person(null, null)), null);
	}

	@Test
	void print() throws FileNotFoundException {
		setUp();
		assertTrue(obj.toString().contains("488-670-5376"));
	}

}
