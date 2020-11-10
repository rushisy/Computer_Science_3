package majorLab;

public class Person {
	private String name;

	/**
	 * preferred constructor
	 * 
	 * @param firstName the first name of the person
	 * @param lastName  the last name of the person
	 */
	public Person(String first, String second) {
		name = first + " " + second;
	}

	/**
	 * generates the hashcode of the object
	 * 
	 * @return int the hashcode
	 */
	@Override
	public int hashCode() {
		return name.length() % 10;
	}
	
	public String getName() {
		return name;
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
		return name;
	}

	/**
	 * outputs the size
	 * 
	 * @return int outputs the size of the string
	 */
	public int size() {
		return name.length();
	}
}
