package majorLab;

public class Person {
	private String firstName;
	private String lastName;

	/**
	 * preferred constructor
	 * 
	 * @param firstName the first name of the person
	 * @param lastName  the last name of the person
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * generates the hashcode of the object
	 * 
	 * @return int the hashcode
	 */
	@Override
	public int hashCode() {
		return (firstName.length() + lastName.length()) % 10;
	}

	/**
	 * outputs if the input matches the current object's content
	 * 
	 * @param obj the object to compare with
	 * @return boolean true if it does match
	 */
	@Override
	public boolean equals(Object obj) {
		return toString().equals(((Person) obj).toString());
	}

	/**
	 * outputs the person object
	 * 
	 * @return the person's elements
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
