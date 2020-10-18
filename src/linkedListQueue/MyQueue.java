package linkedListQueue;

public class MyQueue<T> implements QueueADT<T> {
	private MyLinkedList<T> queue;

	/**
	 * default constructor
	 */
	public MyQueue() {
		queue = new MyLinkedList<T>();
	}

	/**
	 * varargs constructor
	 * 
	 * @param value the list of arguments to assign queue to
	 */
	public MyQueue(T... value) {
		for (T temp : value) {
			queue.add(temp);
		}
	}

	/**
	 * adds an item to the queue
	 * 
	 * @param item the value to add
	 */
	@Override
	public void offer(T item) {
		queue.add(item);
	}

	/**
	 * removes the last element of the queue
	 * 
	 * @return T the value removed
	 */
	@Override
	public T poll() {
		T temp = queue.get(size());
		queue.remove(queue.indexOf(queue.get(size())));
		return temp;
	}

	/**
	 * outputs the top element
	 * 
	 * @return T outputs the last element in the queue
	 */
	@Override
	public T peek() {
		return queue.get(size() - 1);
	}

	/**
	 * outputs the size of the queue
	 * 
	 * @return int the size of the queue
	 */
	@Override
	public int size() {
		return queue.size();
	}

	/**
	 * outputs if there are no elements in the queue
	 * 
	 * @return boolean true or false if there are elements or not
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * creates a new queue
	 */
	@Override
	public void clear() {
		queue = new MyLinkedList<T>();
	}

}
