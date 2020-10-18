package gemMatching;

public class GemList {
	private Node head;
	private int size;

	/**
	 * default constructor
	 */
	public GemList() {
		head = null;
		size = 0;
	}

	/**
	 * outputs the total size of the list
	 * 
	 * @return int the length of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * draws the gem list
	 * 
	 * @param y the input y axis to place the gems
	 */
	public void draw(double y) {
		Node position = head;
		int counter = 0;
		while (position != null) {
			position.getGem().draw(GemGame.indexToX(counter), y);
			position = position.next;
			counter++;
		}
	}

	/**
	 * adds an item to the list
	 * 
	 * @param newVal the value to add
	 */
	public void add(Gem newVal) {
		if (head == null) {
			head = new Node(newVal);
			size++;
			return;
		}

		Node position = head;

		while (position.next != null) {
			position = position.next;
		}

		position.next = new Node(newVal);
		size++;
	}

	/**
	 * adds the new value at the index prior
	 * 
	 * @param gem   the value to add
	 * @param index the place to add the node to
	 */
	public void insertBefore(Gem gem, int index) {
		if (index == 0) {
			Node position = head;
			head = new Node(gem);
			head.next = position;
			size++;
			return;
		}
		if (head == null) {
			head = new Node(gem);
			size++;
			return;
		} else if (index >= size()) {
			add(gem);
			return;
		}

		Node position = head;

		for (int i = 0; i < index - 1; i++) { // one before index
			if (position == null)
				return;
			position = position.next;
		}

		Node temp = new Node(gem); // node to add
		temp.next = position.next; // null becomes temp && adds rest of list
		position.next = temp;
		size++;
	}

	/**
	 * outputs the total score of the player
	 * 
	 * @return int the total score
	 */
	public int score() { // fix
		if (size == 0)
			return 0;

		int total = 0;
		Node position = head;
		GemType type = head.gem.getType();
		int counter = 0;
		int tempTotal = 0;

		while (position != null) {
			if (position.gem.getType() == type) {
				counter++;
				tempTotal += position.gem.getPoints();
			} else {
				type = position.gem.getType();
				total += tempTotal * counter;
				counter = 1;
				tempTotal = position.gem.getPoints();
			}
			position = position.next;
		}
		return total + (tempTotal * counter);
	}

	/**
	 * the desired format of the list
	 * 
	 * @return String the data in string representation
	 */
	@Override
	public String toString() {
		String output = "";

		Node position = head;

		while (position != null) {
			output += position.getGem().toString() + " -> ";
			position = position.next;
		}
		if (output != "")
			output = output.substring(0, output.length() - 4);
		return output;
	}

	private class Node {
		private Gem gem;
		private Node next;

		/**
		 * the preferred constructor
		 * 
		 * @param gem the new value of the node
		 */
		public Node(Gem gem) {
			this.gem = gem;
		}

		/**
		 * outputs the gem value
		 * 
		 * @return Gem the gem object
		 */
		public Gem getGem() {
			return gem;
		}
	}

	public static void main(String[] args) {
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99); // not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}
}
