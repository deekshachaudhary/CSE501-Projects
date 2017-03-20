package exercises3;

import java.util.Random;

public class Shuffle {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		
		String[] shuffled = new String[original.length];
		for (int i=0; i < shuffled.length; i++) {
			shuffled[i] = original[i];
		}
		System.out.println("Current Shuffled elements are: ");
		for(String s : shuffled) {
			System.out.print(s+ "	");
		}
		System.out.println("");
		
		Random rand = new Random();
		for(int i = shuffled.length-1; i >= 0; i--) {
			int randNum = rand.nextInt(i+1);	// copied it from the solution, was writing rand.nextInt(original.length) instead of (i+1)
			shuffled[i] = original[randNum];
			for(int j = randNum; j < shuffled.length-1; j++) {
				original[j] = original[j+1];
		
			}
		}
		System.out.println("New Shuffled elements are: ");
		for(String s : shuffled) {
			System.out.print(s+ "	");
		}

	}
}