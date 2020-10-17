package majorLab;

public class Square {
	// type
	final static int EMPTY = 0;
	final static int WALL = 1;
	final static int START = 2;
	final static int EXIT = 3;

	// status
	final static char WORKING = 'o';
	final static char EXPLORED = '.';
	final static char ON_EXIT_PATH = 'x';
	final static char UNKNOWN = '_';

	private int row, col;
	private int type;
	private char status;

	/**
	 * prefered constructor
	 * 
	 * @param row  row of the square
	 * @param col  col of the square
	 * @param type type of the square
	 */
	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
		status = UNKNOWN;
	}

	/**
	 * sets the type variable to input
	 * 
	 * @param num the desired variable to set type to
	 */
	public void setType(int num) {
		this.type = num;
	}

	/**
	 * outputs the row
	 * 
	 * @return int the row
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * outputs the col
	 * 
	 * @return int the col
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * outputs the type
	 * 
	 * @return int the type
	 */
	public int getType() {
		return this.type;
	}

	/**
	 * outputs the status
	 * 
	 * @return char the status
	 */
	public char getStatus() {
		return this.status;
	}

	/**
	 * compares input object with current object
	 * 
	 * @param obj square object to compare with
	 * @return boolean true or not if they are the same or not
	 */
	public boolean equals(Square obj) {

		if (this.row == obj.getRow() && this.col == obj.getCol()) {
			return true;
		}
		return false;
	}

	/**
	 * sets the status to unknown
	 */
	public void reset() {
		this.status = UNKNOWN;
	}

	/**
	 * manual change of status
	 * 
	 * @param input the variable to change status to
	 */
	public void setStatus(char input) {
		this.status = input;
	}

	/**
	 * outputs the type/status of one square object
	 * 
	 * @return String the output to display
	 */
	public String toString() {
		switch (this.type) {
		case 0:
			if (this.status == 'o') {
				return "o";
			} else if (this.status == '.') {
				return ".";
			} else
				return "_";
		case 1:
			return "#";
		case 2:
			return "S";
		case 3:
			return "E";
		}
		return null;
	}
}
