package majorLab;

public class MazeSolverStack extends MazeSolver {
	private MyStack stack;

	/**
	 * the prefered constructor
	 * 
	 * @param maze object from the Maze class
	 */
	public MazeSolverStack(Maze maze) {
		super(maze);
		stack = new MyStack();
		stack.push(maze.getStart());

	}

	/**
	 * clears the stack
	 */
	@Override
	public void makeEmpty() {
		stack = new MyStack();
	}

	/**
	 * outputs if the stack is empty or not
	 * 
	 * @return boolean true or not if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * adds a square to the stack
	 */
	@Override
	public void add(Square s) {
		stack.push(s);
	}

	/**
	 * pops a square from the stack
	 * 
	 * @return Square an object from the stack
	 */
	@Override
	public Square next() {
		return stack.pop();
	}

}
