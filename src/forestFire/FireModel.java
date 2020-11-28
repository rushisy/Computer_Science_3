package forestFire;

public class FireModel {
	public static int SIZE = 47;
	private FireCell[][] myGrid;
	private FireView myView;

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
		for(int i = 0; i < myGrid.length; i++) {
			for(int j = 0; j < myGrid[i].length; j++) {
				if(myGrid[i][j].getStatus() == 0)
					myGrid[i][j].setStatus(2);
			}
		}
		myView.updateView(myGrid);
	}

	/*
	 * recursive helper method here
	 */

}
