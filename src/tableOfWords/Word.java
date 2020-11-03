package tableOfWords;

public class Word {
	private String theValue;

	// write a constructor

	public Word(String theValue) {
		this.theValue = theValue.trim();
	}

	public String getValue() {
		return theValue;
	}

	public boolean equals() {
		return false;
	}

	public int hashCode() {
		return (getVowels(theValue) * theValue.length()) % 10;
	}

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

	public String toString() {
		return theValue + " " + hashCode();
	}
}