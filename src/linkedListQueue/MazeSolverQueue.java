package linkedListQueue;

public class MazeSolverQueue<T> extends MazeSolver {
	private MyQueue<T> queue;

	/**
	 * the preferred constructor
	 * 
	 * @param maze object from the Maze class
	 */
	public MazeSolverQueue(Maze maze) {
		super(maze);
		queue = new MyQueue<T>();
		queue.offer((T) maze.getStart());

	}

	/**
	 * clears the stack
	 */
	@Override
	public void makeEmpty() {
		queue = new MyQueue<T>();
	}

	/**
	 * outputs if the stack is empty or not
	 * 
	 * @return boolean true or not if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * adds a square to the stack
	 */
	@Override
	public void add(Square s) {
		queue.offer((T) s);
	}

	/**
	 * pops a square from the stack
	 * 
	 * @return Square an object from the stack
	 */
	@Override
	public Square next() {
		return (Square) queue.poll();
	}

}
