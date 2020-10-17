package postfixSolver;

import java.util.Stack;

public class PostFix {
	private Stack<Double> stack;
	private String expression;

	/**
	 * default constructor
	 */
	public PostFix() {
		stack = new Stack<Double>();
		expression = "";
	}

	/**
	 * prefered constructor
	 * 
	 * @param exp the input string
	 */
	public PostFix(String exp) {
		expression = exp;
		stack = new Stack<Double>();

	}

	/**
	 * mock constructor to use after intialization of object
	 * 
	 * @param exp input string
	 */
	public void setExpression(String exp) {
		expression = exp;
		stack = new Stack<Double>();
	}

	/**
	 * should be helper method, but whatever -- just does the operation lol
	 * 
	 * @param one digit one
	 * @param two digit two
	 * @param op  the operation to preform
	 * @return the total of one +/-* two
	 */
	public double calc(double one, double two, char op) {
		double c = 0.0;
		if (op == '+') {
			c = one + two;
		} else if (op == '*') {
			c = one * two;
		} else if (op == '/') {
			c = one / two;
		} else {
			c = one - two;
		}
		return c;
	}

	/**
	 * solves the postfix calculator thing
	 */
	public void solve() {
		expression = expression.replaceAll(" ", "");

		for (int i = 0; i < expression.length(); i++) {

			char pointer = expression.charAt(i);
			if (Character.isDigit(pointer)) {
				stack.push((double) pointer - 48);

			} else {
				double a = stack.pop();
				double b = stack.pop();
				double c = calc(b, a, pointer);
				stack.push(c);
			}
		}
	}

	// add a toString

	/**
	 * the toString in desired format
	 * 
	 * @return String in the desired format
	 */
	@Override
	public String toString() {
		return "" + stack.peek();
	}

}