package sieveOfEratos;

import java.util.LinkedList;
import java.util.Queue;

public class SieveOfEratos {
	
	/**
	 * outputs the queue of prime numbers
	 * @param max the number to find up to
	 * @return Queue<Integer> the prime numbers
	 */
	public Queue<Integer> primeNumbers(int max) {
		Queue<Integer> all = new LinkedList<Integer>();
		Queue<Integer> primes = new LinkedList<Integer>();

		for (int i = 3; i <= max; i++) {
			all.add(i);
		}

		int factors = 0;

		int size = all.size();
		for (int i = 0; i < size; i++) {

			if (!all.isEmpty()) {
				for (int j = 1; j <= all.peek(); j++) {
					if (all.peek() % j == 0) {

						factors++;
					}
				}
			}
			if (factors == 2) {
				primes.add(all.peek());
			}
			factors = 0;
			all.remove(all.peek());
		}

		return primes;
	}
}
