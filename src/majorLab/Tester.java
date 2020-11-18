package majorLab;

import java.io.FileInputStream;
import java.io.IOException;

public class Tester {
	public static void main(String[] args) throws IOException {

		String filename = "happy hip hop.txt";

		// open input file and count character frequencies
		FileInputStream input = new FileInputStream(filename);
		int[] count = new int[256];
		int n = input.read();
		while (n != -1) {
			count[n]++;
			n = input.read();
		}

		// build tree, open output file, print codes
		HuffmanTree t = new HuffmanTree(count);
		t.write(filename);

		TreePrinter.printTree(t.getRoot());
	}
}
