package majorLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class HuffmanCompressor {

	public static void main(String[] args) throws Exception {
		String filename = "Hamlet.txt";
		compress(filename);
		expand("code.code", "new.new");
	}

	/**
	 * compresses the file (ie. codes and then encodes)
	 * 
	 * @param filename the file to compress
	 */
	public static void compress(String filename) throws Exception {
		FileReader input = new FileReader(filename);
		String[] list2 = new String[257];
		int[] list = new int[256];
		int counter = input.read();
		Scanner key2 = new Scanner(new File("code.code"));
		FileReader input2 = new FileReader(filename);
		BitOutputStream output = new BitOutputStream(new PrintStream("short.short"), false);

		while (counter != -1) {
			list[counter]++;
			counter = input.read();
		}
		new HuffmanTree(list).write("code.code");
		input.close();

		while (key2.hasNextLine())
			list2[Integer.parseInt(key2.nextLine())] = key2.nextLine();

		int line = input2.read();
		while (line != -1) {
			if (list2[line] == null)
				throw new Exception();

			for (int i = 0; i < list2[line].length(); i++)
				output.writeBit(list2[line].charAt(i) - '0');

			line = input2.read();
		}
		input2.close();
		for (int i = 0; i < list2[256].length(); i++)
			output.writeBit(list2[256].charAt(i) - (char) 48);

		output.close();

	}

	/**
	 * expands a compressed file
	 * 
	 * @param codefile the code to refer to
	 * @param filename the file to expand to (should look the same)
	 */
	public static void expand(String codefile, String filename) throws FileNotFoundException {
		(new HuffmanTree("code.code")).decode(new BitInputStream("short.short"), "new.new");
	}
}
