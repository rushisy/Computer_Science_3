package tableOfIntegers;

public class Number {
	private int theValue;

	/**
	 * preferred constructor
	 * 
	 * @param value the input value
	 */
	public Number(int value) {
		theValue = value;
	}

	/**
	 * outputs theValue
	 * 
	 * @return int the number
	 */
	public int getValue() {
		return theValue;
	}

	/**
	 * don't know why we need this
	 * 
	 * @return boolean default always false
	 */
	public boolean equals(Object obj) {
		return false;
	}

	/**
	 * outputs the hashcode for the value
	 * 
	 * @return int the hashcode
	 */
	public int hashCode() {
		return theValue % 10;
	}

	/**
	 * used for debugging
	 * 
	 * @return String the value and its hashcode
	 */
	public String toString() {
		return theValue + " " + hashCode();
	}
}