package majorLab;

import java.util.Hashtable;

public class PhoneBook implements IMap {
	private Hashtable<Person, PhoneNumber> table;

	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		return null;
	}

	@Override
	public PhoneNumber get(Person person) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public PhoneNumber remove(Person person) {
		return null;
	}

	private class Node {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
		}
	}
}
