package employeeDatabasePartTwo;

public class Employee {
	private String name;

	/**
	 * preferred constructor
	 * 
	 * @param name the name to assign the employee
	 */
	public Employee(String name) {
		this.name = name;
	}

	/**
	 * outputs the employee credentials
	 * 
	 * @return String the employee credentials in the desired format
	 */
	@Override
	public String toString() {
		return name;
	}
}
