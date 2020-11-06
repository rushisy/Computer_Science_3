package employeeDatabasePartTwo;

public class EmployeeDatabaseLinear {
	private Entry[] table;
	private int size;
	private int collisions;
	private int probes;

	public EmployeeDatabaseLinear(int size) {
		table = new Entry[size];
	}

	public int hashCode(int key) {
		return key % table.length;
	}

	public Employee put(int key, String value) {
		int code = hashCode(key);
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null) {
				table[code] = new Entry(key, new Employee(value));
				size++;
				return new Employee(value);
			}
			code++;
			collisions++;
			code %= table.length;
		}
		return new Employee(value);
	}

	public Employee get(int key) {
		int code = hashCode(key);
		for (int i = 0; i < table.length; i++) {
			probes++;
			if (table[code] == null || table[i].ID != key)
				return null;
			else if (table[code].ID == key)
				return table[code].employee;

			code++;
		}
		return null;
	}

	public void setProbes(int input) {
		probes = input;
	}

	public int getCollisions() {
		return collisions;
	}

	public int getProbes() {
		return probes;
	}

	public int size() {
		return table.length;
	}

	public int recordSize() {
		return size;
	}

	@Override
	public String toString() {
		String output = "";
		for (Entry entry : table)
			output += entry.ID + " -> " + entry.employee.toString() + "\n";
		return output;
	}

	private class Entry {
		private int ID;
		private Employee employee;

		public Entry(int ID, Employee employee) {
			this.ID = ID;
			this.employee = employee;
		}
	}
}