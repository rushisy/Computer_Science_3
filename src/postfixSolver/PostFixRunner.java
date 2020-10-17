package postfixSolver;

public class PostFixRunner {
	public static void main(String[] args) {
		PostFix obj = new PostFix("2 7 + 1 2 + +");
		obj.solve();
		System.out.println("2 7 + 1 2 + + = " + obj);

		obj.setExpression("1 2 3 4 + + +");
		obj.solve();
		System.out.println("1 2 3 4 + + + = " + obj);

		obj.setExpression("9 3 * 8 / 4 +");
		obj.solve();
		System.out.println("9 3 * 8 / 4 + = " + obj);

		obj.setExpression("3 3 + 7 * 9 2 / +");
		obj.solve();
		System.out.println("3 3 + 7 * 9 2 / + = " + obj);

		obj.setExpression("9 3 / 2 * 7 9 * + 4 –");
		obj.solve();
		System.out.println("9 3 / 2 * 7 9 * + 4 – = " + obj);

		obj.setExpression("5 5 + 2 * 4 / 9 +");
		obj.solve();
		System.out.println("5 5 + 2 * 4 / 9 + = " + obj);
	}
}