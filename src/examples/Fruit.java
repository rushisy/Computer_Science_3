package examples;

public enum Fruit {
	APPLE("RED"), BANANA("YELLOW"), GRAPE("GREEN"), ORANGE;

	private String color;

	private Fruit() {
		System.out.println("Constructor called for: " + this.toString());
	}

	private Fruit(String color) {
		this.color = color;
		System.out.println("Constructor called for: " + this.toString());
	}

	public String getColor() {
		return color;
	}
}
