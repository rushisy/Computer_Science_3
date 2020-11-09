package employeeDatabasePartOne;

public class EmployeeDatabaseLinear {
	private Entry[] table;

	/**
	 * preferred constructor
	 * 
	 * @param size the value to assign the database
	 */
	public EmployeeDatabaseLinear(int size) {
		table = new Entry[size];
	}

	/**
	 * creates the hashcode
	 * 
	 * @param key the intput value of the employee
	 * @return int the new hashcode
	 */
	public int hashCode(int key) {
		return key % table.length;
	}

	/**
	 * adds the employee to the database
	 * 
	 * @param key   the employee ID
	 * @param value the employee name
	 * @return Employee the added employee
	 */
	public Employee put(int key, String value) {
		int code = hashCode(key);
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null) {
				table[code] = new Entry(key, new Employee(value));
				return new Employee(value);
			}
			code++;
			code %= table.length;
		}
		return new Employee(value);
	}

	/**
	 * outputs the employee at a given location
	 * 
	 * @param key the key of the employee
	 * @return Employee the employee object at the hashcode position
	 */
	public Employee get(int key) {
		int code = hashCode(key);
		for (int i = 0; i < table.length; i++) {
			if (table[code] == null)
				break;
			else if (table[code].ID == key)
				return table[code].employee;

			code++;
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
		String output = "";
		for (Entry entry : table)
			output += entry.ID + " -> " + entry.employee.toString() + "\n";
		return output;
	}

	private class Entry {
		private int ID;
		private Employee employee;

		/**
		 * preferred constructor
		 * 
		 * @param ID       the ID of the entry
		 * @param employee the employee object of the entry object
		 */
		public Entry(int ID, Employee employee) {
			this.ID = ID;
			this.employee = employee;
		}
	}
}