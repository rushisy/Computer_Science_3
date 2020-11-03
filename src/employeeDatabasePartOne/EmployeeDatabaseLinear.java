package employeeDatabasePartOne;

import java.util.Hashtable;

public class EmployeeDatabaseLinear {
	private Hashtable<Integer, Employee> table;

	public EmployeeDatabaseLinear() {
		table = new Hashtable<Integer, Employee>();
	}

	public int hashCode(int key) {
		int num = key;
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public void put(int key, int value) {

	}

	public Employee get(int key) {
		return null;
	}

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
