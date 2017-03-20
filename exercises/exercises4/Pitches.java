package exercises4;

import cse131.ArgsProcessor;

public class Pitches {

	public static void main(String[] args) {
		// encoding has 0 as concert A
		//    1 would be Bb, just above A
		//   -1 would be Ab, just below A
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int pitch1 = ap.nextInt("Enter pitch j");
		int pitch2 = ap.nextInt("Enter pitch k");
		
		// copied formula
		double freq1 = 440.0 * Math.pow(2, pitch1/12.0);
		double freq2 = 440.0 * Math.pow(2, pitch2/12.0);

		System.out.println("Frequency for the pitch " +pitch1+ " is " +freq1);
		System.out.println("Frequency for the pitch " +pitch2+ " is " +freq2);
		System.out.println("Ratio is: " +freq2/freq1);

	}

}
