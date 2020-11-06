package majorLab;

public class PhoneNumber {
	private String number;

	public PhoneNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return -1;
	}

	@Override
	public String toString() {
		return number + "";
	}
}
