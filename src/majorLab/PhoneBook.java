package majorLab;

public class PhoneBook implements IMap {
	private Entry[] table;

	/**
	 * default constructor
	 */
	public PhoneBook() {
		table = new Entry[5000];
	}

	/**
	 * adds the key value pair to the table
	 * 
	 * @param person the key of the pair
	 * @param phone  the value of the pair
	 */
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		int code = person.hashCode() + phone.hashCode();
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null) {
				table[code] = new Entry(person, phone);
				return phone;
			}
			code++;
			code %= table.length;

		}
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
		try {
			int code = person.hashCode();
			for (int i = 0; i < table.length; i++) {
				if (table[code].person.equals(person)) {
					return table[code].number;
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
	 * @param person the key to search and remove
	 * @return PhoneNumber that got removed
	 */
	@Override
	public PhoneNumber remove(Person person) {
		try {
			int code = person.hashCode();
			for (int i = 0; i < table.length; i++) {
				if (table[code].person.equals(person)) {
					int temp = person.hashCode();
					Entry obj = table[temp];
					table[temp] = null;
					return obj.number;
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

	private class Entry {
		private Person person;
		private PhoneNumber number;

		/**
		 * default constructor
		 * 
		 * @param person the key to pair
		 * @param number the value to the pair
		 */
		public Entry(Person person, PhoneNumber number) {
			this.person = person;
			this.number = number;
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
