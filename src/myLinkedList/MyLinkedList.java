package myLinkedList;

public class MyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int size;

	/**
	 * default constructor
	 */
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * preferred constructor
	 * 
	 * @param val the variable to assign head
	 */
	public MyLinkedList(int val) {
		head = new ListNode(val);
		head.next = tail;
		size = 1;
	}

	/**
	 * adds the value to the end of the list
	 * 
	 * @param newVal value to assign the new node
	 */
	public void add(int newVal) {
		ListNode node = new ListNode(newVal);

		if (isEmpty()) {
			head = node;
		} else {
			tail.next = node;
		}
		tail = node;
		size++;
	}

	/**
	 * outputs if the value is contained in the list
	 * 
	 * @param target the key to search for
	 * @return boolean true if value is found else false
	 */
	public boolean contains(int target) {
		if (isEmpty()) {
			return false;
		}

		ListNode position = head;

		while (position.next != null) {

			if (position.val == target)
				return true;
			position = position.next;
		}
		return false;
	}

	/**
	 * the opposite as of the get method
	 * 
	 * @param target the value to search for
	 * @return the position the value is at
	 */
	public int indexOf(int target) {
		ListNode position = head;
		int counter = -1;

		if (isEmpty())
			return -1;
		else if (head.val == target)
			return 0;

		while (position != null) {
			counter++;
			if (position.val == target) {
				return counter;
			}

			position = position.next;

		}
		return -1;
	}

	/**
	 * outputs the value at the index
	 * 
	 * @param index the position to look at
	 * @return int the value at index
	 */
	public int get(int index) {
		if (isEmpty() || index < 0 || index > size()) {
			return -1;
		} else if (index == 0)
			return head.val;

		ListNode position = head;

		for (int i = 0; i < index; i++) {
			if (position == null)
				return -1;
			position = position.next;
		}
		return position.val;
	}

	/**
	 * changes a position in the list to a new node
	 * 
	 * @param newVal the value to change it to
	 * @param index  the position it is at
	 */
	public void set(int newVal, int index) {
		if (isEmpty() || index < 0 || index > size())
			return;
		else if (index == 0) {
			head = new ListNode(newVal);
			return;
		}

		ListNode position = head;
		for (int i = 0; i < index; i++) {
			if (position == null)
				return;
			position = position.next;
		}
		position.val = newVal;
	}

	/**
	 * outputs the length of the list
	 * 
	 * @return int the total length of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * outputs if the list is empty or not
	 * 
	 * @return boolean true if the list is empty, else false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * removes a node from the list
	 * 
	 * @param index the position to remove
	 * @return int the value removed
	 */
	public int remove(int index) {
		if (isEmpty() || index < 0 || index > size())
			return -1;
		else if (index == 0) {
			int output = head.val;
			head = head.next;
			size--;
			return output;

		}

		ListNode position = head;

		for (int i = 0; i < index - 1; i++) {
			if (position == null)
				return -1;
			position = position.next;
		}

		int output = position.val;

		position.next = position.next.next;
		size--;
		return output;
	}

	/**
	 * adds a node at a specified location
	 * 
	 * @param newVal the value of the new node
	 * @param index  the index at which to add the node
	 */
	public void add(int newVal, int index) {
		if (isEmpty() || index < 0 || index > size())
			return;
		else if (index == size()) {
			add(newVal);
			size++;
			return;
		}

		ListNode position = head;

		for (int i = 0; i < index - 1; i++) { // one before index
			if (position == null)
				return;
			position = position.next;
		}

		ListNode temp = new ListNode(newVal); // node to add
		temp.next = position.next; // null becomes temp && adds rest of list
		position.next = temp;
		size++;
	}

	/**
	 * the list in the desired format
	 * 
	 * @return String the desired format
	 */
	@Override
	public String toString() {
		String output = "[";
		ListNode position = head;
		while (position != null) {
			output += position + ", ";
			position = position.next;
		}

		if (!output.equals("[")) {
			output = output.substring(0, output.length() - 2);
		}

		output += "]";
		return output;
	}

	private class ListNode {
		int val;
		ListNode next;

		/**
		 * prefered constructor
		 * 
		 * @param val the value of the node
		 */
		public ListNode(int val) {
			this.val = val;
		}
	}
}
