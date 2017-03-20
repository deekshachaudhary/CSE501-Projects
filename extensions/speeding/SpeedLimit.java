package speeding;

import cse131.ArgsProcessor;

public class SpeedLimit {
	
	// Calculates the fine for over speeding
	// For the first 1 miles over the speed limit, the fine is 50
	// For the additional mile past the first ten, $10 are added
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int carSpeed = ap.nextInt("Speed you were driving at?");
		int speedLimit = ap.nextInt("What is the speed limit on this road?");
		int overSpeed = carSpeed - speedLimit;
		int fine = (overSpeed > 10) ? (50+((overSpeed-10) * 10)) : 50;
		
		System.out.println("You reported a speed of " +carSpeed+
				" MPH for a speed limit of " +speedLimit+
				" MPH over the speed limit. Your fine is $" 
									+fine+ ".");
	}

}
