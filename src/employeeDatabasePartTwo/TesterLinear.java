package employeeDatabasePartTwo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TesterLinear {
	public static void main(String[] args) throws IOException {
		/*****************************************************************************/

		long startBuildTable = System.currentTimeMillis();
		Scanner large = new Scanner(new File("Large Data Set.txt"));
		EmployeeDatabaseLinear database = new EmployeeDatabaseLinear(50000);

		while (large.hasNextLine()) {
			String[] line = large.nextLine().split(" ");
			database.put(Integer.parseInt(line[0]), line[1] + " " + line[2]);
		}

		long stopBuildTable = System.currentTimeMillis();

		/*****************************************************************************/

		long startSuccessfulSearch = System.currentTimeMillis();
		Scanner successful = new Scanner(new File("Successful Search Records.txt"));

		while (successful.hasNextLine()) {
			String[] line = successful.nextLine().split(" ");
			database.get(Integer.parseInt(line[0]));
		}

		long stopSuccessfulSearch = System.currentTimeMillis();

		/*****************************************************************************/

		long startUnsuccessfulSearch = System.currentTimeMillis();
		Scanner unsuccessful = new Scanner(new File("Unsuccessful Search Records.txt"));

		while (unsuccessful.hasNextLine()) {
			String[] line = unsuccessful.nextLine().split(" ");
			database.get(Integer.parseInt(line[0]));
		}

		long stopUnsuccessfulSearch = System.currentTimeMillis();

		/*****************************************************************************/

		String output = "";
		BufferedWriter writer = new BufferedWriter(new FileWriter("Linear Report.txt"));

		output += "Type of Hashing: Linear Probing\n";
		output += "Type of Hash Function: key % table.length\n";
		output += "Number of Records Added: " + database.recordSize() + "\n";
		output += "Table Size: " + database.size();
		output += "Load Factor: " + (double) database.recordSize() / database.size() + "\n";
		output += "Average Insertion Time: " + (long) (stopBuildTable - startBuildTable) + " milliseconds\n";
		output += "Number of Insertion Collisions: " + database.getCollisions() + "\n";
		output += "Number of Collisions vs Insertions: " + (database.getCollisions() / database.recordSize()) * 100
				+ "%\n";
		output += "Average Time to find Table Entry: " + (stopSuccessfulSearch - startSuccessfulSearch)
				+ " milliseconds\n";
		output += "Average Number of Probes to find Table Entry: " + database.getProbes() / 2 + "\n";
		output += "Average Time to NOT find Table Entry: " + (stopUnsuccessfulSearch - startUnsuccessfulSearch)
				+ " milliseconds\n";
		output += "Average Number of Probes to NOT find Table Entry: " + database.getProbes() / 2;
		writer.write(output);
		writer.close();
	}
}
