package ShoppingCart;

/**
* Stores information about a collection (list) of Items for sale
*/
import java.util.ArrayList;

public class Catalog {
	private String name;
	private ArrayList<Item> list;

	/*
	 * Contructor that instantiates the array list.
	 * 
	 * @param name the name of the catalog
	 */
	public Catalog(String name) {
		this.name = name;
		list = new ArrayList<Item>();
	}

	/*
	 * Adds an item to the list
	 * 
	 * @param item an object from the Item class
	 */
	public void add(Item item) {
		list.add(item);
	}

	/*
	 * Returns the number of items in the list
	 * 
	 * @return the size of the array list
	 */
	public int size() {
		return list.size();
	}

	/*
	 * Returns the item at the supplied index
	 * 
	 * @param index the position of the item
	 * 
	 * @return the item at the specified position
	 */
	public Item get(int index) {
		return list.get(index);
	}

	/*
	 * Returns the name of the catalog
	 * 
	 * @return the name of the array list
	 */
	public String getName() {
		return name;
	}
}