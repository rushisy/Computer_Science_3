package majorLab;

public class GenericPhoneBook<K, V> implements GenericIMap {
	private Entry[] table;

	/**
	 * default constructor
	 */
	public GenericPhoneBook() {
		table = new Entry[5000];
	}

	/**
	 * adds the key value pair to the table
	 * 
	 * @param key   the key of the pair
	 * @param value the value of the pair
	 */
	@Override
	public V put(Object key, Object value) {
		int code = key.hashCode() + value.hashCode();
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null) {
				table[code] = new Entry(key, value);
				return (V) value;
			}
			code++;
			code %= table.length;

		}
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
		try {
			int code = key.hashCode();
			for (int i = 0; i < table.length; i++) {
				if (table[code].key.equals(key)) {
					return (V) table[code].value;
				}
				code++;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
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
		try {
			int code = key.hashCode();
			for (int i = 0; i < table.length; i++) {
				if (table[code].key.equals(key)) {
					int temp = key.hashCode();
					Entry obj = table[temp];
					table[temp] = null;
					return (V) obj.value;
				}
				code++;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * outputs the database
	 * 
	 * @return String the database in the desired format
	 */
	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null)
				output += table[i].toString() + "\n";
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
