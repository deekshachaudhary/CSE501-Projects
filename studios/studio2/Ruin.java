package studio2;

import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		double startAmount = ap.nextDouble("Enter the amount of money you start with");
		double winChance = ap.nextDouble("Enter the probability that you win a gamble");
		double winAmount = ap.nextDouble("Enter the amount to win");
		int totalPlays = ap.nextInt("Enter the number of times you want to simulate the problem");
		double lossChance = 1 - winChance;
		int numRounds = 0;
		int numWins = 0;
		int numLosses = 0;
		double expectedRuinRate = 0;

		if(lossChance != winChance) {
			expectedRuinRate = (Math.pow(lossChance / winChance, startAmount) - Math.pow(lossChance / winChance,winAmount)) / (1 - Math.pow(lossChance / winChance,winAmount)); 
		}
			
		if(lossChance == winChance) {
							
			expectedRuinRate = 1 - startAmount / winAmount;
		}

		
		for(int i = 1; i <= totalPlays; i++) {
			
			while(!(startAmount == winAmount) && !(startAmount == 0)) {
				//if win
				if (Math.random() <= winChance) {
					startAmount += 1;
				}
				
				//if lose a gamble
				else if (Math.random() > winChance) {
					startAmount -= 1;
				}
				numRounds += 1;
			}
			
			if (startAmount == winAmount) {
				System.out.println("Simulation " +i+ ": " +numRounds+ " rounds				WIN");
				numWins += 1;
			}
			
			if (startAmount == 0) {
				System.out.println("Simulation " +i+ ": " +numRounds+ " rounds				LOSE");
				numLosses += 1;
			
			}
			
		}
		
	
		System.out.println("Losses: " +numLosses+ " Simulations: " +totalPlays+ " Actual Ruin Rate: " +(numLosses / totalPlays)+ " Expected Ruin Rate: " +expectedRuinRate);

		
	}

}
