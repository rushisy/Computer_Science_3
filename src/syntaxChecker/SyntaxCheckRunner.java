package syntaxChecker;

public class SyntaxCheckRunner {
	public static void main(String[] args) {
		SyntaxChecker obj = new SyntaxChecker("(abc(*def)");

		if (obj.checkExpression() == false) {
			System.out.println("(abc(*def) is incorrect.\n");
		} else {
			System.out.println("(abc(*def) is correct.\n");
		}
		
		obj.setExpression("[{}]");
		if (obj.checkExpression() == false) {
			System.out.println("[{}] is incorrect.\n");
		} else {
			System.out.println("[{}] is correct.\n");
		}

		obj.setExpression("[");
		if (obj.checkExpression() == false) {
			System.out.println("[ is incorrect.\n");
		} else {
			System.out.println("[ is correct.\n");
		}
		
		obj.setExpression("[{<()>}]");
		if (obj.checkExpression() == false) {
			System.out.println("[{<()>}] is incorrect.\n");
		} else {
			System.out.println("[{<()>}] is correct.\n");
		}
		
		obj.setExpression("{<html[value=4]*(12)>{$x}}");
		if (obj.checkExpression() == false) {
			System.out.println("{<html[value=4]*(12)>{$x}} is incorrect.\n");
		} else {
			System.out.println("{<html[value=4]*(12)>{$x}} is correct.\n");
		}
		
		obj.setExpression("[one]<two>{three}(four)");
		if (obj.checkExpression() == false) {
			System.out.println("[one]<two>{three}(four) is incorrect.\n");
		} else {
			System.out.println("[one]<two>{three}(four) is correct.\n");
		}
		
		obj.setExpression("car(cdr(a)(b)))");
		if (obj.checkExpression() == false) {
			System.out.println("car(cdr(a)(b))) is incorrect.\n");
		} else {
			System.out.println("car(cdr(a)(b))) is correct.\n");
		}
		
		obj.setExpression("car(cdr(a)(b))");
		if (obj.checkExpression() == false) {
			System.out.println("car(cdr(a)(b)) is incorrect.\n");
		} else {
			System.out.println("car(cdr(a)(b)) is correct.\n");
		}
	}
}