package tableOfWords;

public class Word {
	private String theValue;

	/**
	 * preferred constructor
	 * 
	 * @param theValue the word
	 */
	public Word(String theValue) {
		this.theValue = theValue.trim();
	}

	/**
	 * outputs theValue
	 * 
	 * @return String the word
	 */
	public String getValue() {
		return theValue;
	}

	/**
	 * dont know why we need this
	 * 
	 * @return boolean default is set to false
	 */
	public boolean equals() {
		return false;
	}

	/**
	 * outputs the hashcode
	 * 
	 * @return int the hashcode
	 */
	public int hashCode() {
		return (getVowels(theValue) * theValue.length()) % 10;
	}

	/**
	 * helper method that returns the number of vowels in the input
	 * 
	 * @param word the input
	 * @return int the number of vowels present in the word
	 */
	private int getVowels(String word) {
		int counter = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u') {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * used for debugging
	 * 
	 * @return String the hashcode and the word
	 */
	public String toString() {
		return theValue + " " + hashCode();
	}
}