package majorLab;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoggleSolver {
	private Set<String> dictionary;
	private Set<String> validWords;
	private boolean[][] visited;
	private BoggleBoard board;

	/**
	 * preferred constructor that instantiates primarily the dictionary; however,
	 * instantiates some of the other global variables
	 * 
	 * @param dictionaryName the filename of the dictionary to transfer
	 */
	public BoggleSolver(String dictionaryName) {
		try {
			dictionary = new HashSet<String>();
			validWords = new HashSet<String>();
			Scanner key = new Scanner(new File(dictionaryName));
			while (key.hasNextLine())
				dictionary.add(key.nextLine());
		} catch (Exception e) {
			System.out.println("File not found!");
		}
	}

	/**
	 * outputs a set with all the possible words in the 4x4 grid and calls the
	 * helper method to find the possible words
	 * 
	 * @param board the board to check for possible words
	 * @return Iterable<String>(in this case hashSet) the valid words in the grid
	 */
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		this.board = board;
		visited = new boolean[board.rows()][board.cols()];
		for (int i = 0; i < board.rows(); i++)
			for (int j = 0; j < board.cols(); j++)
				helper(i, j, "");
		return validWords;
	}

	/**
	 * a helper method to find all the possible words from a point
	 * 
	 * @param i    the x coordinate value currently
	 * @param j    the y coordinate value currently
	 * @param word the valid word longer than 2 characters
	 */
	public void helper(int x, int y, String word) {
		if (word.length() >= 3 && dictionary.contains(word))
			validWords.add(word);

		if (x < 0 || x == board.rows() || y < 0 || y == board.cols() || visited[x][y])
			return;

		visited[x][y] = true; // used to denote the value is cannot be used in the word
		helper(x + 1, y, word + specialCase(x, y)); // checks the 8 paths possible -- right
		helper(x - 1, y, word + specialCase(x, y)); // checks the 8 paths possible -- left
		helper(x, y + 1, word + specialCase(x, y)); // checks the 8 paths possible -- top center
		helper(x, y - 1, word + specialCase(x, y)); // checks the 8 paths possible -- bottom center
		helper(x + 1, y + 1, word + specialCase(x, y)); // checks the 8 paths possible -- top right
		helper(x + 1, y - 1, word + specialCase(x, y)); // checks the 8 paths possible -- bottom right
		helper(x - 1, y - 1, word + specialCase(x, y)); // checks the 8 paths possible -- bottom left
		helper(x - 1, y + 1, word + specialCase(x, y)); // checks the 8 paths possible -- top left
		visited[x][y] = false; // resets for next point
	}

	/**
	 * checks if the character at a position is the special case of 'Q'
	 * 
	 * @param i the x coordinate of place to check
	 * @param j the y coordinate of place to check
	 * @return String "Qu" if it is the special case else a regular character
	 */
	public String specialCase(int x, int y) {
		if (board.getLetter(x, y) == 'Q')
			return "QU";
		return board.getLetter(x, y) + "";
	}

	/**
	 * checks how many points a word is worth based on its length
	 * 
	 * @param word the word the check
	 * @return int the score of the word
	 */
	public int scoreOf(String word) {
		if (word.length() <= 4)
			return 1;
		else if (word.length() == 5)
			return 2;
		else if (word.length() == 6)
			return 3;
		else if (word.length() == 7)
			return 5;
		else if (word.length() >= 8)
			return 11;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("WORKING");

		final String PATH = "";
		BoggleBoard board = new BoggleBoard(PATH + "board-points26539.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-zingarelli2005.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints);
	}
}
