package majorLab;

import java.util.Hashtable;
import java.util.LinkedList;

public class PhoneBook implements IMap {
	private Hashtable<Person, PhoneNumber> table;
	private LinkedList<Entry> list;

	public PhoneBook() {
		table = new Hashtable<Person, PhoneNumber>();
		list = new LinkedList<Entry>();
	}

	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		list.add(new Entry(person, phone));
		return table.put(person, phone);
	}

	public Hashtable<Person, PhoneNumber> getTable() {
		return table;
	}

	public LinkedList<Entry> getList() {
		return list;
	}

	@Override
	public PhoneNumber get(Person person) {
		return table.get(person);
	}

	@Override
	public int size() {
		return table.size();
	}

	@Override
	public PhoneNumber remove(Person person) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).person == person)
				list.remove(i);
		}
		return table.remove(person);
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
