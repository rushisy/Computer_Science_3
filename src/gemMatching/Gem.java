package gemMatching;

enum GemType {
	GREEN, BLUE, ORANGE; // define the different types of Gems, comma delimited
}

public class Gem {
	private GemType type;
	private int points;

	/**
	 * default constructor
	 */
	public Gem() {
		points = 1;
		while (points == 1) { // sets value of the point to multiple of 5
			int number = (int) (Math.random() * 51);
			if (number % 5 == 0) {
				points = number;
			}
		}

		int temp = (int) (Math.random() * 3) + 0; // sets the color of the gem
		if (temp == 0) {
			type = GemType.GREEN;
		} else if (temp == 1) {
			type = GemType.BLUE;
		} else {
			type = GemType.ORANGE;
		}
	}

	/**
	 * assigns the gem object with the specified data
	 * 
	 * @param type   the type of color to assign the object
	 * @param points the point value of the gem
	 */
	public Gem(GemType type, int points) {
		this.type = type;
		this.points = points;

	}

	/**
	 * outputs the type variable
	 * 
	 * @return GemType the type of the object
	 */
	public GemType getType() {
		return type;
	}

	/**
	 * outputs the point value of the gem
	 * 
	 * @return int the point value of the gem
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * draws the gem object with the point value and specified color
	 * 
	 * @param x the x coordinate of the placing of the object
	 * @param y the y coordinate of the placing of the object
	 */
	public void draw(double x, double y) {
		StdDraw.setPenColor(StdDraw.WHITE);
		if (type == GemType.GREEN) {
			StdDraw.picture(x, y, "gem_green.png");
			StdDraw.text(x, y, points + "");
		} else if (type == GemType.BLUE) {
			StdDraw.picture(x, y, "gem_blue.png");
			StdDraw.text(x, y, points + "");
		} else if (type == GemType.ORANGE) {
			StdDraw.picture(x, y, "gem_orange.png");
			StdDraw.text(x, y, points + "");
		}
	}

	/**
	 * outputs the type and points in the desired format
	 * 
	 * @return String the representation of the gem
	 */
	@Override
	public String toString() {
		return type + " " + points;
	}

	/** Tester main method */
	public static void main(String[] args) {
		final int maxGems = 16;
		// Create a gem of each type
		Gem green = new Gem(GemType.GREEN, 10);
		Gem blue = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green + ", " + green.getType() + ", " + green.getPoints());
		System.out.println(blue + ", " + blue.getType() + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		// A row of random gems
		for (int i = 0; i < maxGems; i++) {
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}

}
