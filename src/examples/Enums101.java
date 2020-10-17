package examples;

public class Enums101 {
	Day day;

	// Constructor
	public Enums101(Day day) {
		this.day = day;
	}

	public void dayIsLike() {
		switch (day) {
		case MONDAY:
			System.out.println("Mondays are bad.");
			return;
		case FRIDAY:
			System.out.println("Fridays are better");
			return;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			return;
		default:
			System.out.println("Midweek days are so-so");
			return;

		}
	}

	public void isItWeekend() {
		Day d1 = Day.valueOf("SATURDAY");
		Day d2 = Day.valueOf("SUNDAY");

		if (day.equals(d1) || day.equals(d2)) {
			System.out.println("Time to get lit!");
		} else {
			System.out.println("It's NOT the weekend, get back to work!");
		}
	}

	public static void main(String[] args) {
		String str = "SATURDAY";
		Enums101 t1 = new Enums101(Day.valueOf(str));
		t1.dayIsLike();
		t1.isItWeekend();
	}
}
