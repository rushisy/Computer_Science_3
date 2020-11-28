package forestFire;

public class FireModel {
	public static int SIZE = 47;
	private FireCell[][] myGrid;
	private FireView myView;
	private int tracker;

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

	public void solve() {
		for (int i = 0; i < 46; i++) {
			if (myGrid[46][i].getStatus() == 1) {
				myGrid[46][i].setStatus(2);
				solveHelper(45, i);
			}
		}
		for (int i = 0; i < 46; i++) {
			if (myGrid[0][i].getStatus() == 2) {
				System.out.println("Onett is in trouble!");
				myView.updateView(myGrid);
				return;
			}
		}
		System.out.println("Onett is safe.");
		myView.updateView(myGrid);
	}

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
		} catch (Exception e) {
			myGrid[x][y].setStatus(2);
			solveHelper(x - 1, y);
			solveHelper(x + 1, y);
			solveHelper(x, y - 1);
			solveHelper(x, y + 1);
		}
	}

	public boolean inBounds(int x, int y) {
		return x < 47 && x > -1 && y < 47 && y > -1;
	}
}
