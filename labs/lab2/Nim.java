package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int numSticksAtStart = ap.nextInt("How many sticks you want to start with?");
		int numSticksRemaining = numSticksAtStart;
		String playerTurn = "Computer";
		int numRemoveHuman;
		int numRemoveComputer;
		int roundCount = 0; 
		
		System.out.println("Computer starts");
		
		while (numSticksAtStart > 0) {
			
			if (playerTurn == "Human") {
				numRemoveHuman = ap.nextInt("How many sticks do you want to remove?");
				if ((numRemoveHuman != 1) && (numRemoveHuman != 2)) {
					System.out.println("Invalid entry! Enter only 1 or 2");
					numRemoveHuman = ap.nextInt("How many sticks do you want to remove?");
				}
				
				numSticksRemaining = numSticksAtStart - numRemoveHuman;
				System.out.println("Round " +roundCount+ ", " +numSticksAtStart+ 
									" sticks at start, Human took " +numRemoveHuman+ ", so " 
									+numSticksRemaining+ " sticks remain");				
				
				playerTurn = "Computer";
			}
			
			else if (playerTurn == "Computer") {
				double randNum = Math.random();
				if (randNum >= 0.5) {
					numRemoveComputer = 1;
				}
				else {
					numRemoveComputer = 2;
				}
				
				if (numRemoveComputer > numSticksRemaining) {
					break;
				}
				
				numSticksRemaining = numSticksAtStart - numRemoveComputer;
				System.out.println("Round " +roundCount+ ", " +numSticksAtStart+ 
						" sticks at start, Computer took " +numRemoveComputer+ ", so " 
						+numSticksRemaining+ " sticks remain");				

				playerTurn = "Human";
				}
			
			roundCount++;
			numSticksAtStart = numSticksRemaining;
			
		}
		if (playerTurn == "Computer") {
			System.out.println("Human wins!");
		}
		
		if (playerTurn == "Human") {
			System.out.println("Computer wins!");
		}
		
	}

}

//	improvement: remove 2 if the remaining stick is 2;
//				remove 1 if 1 left