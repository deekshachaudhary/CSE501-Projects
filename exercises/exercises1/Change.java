package exercises1;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int numPennies = ap.nextInt("Enter number of Pennies");
		
		System.out.print("For " +numPennies+ " pennies: ");
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
		int dollars = numPennies / 100;
		numPennies = numPennies % 100;
		int quarters = numPennies / 25;
		numPennies = numPennies % 25;
		int dimes = numPennies / 10;
		numPennies = numPennies % 10;
		int nickels = numPennies / 5;
		numPennies = numPennies % 5;
		int pennies = numPennies;
		
		System.out.print(dollars+ " dollars " +quarters+ " quarters " + dimes+ " dimes "
				+nickels+ " nickels " +pennies+ " pennies"); 		
		
	}

}
