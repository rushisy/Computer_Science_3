package employeeDatabasePartTwo;

public class EmployeeDatabaseLinear {
	private Entry[] table;
	private int size;
	private int collisions;
	private int probes;

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
				size++;
				return new Employee(value);
			}
			code++;
			collisions++;
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
			probes++;
			if (table[code] == null || table[i].ID != key)
				return null;
			else if (table[code].ID == key)
				return table[code].employee;

			code++;
		}
		return null;
	}

	/**
	 * sets the number of probes
	 * 
	 * @param input to assign the probes
	 */
	public void setProbes(int input) {
		probes = input;
	}

	/**
	 * outputs the collisions variable
	 * 
	 * @return int the number of collisions
	 */
	public int getCollisions() {
		return collisions;
	}

	/**
	 * outputs the probes variable
	 *
	 * @return int the number of probes
	 */
	public int getProbes() {
		return probes;
	}

	/**
	 * outputs the size of the database
	 * 
	 * @return int the size of the database
	 */
	public int size() {
		return table.length;
	}

	/**
	 * outputs the recorded size
	 * 
	 * @return int the size that is being used
	 */
	public int recordSize() {
		return size;
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