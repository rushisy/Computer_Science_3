package minHeap;

public class MinHeap {
	private Integer[] heap;
	private int size;
	private static final int DEFAULT_CAPACITY = 8;

	public MinHeap() {
		size = DEFAULT_CAPACITY;
		heap = new Integer[size];
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peekMinimum() {
		return heap[0];
	}

	public int getLeftChildIndex(int index) {
		if (2 * index + 1 < size)
			return 2 * index + 1;
		return -1;
	}

	public int getRightChildIndex(int index) {
		if (2 * index + 2 < size)
			return 2 * index + 2;
		return -1;
	}

	public int getParentIndex(int index) {
		if ((index - 1) / 2 < size)
			return (index - 1) / 2;
		return -1;
	}

	private void doubleCapacity() {
		Integer[] newList = new Integer[size * 2];
		for (int i = 0; i < size; i++)
			newList[i] = heap[i];
		heap = newList;
	}

	public void insert(int value) {
	}

	private void bubbleUp(int index) {

	}

	public int popMinimum() {
		int min = peekMinimum();
		return -1;
	}

	private void siftDown(int index) {
		Integer[] newList = new Integer[size - 1];
		for (int i = 1; i < size; i++) {
			newList[i - 1] = heap[i];
		}
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
