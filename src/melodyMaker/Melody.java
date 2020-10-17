package melodyMaker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
	private Queue<Note> notes;
	private Queue<Note> music;
	private int size;

	/**
	 * preferred constructor
	 * 
	 * @param song input queue
	 */
	public Melody(Queue<Note> song) {
		notes = new LinkedList<Note>();
		notes = song;

		music = new LinkedList<Note>();
		music = notes;

		size = notes.size();
	}

	/**
	 * gets the duration
	 * 
	 * @return double the total duration
	 */
	public double getTotalDuration() {
		double output = 0;

		for (int i = 0; i < size; i++) {

			output += notes.peek().getDuration();

			Note temp = notes.peek();
			notes.remove(notes.peek());
			music.add(temp);
		}

		return output;
	}

	/**
	 * outputs the notes
	 * 
	 * @return String the output in the format
	 */
	public String toString() {
		int size = notes.size();
		String output = "";

		for (int i = 0; i < size; i++) {
			output += notes.peek().toString() + "\n";

			Note temp = notes.peek();
			notes.remove(notes.peek());
			music.add(temp);
		}

		return output;
	}

	/**
	 * changes the tempo
	 * 
	 * @param tempo the tempo to change to
	 */
	public void changeTempo(double tempo) {

		for (int i = 0; i < size; i++) {
			notes.peek().setDuration(notes.peek().getDuration() * tempo);

			Note temp = notes.peek();
			notes.remove(notes.peek());
			music.add(temp);
		}
	}

	/**
	 * reverses the stack
	 */
	public void reverse() {
		Stack<Note> temp = new Stack<>();
		while (!notes.isEmpty()) {
			temp.add(notes.peek());
			notes.remove();
		}

		while (!temp.isEmpty()) {
			notes.add(temp.peek());
			temp.pop();
		}
	}

	/**
	 * gets the notes in the queue
	 * 
	 * @return Queue<Note> the queue of the queue
	 */
	public Queue<Note> getNotes() {
		return notes;
	}

	/**
	 * adds a song to the queue
	 * 
	 * @param other inputs a song to add
	 */
	void append(Melody other) {
		Queue<Note> temp = new LinkedList<Note>();
		temp = other.getNotes();

		while (!temp.isEmpty()) {
			notes.add(temp.peek());
			temp.remove();
			size++;
		}
	}

	/**
	 * plays the notes in the queue
	 */
	public void play() {
		int counter = 0;

		for (int i = 0; i < size; i++) {
			notes.peek().play();

			Note temp = notes.peek();
			notes.remove(notes.peek());
			music.add(temp);

			if (notes.peek().isRepeat() && counter < 2) {
				repeat();
				counter++;
				counter = 0;
			}

			temp = notes.peek();
			notes.remove(notes.peek());
			music.add(temp);

		}
	}

	/**
	 * repeats the section specified
	 * 
	 * @return Queue<Note> outputs the queue repeated section
	 */
	public void repeat() {
		Queue<Note> repeat = new LinkedList<Note>();
		int counter = 0;

		for (int i = 0; i < size; i++) {
			if (notes.peek().isRepeat()) {
				counter++;
				Note temp = notes.peek();
				notes.remove(notes.peek());
				music.add(temp);
			}
			if (notes.peek().isRepeat() || counter == 1) {
				if (notes.peek().isRepeat() == false) {
					repeat.add(notes.peek());

					Note temp = notes.peek();
					notes.remove(notes.peek());
					music.add(temp);
				} else {
					repeat.add(notes.peek());

					counter++;
					Note temp = notes.peek();
					notes.remove(notes.peek());
					music.add(temp);
				}

			}
		}
		int t = repeat.size();
		for (int i = 0; i < t; i++) {
			repeat.peek().play();
		}
	}
}
