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

	public Iterable<String> getAllValidWords(BoggleBoard board) {
		this.board = board;
		visited = new boolean[board.rows()][board.cols()];
		for (int i = 0; i < board.rows(); i++)
			for (int j = 0; j < board.cols(); j++)
				helper(i, j, 0, "");
		return validWords;
	}

	public void helper(int i, int j, int size, String word) {
		if (size >= 3 && dictionary.contains(word))
			validWords.add(word);

		if (i < 0 || i >= board.rows() || j < 0 || j >= board.cols() || visited[i][j])
			return;
		visited[i][j] = true;
		int add = 1;
		if (addition(i, j).equals("Qu"))
			add = 2;
		helper(i + 1, j, size + add, word + addition(i, j));
		helper(i - 1, j, size + add, word + addition(i, j));
		helper(i, j + 1, size + add, word + addition(i, j));
		helper(i, j - 1, size + add, word + addition(i, j));
		helper(i + 1, j + 1, size + add, word + addition(i, j));
		helper(i + 1, j - 1, size + add, word + addition(i, j));
		helper(i - 1, j - 1, size + add, word + addition(i, j));
		helper(i - 1, j + 1, size + add, word + addition(i, j));
		visited[i][j] = false;
	}

	public String addition(int i, int j) {
		if (board.getLetter(i, j) == 'Q')
			return "Qu";
		return board.getLetter(i, j) + "";
	}

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
		BoggleBoard board = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints);
	}
}
