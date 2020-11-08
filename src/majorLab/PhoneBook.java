package majorLab;

public class PhoneBook implements IMap {
	private Entry[] table;

	public PhoneBook() {
		table = new Entry[5000];
	}

	public int hashCode(int key) {
		return key % 10;
	}

	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		int code = hashCode(person.hashCode());
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

	@Override
	public boolean equals(Object obj) {
		return toString().equals(((PhoneBook) obj).toString());
	}

	@Override
	public PhoneNumber get(Person person) {
		int code = hashCode(person.hashCode());
		System.out.println(code);
		for (int i = 0; i < table.length; i++) {
			if (table[code].person.equals(person)) {
				System.out.println(code);
				return table[code].number;
			}
			code++;
		}
		return null;
	}

	@Override
	public int size() {
		return table.length;
	}

	@Override
	public PhoneNumber remove(Person person) {
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < table.length; i++)
			output += table[i].toString() + "\n";
		return output;
	}

	private class Entry {
		private Person person;
		private PhoneNumber number;

		public Entry(Person person, PhoneNumber number) {
			this.person = person;
			this.number = number;
		}

		public String toString() {
			return person.toString() + " -> " + number.toString();
		}
	}
}
