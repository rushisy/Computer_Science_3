package employeeDatabasePartOne;

import java.util.Hashtable;

public class EmployeeDatabaseQuadratic {
	private Hashtable<Integer, Employee> table;

	private class Entry {
		private int ID;
		private Employee employee;

		public Entry(int ID, Employee employee) {
			this.ID = ID;
			this.employee = employee;
		}

		@Override
		public String toString() {
			return "";
		}
	}
}
