package linkedListQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
	private Square[][] layout;
	private Square start;
	private Square exit;

	/**
	 * loads the maze up
	 * 
	 * @param filename the file to use
	 * @return boolean true or false if map is loaded
	 */
	public boolean loadMaze(String filename) throws FileNotFoundException {
		try {
			Scanner key = new Scanner(new File(filename));
			int rowLength = key.nextInt();
			int colLength = key.nextInt();

			layout = new Square[rowLength][colLength]; // instantiate matrix

			key = new Scanner(new File(filename)); // reset scanner
			key.nextLine();

			int i = -1; // rows

			while (key.hasNextLine()) {
				String line = key.nextLine(); // line to translate
				line = line.replaceAll(" ", ""); // shrink
				i++;

				for (int j = 0; j < line.length(); j++) {
					String place = Character.toString(line.charAt(j));
					layout[i][j] = new Square(i, j, Integer.parseInt(place));

					if (layout[i][j].toString().equals("E")) { // instantiate exit
						exit = new Square(i, j, 3);
						layout[i][j].setType(3);
					}
					if (layout[i][j].toString().equals("S")) {
						start = new Square(i, j, 2);
						layout[i][j].setType(2);
					}
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * checks the potential neighbors to use
	 * 
	 * @param s the square's neighbors to check
	 * @return List<Square> a list of the neighbors
	 */
	public List<Square> getNeighbors(Square s) {
		ArrayList<Square> output = new ArrayList<Square>();
		if (inBounds(s.getRow() - 1, s.getCol())) { // top
			output.add(new Square(s.getRow() - 1, s.getCol(), layout[s.getRow() - 1][s.getCol()].getType()));
		}

		if (inBounds(s.getRow(), s.getCol() + 1)) { // right
			output.add(new Square(s.getRow(), s.getCol() + 1, layout[s.getRow()][s.getCol() + 1].getType()));
		}
		if (inBounds(s.getRow() + 1, s.getCol())) { // bottom
			output.add(new Square(s.getRow() + 1, s.getCol(), layout[s.getRow() + 1][s.getCol()].getType()));
		}
		if (inBounds(s.getRow(), s.getCol() - 1)) { // left
			output.add(new Square(s.getRow(), s.getCol() - 1, layout[s.getRow()][s.getCol() - 1].getType()));
		}
		return output;
	} 

	/**
	 * returns if the coordinates are in bounds
	 * 
	 * @param r the row
	 * @param c the col
	 * @return boolean if the coordinates are in bounds
	 */
	private boolean inBounds(int r, int c) {
		if (r < layout.length && r >= 0 && c < layout[0].length && c >= 0) {
			return true;
		}

		return false;
	}

	/**
	 * outputs the start variable
	 * 
	 * @return Square the starting square
	 */
	public Square getStart() {
		return start;
	}

	/**
	 * outputs the exit variable
	 * 
	 * @return Square the exit square
	 */
	public Square getExit() {
		return exit;
	}

	/**
	 * resets the maze to default
	 */
	public void reset() {
		try {
			for (int i = 0; i < layout.length; i++) {
				for (int j = 0; j < layout[i].length; j++) {
					layout[i][j].reset();
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * outputs the maze
	 * 
	 * @return String the maze
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[i].length; j++) {
				output += layout[i][j] + " ";
			}
			output += "\n";
		}
		return output;
	}

	/**
	 * changes the value of the square at a point
	 * 
	 * @param row  the row the square is in
	 * @param col  the col the square is in
	 * @param temp the status to change the square to
	 */
	public void assign(int row, int col, char temp) {
		this.layout[row][col].setStatus(temp);
	}

	/**
	 * outputs the matrix
	 * 
	 * @return Square[][] outputs the 2d-matrix
	 */
	public Square[][] getLayout() {
		return this.layout;
	}

}
