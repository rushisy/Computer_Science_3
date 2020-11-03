package tableOfIntegers;

import java.util.LinkedList;

public class HashTable {
	private LinkedList[] table;

	/**
	 * default constructor
	 */
	public HashTable() {
		table = new LinkedList[10];
	}

	/**
	 * inserts object into the hash table
	 * 
	 * @param obj the object to add
	 */
	public void add(Object obj) {
		int i = obj.hashCode();
		if (table[i] == null)
			table[i] = new LinkedList();
		if (!table[i].contains(((Number) obj).getValue())) {
			table[i].add(((Number) obj).getValue()); 
		}

	}

	/**
	 * prints the hash table in the desired output
	 * 
	 * @return String the hash table
	 */
	public String toString() {
		String output = "HASHTABLE\n";
		for (int i = 0; i < table.length; i++) {
			output += "bucket " + i + ": " + table[i].toString().substring(1, table[i].toString().length() - 1) + "\n";
		}
		return output;
	}
}