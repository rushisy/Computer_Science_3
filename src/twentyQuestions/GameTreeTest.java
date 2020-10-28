package twentyQuestions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // run methods in numerical order
public class GameTreeTest {
	static final String PATH = ""; // change if your data files are stored in another directory
	static GameTree aGame;

	@BeforeClass  
	public static void setUp() throws FileNotFoundException {
		PrintWriter outFile = new PrintWriter(new FileOutputStream(PATH + "animals.txt"));
		outFile.println("Has feathers?");
		outFile.println("Barnyard?");
		outFile.println("chicken");
		outFile.println("owl");
		outFile.println("Is it a mammal?");
		outFile.println("tiger");
		outFile.println("rattlesnake");
		outFile.close();
	}

	// This code executes once and only once before an @Test method runs.
	// Good for initialization.
	// This allows you to ALWAYS begin with the same exact questions and answers.
	@Test
	public void test01_rootNodeAtStart() {
		assertEquals("Has feathers?", aGame.getCurrent());
	}

	@Test
	public void test02_foundAnswerAtStart() {
		assertFalse("Found answer should be false", aGame.foundAnswer());
	}

	@Test
	public void test03_makeFirstYesChoice() {
		aGame = new GameTree(PATH + "animals.txt");
		aGame.playerSelected(Choice.Yes);
		assertEquals("Barnyard?", aGame.getCurrent());
	}

	@Test
	public void test04_checkFoundAnswerAgain() {
		aGame = new GameTree(PATH + "animals.txt");
		assertFalse("Should not be at a leaf node yet", aGame.foundAnswer());
	}

	@Test
	public void test05_makeNoChoice() {
		aGame = new GameTree(PATH + "animals.txt");
		aGame.playerSelected(Choice.Yes);
		aGame.getCurrent();
		aGame.playerSelected(Choice.No);
		assertEquals("owl", aGame.getCurrent());
	}

	@Test
	public void test06_foundAnAnswerNode() {
		aGame = new GameTree(PATH + "animals.txt");
		aGame.playerSelected(Choice.Yes);
		aGame.getCurrent();
		aGame.playerSelected(Choice.No);
		aGame.getCurrent();
		assertTrue(aGame.foundAnswer());
	}

	@Test
	public void test07_testSaveGame() throws FileNotFoundException {
		setUp();
		aGame = new GameTree(PATH + "animals.txt");
		aGame.playerSelected(Choice.Yes);
		aGame.playerSelected(Choice.Yes);
		// Add new question and make the current data the new answer
		aGame.add("Can it swim?", "goose");
		aGame.getCurrent();
		assertEquals("Can it swim?", aGame.getCurrent());
		aGame.saveGame();

		// Add another answer
		aGame.reStart();
		aGame.playerSelected(Choice.Yes);
		aGame.getCurrent();
		aGame.playerSelected(Choice.Yes);
		aGame.playerSelected(Choice.Yes);
		aGame.getCurrent();
		assertEquals("goose", aGame.getCurrent());
		assertTrue(aGame.foundAnswer());
		aGame.add("Does it croak?", "frog");
		aGame.saveGame();
		aGame.getCurrent();
		assertEquals("Can it swim?", aGame.getCurrent());

		GameTree anotherGame = new GameTree(PATH + "animals.txt");
		anotherGame.playerSelected(Choice.Yes);
		anotherGame.getCurrent();
		anotherGame.playerSelected(Choice.Yes);
		anotherGame.getCurrent();
		assertEquals("Does it croak?", anotherGame.getCurrent());

		assertFalse(anotherGame.foundAnswer());
		anotherGame.playerSelected(Choice.No);
		anotherGame.getCurrent();
		assertTrue(anotherGame.foundAnswer());
		assertEquals("goose", anotherGame.getCurrent());

		anotherGame.reStart();
		anotherGame.playerSelected(Choice.Yes);
		anotherGame.getCurrent();
		anotherGame.playerSelected(Choice.Yes);
		anotherGame.getCurrent();
		anotherGame.playerSelected(Choice.Yes);
		assertEquals("Does it croak?", anotherGame.getCurrent());
		assertFalse(anotherGame.foundAnswer());
		anotherGame.playerSelected(Choice.No);
		anotherGame.getCurrent();
		assertTrue(anotherGame.foundAnswer());
		assertEquals("goose", anotherGame.getCurrent());
	}
}
