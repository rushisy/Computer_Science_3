package majorLab;

public class PhoneNumber {
	private String number;

	public PhoneNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return number + "";
	}

	@Override
	public int hashCode() {
		return number.length() % 10;
	}

	@Override
	public boolean equals(Object obj) {
		return toString().equals(((PhoneNumber) obj).toString());
	}
}
