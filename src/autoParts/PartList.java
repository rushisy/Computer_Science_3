package autoParts;

import java.io.IOException;
import java.util.TreeMap;

public class PartList {
	private TreeMap<Part, Integer> partsMap;

	public PartList() {

	}

	public PartList(String fileName) {
		this();
		try {
			// add code here to read from the file
			// and add Parts to the map

		} catch (IOException e) // Most specific exceptions must be listed 1st
		{
			System.out.println(e);
		} catch (RuntimeException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// no code needed here
		}
	}

	public String toString() {
		String output = "";

		return output;
	}
}