package linkedListQueue;

public class MyLinkedList<T> {
	private ListNode head;

	/**
	 * default constructor
	 */
	public MyLinkedList() {
		head = null;
	}

	/**
	 * varargs constructor
	 * 
	 * @param value the data to assign in the linkedlist
	 */
	public MyLinkedList(T... value) {
		for (T num : value) {
			add(num);
		}
	}

	/**
	 * preferred constructor
	 * 
	 * @param val the variable to assign head
	 */
	public MyLinkedList(T val) {
		head = new ListNode(val);
		head.next = null;
	}

	/**
	 * adds the value to the end of the list
	 * 
	 * @param newVal value to assign the new node
	 */
	public void add(T newVal) {
		if (isEmpty()) {
			head = new ListNode(newVal);
			return;
		}

		ListNode position = head;

		while (position.next != null) {
			position = position.next;
		}

		position.next = new ListNode(newVal);
	}

	/**
	 * outputs if the value is contained in the list
	 * 
	 * @param target the key to search for
	 * @return boolean true if value is found else false
	 */
	public boolean contains(T target) {
		if (isEmpty()) {
			return false;
		}

		ListNode position = head;

		while (position.next != null) {

			if (position.getVal().equals(target))
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
	public int indexOf(T target) {
		ListNode position = head;
		int counter = -1;

		if (isEmpty())
			return -1;
		else if (head.getVal().equals(target))
			return 0;

		while (position != null) {
			counter++;
			if (position.getVal().equals(target)) {
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
	public T get(int index) {
		if (isEmpty() || index < 0 || index > size()) {
			return null;
		} else if (index == 0)
			return head.getVal();

		ListNode position = head;

		for (int i = 0; i < index; i++) {
			if (position == null)
				return null;
			position = position.next;
		}
		return position.getVal();
	}

	/**
	 * changes a position in the list to a new node
	 * 
	 * @param newVal the value to change it to
	 * @param index  the position it is at
	 */
	public void set(T newVal, int index) {
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
		position.setVal(newVal);
	}

	/**
	 * outputs the length of the list
	 * 
	 * @return int the total length of the list
	 */
	public int size() {
		int counter = 0;

		if (isEmpty())
			return 0;

		ListNode position = head;

		while (position.next != null) {
			counter++;
			position = position.next;
		}
		counter++;
		return counter;
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
	public T remove(int index) {
		if (isEmpty() || index < 0 || index > size())
			return null;
		else if (index == 0) {
			T output = head.getVal();
			head = head.next;
			return output;

		}

		ListNode position = head;

		for (int i = 0; i < index - 1; i++) {
			if (position == null)
				return null;
			position = position.next;
		}

		T output = position.getVal();

		position.next = position.next.next;
		return output;
	}

	/**
	 * adds a node at a specified location
	 * 
	 * @param newVal the value of the new node
	 * @param index  the index at which to add the node
	 */
	public void add(T newVal, int index) {
		if (isEmpty() || index < 0 || index > size())
			return;
		else if (index == size()) {
			add(newVal);
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
		T val;
		ListNode next;

		/**
		 * preferred constructor
		 * 
		 * @param val the value of the node
		 */
		public ListNode(T val) {
			this.val = val;
		}

		/**
		 * gets the object data
		 * 
		 * @return T the val variable
		 */
		public T getVal() {
			return val;
		}

		/**
		 * sets the object data to the input
		 * 
		 * @param input the new data to assign
		 */
		public void setVal(T input) {
			val = input;
		}

		/**
		 * outputs the node in the desired format
		 * 
		 * @return String the value of the node
		 */
		@Override
		public String toString() {
			return "" + this.val;// for printing / debug}
		}
	}
}
