package syntaxChecker;

import java.util.Stack;

public class SyntaxChecker {
	@SuppressWarnings("unused")
	private String exp;
	private Stack<Character> symbols;

	/**
	 * default constructor
	 */
	public SyntaxChecker() {
		exp = "";
		symbols = new Stack<Character>();
	}

	/**
	 * constructor that sets the stack with 's'
	 * 
	 * @param s the string of stuff to set the stack with
	 */
	public SyntaxChecker(String s) {
		exp = s;
		symbols = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			symbols.add(s.charAt(i));
		}
	}

	/**
	 * sets the expression differently outside of constructor
	 * 
	 * @param s the string in which to assign the stack
	 */
	public void setExpression(String s) {
		exp = s;
		symbols = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			symbols.add(s.charAt(i));
		}
		System.out.println(symbols);
	}

	/**
	 * checks if the expression is correct or not
	 * 
	 * @return boolean if the expression is equal or not syntax wise
	 */
	public boolean checkExpression() {
		/**
		 * { - left brace ( - left paranthesis < - left aligator [ - left bracket } -
		 * right brace ) - right paranthesis > - right aligator ] - right bracket
		 */

		int leftBrace = 0;
		int leftParan = 0;
		int leftAli = 0;
		int leftBracket = 0;
		int rightBrace = 0;
		int rightParan = 0;
		int rightAli = 0;
		int rightBracket = 0;

		for (int i = 0; i < symbols.size(); i++) {
			if (symbols.get(i) == '{') {
				leftBrace++;
			} else if (symbols.get(i) == '(') {
				leftParan++;
			} else if (symbols.get(i) == '<') {
				leftAli++;
			} else if (symbols.get(i) == '[') {
				leftBracket++;
			} else if (symbols.get(i) == '}') {
				rightBrace++;
			} else if (symbols.get(i) == ')') {
				rightParan++;
			} else if (symbols.get(i) == '>') {
				rightAli++;
			} else if (symbols.get(i) == ']') {
				rightBracket++;
			}
		}

		if ((leftBrace == rightBrace) && (leftParan == rightParan) && (leftAli == rightAli)
				&& (leftBracket == rightBracket)) {
			return true;
		}
		return false;
	}

	/**
	 * returns the stack in desired format
	 * 
	 * @return String the desired format
	 */
	@Override
	public String toString() {
		return "";
	}
}