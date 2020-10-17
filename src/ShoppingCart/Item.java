package ShoppingCart;

public class Item {
	private String name;
	private double price;
	private int bulkQty;
	private double bulkPrice;

	/*
	 * Calls the four parameter constructor
	 * 
	 * @param name the name of the item
	 * 
	 * @param price the cost of the item
	 */
	public Item(String name, double price) {
		this(name, price, 0, 0);
	}

	/*
	 * Instantiates the object's properties
	 * 
	 * @param name the name of the item
	 * 
	 * @param price the cost of the item
	 * 
	 * @param bulkQty the amount of items for the "discount"
	 * 
	 * @param bulkPrice the price of the bulk quantity
	 */
	public Item(String name, double price, int bulkQty, double bulkPrice) {
		if (price < 0 || bulkQty < 0 || bulkPrice < 0) {
			throw new IllegalArgumentException("error");
		}

		this.name = name;
		this.price = price;
		this.bulkQty = bulkQty;
		this.bulkPrice = bulkPrice;
	}

	/*
	 * Returns the price for a given quantity of items
	 * 
	 * @param quantity the amount of items
	 * 
	 * @return returns the cost of the quantites of items
	 */
	public double priceFor(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("error");
		} else if (quantity - bulkQty >= 0 && bulkQty > 0) {
			double step1 = quantity / bulkQty;
			double step2 = step1 * bulkPrice;
			double step3 = step2 + ((quantity % bulkQty) * price);
			return step3 * 10;
		}
		return quantity * price;

	}

	/*
	 * Returns true if the current item has the same name as the supplied item
	 * 
	 * @param obj the new object to comapare names with
	 * 
	 * @return the boolean value of the similarities
	 */
	@Override
	public boolean equals(Object obj) {
		Item casted = (Item) obj;
		if (this.name.equals((casted.name))) {
			return true;
		}
		return false;
	}

	/*
	 * Returns a string representation of this item
	 * 
	 * @return the string pictorial of the cost, quantity, etc
	 */
	@Override
	public String toString() {
		if (this.bulkPrice > 0) {
			return name + ", $" + price + " (" + bulkQty + " forr $" + bulkPrice + ")";
		}
		return name + ", $" + price;
	}
}