package majorLab;

import java.util.LinkedList;

public class PhoneBook implements IMap {
	private LinkedList[] table;

	/**
	 * default constructor
	 */
	public PhoneBook() {
		table = new LinkedList[10];
	}

	/**
	 * adds the key value pair to the table
	 * 
	 * @param person the key of the pair
	 * @param phone  the value of the pair
	 */
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		if (table[person.hashCode()] == null)
			table[person.hashCode()] = new LinkedList();
		if (!table[person.hashCode()].contains(((Person) person).getName()))
			table[person.hashCode()].add((new Entry(person, phone)));
		return phone;
	}

	/**
	 * outputs the value of the key
	 * 
	 * @param person the key to search for
	 * @return PhoneNumber the value of the key
	 */
	@Override
	public PhoneNumber get(Person person) {
		for (int j = 0; j < table[person.hashCode()].size(); j++) {
			if (((Entry) table[person.hashCode()].get(j)).person.getName().contains(person.getName()))
				return ((Entry) table[person.hashCode()].get(j)).number;
		}

		return null;

	}

	/**
	 * outputs the size of the database
	 * 
	 * @return int the size of the table
	 */
	@Override
	public int size() {
		return table.length;
	}

	/**
	 * removes the key value pair from the database
	 * 
	 * @param person the key to search and remove
	 * @return PhoneNumber that got removed
	 */
	@Override
	public PhoneNumber remove(Person person) {
		for (int j = 0; j < table[person.hashCode()].size(); j++) {
			if (((Entry) table[person.hashCode()].get(j)).person.getName().contains(person.getName())) {
				PhoneNumber num = ((Entry) table[person.hashCode()].get(j)).number;
				table[person.hashCode()].remove(j);
				return num;
			}
		}
		return null;
	}

	/**
	 * outputs the database
	 * 
	 * @return String the database in the desired format
	 */
	@Override
	public String toString() { // used for testing
		String output = "HASHTABLE\n";
		for (int i = 0; i < table.length; i++) {
			output += "bucket " + i + ": " + table[i].toString().substring(1, table[i].toString().length() - 1) + "\n";
		}
		return output;
	}

	private class Entry {
		private Person person;
		private PhoneNumber number;
		private Entry next;

		/**
		 * default constructor
		 * 
		 * @param person the key to pair
		 * @param number the value to the pair
		 */
		public Entry(Person person, PhoneNumber number) {
			this.person = person;
			this.number = number;
			next = null;
		}

		/**
		 * outputs the entry object
		 * 
		 * @return String a string representation of the object's elements
		 */
		public String toString() {
			return person.toString() + " -> " + number.toString();
		}
	}
}
