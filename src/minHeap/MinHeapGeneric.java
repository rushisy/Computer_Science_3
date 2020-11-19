package minHeap;

public class MinHeapGeneric<T extends Comparable<T>> {
	private T[] heap;
	private int size;
	private int capacity = 8;

	/**
	 * default constructor
	 */
	public MinHeapGeneric() {
		size = 0;
		heap = (T[]) new Comparable[capacity + 1];
	}

	/**
	 * preferred constructor
	 * 
	 * @param nums varargs of integers to add to the queue
	 */
	public MinHeapGeneric(T... nums) {
		size = 0;
		heap = (T[]) new Comparable[capacity + 1];
		for (T num : nums)
			insert(num);
	}

	/**
	 * creates the heap in n log n time
	 */
	public void buildHeap() {
		for (int i = heap.length / 2; i > -1; i--)
			siftDown(i);

	}

	/**
	 * outputs the current position (also the size) of the used array
	 * 
	 * @return int the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * outputs if there are no elements in the array
	 * 
	 * @return boolean true if none are present
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * outputs the first element in the heap
	 * 
	 * @return int the value at the first element
	 */
	public T peekMinimum() {
		return heap[1];
	}

	/**
	 * outputs the left child of the index
	 * 
	 * @param index the current position to find the left child of
	 * @return int the position of the left child
	 */
	public int getLeftChildIndex(int index) {
		return 2 * index;
	}

	/**
	 * outputs the right child of the index
	 * 
	 * @param index the current position to find the right child of
	 * @return int the position of the right child
	 */
	public int getRightChildIndex(int index) {
		return 2 * index + 1;
	}

	/**
	 * outputs the parent of the index
	 * 
	 * @param index the current position to find the parent of
	 * @return int the position of the parent
	 */
	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	/**
	 * adds an element to the heap
	 * 
	 * @param value the value to add
	 */
	public void insert(T value) {
		if (size == capacity) {
			doubleCapacity();
		}
		heap[++size] = value;
		bubbleUp(size);
	}

	/**
	 * restructures the tree
	 * 
	 * @param index the next available value to bubble up
	 */
	private void bubbleUp(int index) {
		while (index > 1 && (Integer) heap[index / 2] > (Integer) heap[index]) {
			T temp = heap[index / 2];
			heap[index / 2] = heap[index];
			heap[index] = temp;
			index /= 2;
		}
	}

	/**
	 * removes the smallest value
	 * 
	 * @return int the value removed
	 */
	public T popMinimum() {
		if (isEmpty())
			return null;

		T min = heap[1];
		heap[1] = heap[size];
		heap[size] = min;

		if (size != 0)
			siftDown(1);
		size--;
		return min;
	}

	/**
	 * helper method that bubbles down the heap
	 * 
	 * @param index the position to bubble down to
	 */
	private void siftDown(int index) {
		int position = index;
		if (getLeftChildIndex(index) < size && (Integer) heap[position] > (Integer) heap[getLeftChildIndex(index)])
			position = getLeftChildIndex(index);
		else if (getRightChildIndex(index) < size
				&& (Integer) heap[position] > (Integer) heap[getRightChildIndex(index)])
			position = getRightChildIndex(index);
		if (position != index) {
			T temp = heap[index];
			heap[index] = heap[position];
			heap[position] = temp;
			siftDown(position);
		}
	}

	/**
	 * doubles the capcity of the array
	 */
	public void doubleCapacity() {
		T[] array = (T[]) new Comparable[capacity * 2];
		capacity *= 2;
		for (int i = 0; i < heap.length; i++)
			array[i] = heap[i];
		heap = (T[]) new Comparable[capacity];
		heap = array;
	}

	/**
	 * outputs the array in the heap format
	 * 
	 * @return String the array in the desired format
	 */
	@Override
	public String toString() {
		String output = "";
		for (int i = 1; i <= getSize(); i++)
			output += heap[i] + ", ";
		return output.substring(0, output.lastIndexOf(","));
	}

	/**
	 * provided method to build the tree shape
	 */
	public void display() {
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);
		while (j <= this.getSize()) {
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');
			System.out.print((heap[j] == null) ? "" : heap[j]);
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			j++;
		}
		System.out.println("\n" + dots + dots);
	}
}
