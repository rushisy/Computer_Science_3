package forestFire;

public class FireCell {
	public static final int DIRT = 0, GREEN = 1, BURNING = 2, TESTING = 3;
	private int status;

	public FireCell() {
		status = DIRT;
		if (Math.random() <= .60)
			status = GREEN;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int n) {
		status = n;
	}
}
