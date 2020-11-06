package employeeDatabasePartOne;

public class TesterQuadratic {
	public static void main(String[] args) {
		EmployeeDatabaseQuadratic obj = new EmployeeDatabaseQuadratic(20);

		obj.put(5, "Jared");
		obj.put(23, "Rushi");
		obj.put(42, "Michael");
		obj.put(83, "Jackson");
		obj.put(1, "Conrad");
		obj.put(17, "Bot");
		obj.put(42, "Ethan");
		obj.put(83, "Numair");
		obj.put(5, "Ari");
		obj.put(3, "Gabriela");
		obj.put(4, "Nicholas");
		obj.put(8, "Zain");
		obj.put(5, "Chloe");
		obj.put(17, "Raymond");
		obj.put(42, "Ethan");
		obj.put(83, "Nhat-The");
		obj.put(6, "David");
		obj.put(67, "Matthew");
		obj.put(12, "Ananya");
		obj.put(69, "Ur Mom");

		System.out.println(obj.toString());

		System.out.println(obj.get(23));
		System.out.println(obj.get(5));
		System.out.println(obj.get(5));
		System.out.println(obj.get(42));
		System.out.println(obj.get(17));
		System.out.println(obj.get(6));

	}
}
