package employeeDatabasePartOne;

public class EmployeeDatabaseQuadratic {
	private Entry[] table;

	/**
	 * preferred constructor
	 * 
	 * @param size the value to assign the database
	 */
	public EmployeeDatabaseQuadratic(int size) {
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
		int i = code;
		int counter = 1;

		do {
			if (table[i] == null) {
				table[i] = new Entry(key, new Employee(value));
				return new Employee(value);
			}

			if (table[i].ID == key) {
				table[i].employee = new Employee(value);
				return new Employee(value);
			}

			i = (i + counter * counter++) % table.length;

		} while (i != code);
		return null;
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
		for (Entry entry : table) {
			if (entry != null)
				output += entry.ID + " -> " + entry.employee.toString() + "\n";
		}
		return output;
	}

	/**
	 * preferred constructor
	 * 
	 * @param ID       the ID of the entry
	 * @param employee the employee object of the entry object
	 */
	private class Entry {
		private int ID;
		private Employee employee;

		public Entry(int ID, Employee employee) {
			this.ID = ID;
			this.employee = employee;
		}
	}

}
