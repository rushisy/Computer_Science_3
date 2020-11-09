package majorLab;

public interface GenericIMap<K, V> {
	/**
	 * Add the key/value pair to the table
	 * 
	 * @return the number previously associated with person, or null
	 */
	V put(K key, V value);

	/**
	 * perform a table lookup
	 * 
	 * @param person
	 * @return phone number mapped to this person
	 */
	V get(K key);

	/** return the current number of key/value pairs in the map */
	int size();

	/**
	 * Remove supplied key (person)
	 * 
	 * @return value mapped to supplied person, or null
	 */
	V remove(K key);
}
