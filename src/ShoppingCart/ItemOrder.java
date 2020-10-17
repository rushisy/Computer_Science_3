package ShoppingCart;

public class ItemOrder {
	private Item item;
	private int qty;

	/*
	 * Constructor that creates an item order for the given item and given quantity
	 * 
	 * @param item an object from the Item class
	 * 
	 * @param qty the amount of items for the specified item
	 */
	public ItemOrder(Item item, int qty) {
		this.item = item;
		this.qty = qty;
	}

	/*
	 * Returns the cost for this item order
	 * 
	 * @return the price for the order
	 */
	public double getPrice() {
		return item.priceFor(qty);
	}

	/*
	 * Returns a reference to the item in this order
	 * 
	 * @return the reference for the item
	 */
	public Item getItem() {
		return item;
	}

	/*
	 * Returns true if the current item order contains teh same item as the supplied
	 * one
	 * 
	 * @param obj the object to compare with
	 * 
	 * @return the boolean value of the comparison between the passed object and the
	 * current one
	 */
	@Override
	public boolean equals(Object obj) {
		ItemOrder newObject = (ItemOrder) obj;
		if (newObject.item.equals(this.item)) {
			return true;
		}
		return false;
	}
}