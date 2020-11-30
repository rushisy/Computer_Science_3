package forestFire;

public class FireModel {
	public static int SIZE = 47;
	private FireCell[][] myGrid;
	private FireView myView;
	private int tracker;

	/**
	 * preferred constructor that was given to us
	 * 
	 * @param view the cell creation
	 */
	public FireModel(FireView view) {
		myGrid = new FireCell[SIZE][SIZE];
		int setNum = 0;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				myGrid[r][c] = new FireCell();
			}
		}
		myView = view;
		myView.updateView(myGrid);
	}

	/**
	 * a method that sets the scene of the fire and calls the recursive helper
	 * method
	 */
	public void solve() {
		for (int i = 0; i < 47; i++) { // sets the bottom most layer to fire (and spreads it <-- helper method)
			if (myGrid[46][i].getStatus() == 1) {
				myGrid[46][i].setStatus(2);
				solveHelper(45, i);
			}
		}
		for (int i = 0; i < 47; i++) { // checks if the top most layer is on fire
			if (myGrid[0][i].getStatus() == 2) {
				System.out.println("Onett is in trouble!");
				myView.updateView(myGrid);
				return;
			}
		}
		myView.updateView(myGrid);
		System.out.println("Onett is safe.");

	}

	/**
	 * a recursive helper method to set each horizontal and vertical tree on fire
	 * 
	 * @param x the current x coordinate
	 * @param y the current y coordinate
	 */
	public void solveHelper(int x, int y) {
		try {
			if (!inBounds(x, y) || myGrid[x][y].getStatus() != 1)
				return;
			else if (myGrid[x - 1][y].getStatus() != 0 || myGrid[x][y - 1].getStatus() != 0
					|| myGrid[x + 1][y].getStatus() != 0 || myGrid[x][y + 1].getStatus() != 0) {
				myGrid[x][y].setStatus(2);
				solveHelper(x - 1, y);
				solveHelper(x + 1, y);
				solveHelper(x, y - 1);
				solveHelper(x, y + 1);
			}
		} catch (Exception e) { // i confirmed that all the points being catched are tree spaces: just uncomment
								// the line below to check urself
			// System.out.println(myGrid[x][y].getStatus()); // debug (should equal 1 for
			// all of them (1 == tree) <-- this
			// also is before it changes status

			myGrid[x][y].setStatus(2);

			solveHelper(x - 1, y);
			solveHelper(x + 1, y);
			solveHelper(x, y - 1);
			solveHelper(x, y + 1);
		}
	}

	/**
	 * helper method to see if the coordinate is in the matrix
	 * 
	 * @param x the x coordinate to check
	 * @param y the y coordinate to check
	 * @return boolean the coordinates are both in bound
	 */
	private boolean inBounds(int x, int y) {
		return x < 47 && x > -1 && y < 47 && y > -1;
	}
}
