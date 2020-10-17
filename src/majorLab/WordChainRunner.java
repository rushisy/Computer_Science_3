package majorLab;

import java.io.IOException;

public class WordChainRunner {
	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();

		WordChain obj = new WordChain("SAIL", "RUIN");
		obj.newDictionary();
		obj.firstLayer();
		while (!obj.getFlag()) {
			obj.layer();
		}

		System.out.println(obj.getPaths());
		System.out.println(obj.getShortestPath());

		long stop = System.nanoTime();
		System.out.println((stop - start) / 1000000000);
	}
}
