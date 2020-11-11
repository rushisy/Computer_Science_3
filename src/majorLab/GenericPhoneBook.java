package majorLab;

import java.util.LinkedList;

public class GenericPhoneBook<K, V> implements GenericIMap {
	private LinkedList[] table;

	/**
	 * default constructor
	 */
	public GenericPhoneBook() {
		table = new LinkedList[10];
	}

	/**
	 * adds the key value pair to the table
	 * 
	 * @param key   the key of the pair
	 * @param value the value of the pair
	 */
	@Override
	public V put(Object key, Object value) {
		if (table[key.hashCode()] == null)
			table[key.hashCode()] = new LinkedList();
		if (!table[key.hashCode()].contains(((Person) key).getName()))
			table[key.hashCode()].add((new Entry(key, value)));
		return (V) value;
	}

	/**
	 * outputs the value of the key
	 * 
	 * @param key the key to search for
	 * @return V the value of the key
	 */
	@Override
	public V get(Object key) {
		for (int j = 0; j < table[key.hashCode()].size(); j++) {
			if (((Person) ((Entry) table[key.hashCode()].get(j)).key).getName().contains(((Person) key).getName()))
				return (V) ((Entry) table[key.hashCode()].get(j)).value;
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
	 * @param the key the key to search and remove
	 * @return the value that got removed
	 */
	@Override
	public V remove(Object key) {
		for (int j = 0; j < table[key.hashCode()].size(); j++) {
			if (((Person) ((Entry) table[key.hashCode()].get(j)).key).getName().contains(((Person) key).getName())) {
				PhoneNumber num = (PhoneNumber) ((Entry) table[key.hashCode()].get(j)).value;
				table[key.hashCode()].remove(j);
				return (V) num;
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
	public String toString() {
		String output = "HASHTABLE\n";
		for (int i = 0; i < table.length; i++) {
			output += "bucket " + i + ": " + table[i].toString().substring(1, table[i].toString().length() - 1) + "\n";
		}
		return output;
	}

	private class Entry<K, V> {
		private K key;
		private V value;

		/**
		 * default constructor
		 * 
		 * @param key   the key to pair
		 * @param value the value to the pair
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * outputs the entry object
		 * 
		 * @return String a string representation of the object's elements
		 */
		public String toString() {
			return key.toString() + " -> " + value.toString();
		}
	}
}
