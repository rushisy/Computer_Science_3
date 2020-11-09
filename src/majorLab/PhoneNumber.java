package majorLab;

public class PhoneNumber {
	private String number;

	/**
	 * preferred constructor
	 * 
	 * @param number the number to assign the object
	 */
	public PhoneNumber(String number) {
		this.number = number;
	}

	/**
	 * outputs the object
	 * 
	 * @return String the object's number
	 */
	@Override
	public String toString() {
		return number + "";
	}

	/**
	 * outputs the hash code
	 * 
	 * @return int the hashcode
	 */
	@Override
	public int hashCode() {
		return number.length() % 10;
	}

	/**
	 * outputs if the input matches the current object's content
	 * 
	 * @param obj the object to compare with
	 * @return boolean true if it does match
	 */
	@Override
	public boolean equals(Object obj) {
		return toString().equals(((PhoneNumber) obj).toString());
	}
}
