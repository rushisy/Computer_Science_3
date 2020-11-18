package minHeap;

public class MinHeap {
	private Integer[] heap;
	private int size;
	private int capacity = 8;

	public MinHeap() {
		size = 0;
		heap = new Integer[capacity + 1];
	}

	public MinHeap(Integer... nums) {
		size = 0;
		heap = new Integer[capacity + 1];
		for (Integer num : nums)
			insert(num);
	}

	public void buildHeap() {
		for (int i = heap.length / 2; i > -1; i--)
			siftDown(i);

	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peekMinimum() {
		return heap[1];
	}

	public int getLeftChildIndex(int index) {
		return 2 * index;
	}

	public int getRightChildIndex(int index) {
		return 2 * index + 1;
	}

	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	public void insert(int value) {
		if (size == capacity) {
			doubleCapacity();
		}
		heap[++size] = value;
		bubbleUp(size);
	}

	private void bubbleUp(int index) {
		while (index > 1 && heap[index / 2] > heap[index]) {
			int temp = heap[index / 2];
			heap[index / 2] = heap[index];
			heap[index] = temp;
			index /= 2;
		}
	}

	public int popMinimum() {
		if (isEmpty())
			return -1;

		int min = heap[1];
		heap[1] = heap[size];
		heap[size] = min;

		if (size != 0)
			siftDown(1);
		size--;
		return min;
	}

	private void siftDown(int index) {
		int position = index;
		if (getLeftChildIndex(index) < size && heap[position] > heap[getLeftChildIndex(index)])
			position = getLeftChildIndex(index);
		else if (getRightChildIndex(index) < size && heap[position] > heap[getRightChildIndex(index)])
			position = getRightChildIndex(index);
		if (position != index) {
			int temp = heap[index];
			heap[index] = heap[position];
			heap[position] = temp;
			siftDown(position);
		}
	}

	public void doubleCapacity() {
		Integer[] array = new Integer[capacity * 2];
		capacity *= 2;
		for (int i = 0; i < heap.length; i++)
			array[i] = heap[i];
		heap = new Integer[capacity];
		heap = array;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 1; i <= getSize(); i++)
			output += heap[i] + ", ";
		return output.substring(0, output.lastIndexOf(","));
	}

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
