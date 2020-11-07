package examples;

public class Student {
	private int id;
	private String name;
	private int grade;
	private double gpa;

	public Student(int id, String name, int grade, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", gpa=" + gpa + "]";
	}
}
