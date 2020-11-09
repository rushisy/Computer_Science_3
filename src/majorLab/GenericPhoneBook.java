package majorLab;

public class GenericPhoneBook<K, V> implements GenericIMap {
	private Entry[] table;

	public GenericPhoneBook() {
		table = new Entry[5000];
	}

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

	@Override
	public int size() {
		return table.length;
	}

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

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return key.toString() + " -> " + value.toString();
		}
	}
}
