package employeeDatabasePartOne;

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
	 * outputs the name of the employee
	 * 
	 * @return String the desired output of the employee credentials
	 */
	@Override
	public String toString() {
		return name;
	}
}
