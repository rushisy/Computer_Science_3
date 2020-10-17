package ShoppingCart;

/**
* stores information about the user's orders
*/
import java.util.*;

public class ShoppingCart {
	private ArrayList<ItemOrder> list;

	/*
	 * Constructor that instantiates the list of item orders
	 */
	public ShoppingCart() {
		list = new ArrayList<ItemOrder>();
	}

	/**
	 * Adds an item order to the list and replaces any previous order for this item
	 * with the new order
	 * 
	 * @param newOrder the order to check if present in the list
	 */
	public void add(ItemOrder newOrder) {
		if (list.size() == 0) {
			list.add(newOrder);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(newOrder)) {
				list.set(i, newOrder);
				return;
			}
		}
		list.add(newOrder);
	}

	/*
	 * returns the total cost of the shopping cart
	 * 
	 * @return the cost in the shopping cart
	 */
	public double getTotal() {
		double cost = 0;

		for (int i = 0; i < list.size(); i++) {
			cost += list.get(i).getPrice();
		}

		return cost;
	}
}
