package majorLab;

public class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return (firstName.length() + lastName.length()) % 10;
	}

	@Override
	public boolean equals(Object obj) {
		return toString().equals(((Person) obj).toString());
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
