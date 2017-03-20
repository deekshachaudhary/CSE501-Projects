package exercises4;

import sedgewick.StdIn;
import cse131.ArgsProcessor;

public class Stats {

	public static void main(String[] args) {
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");

		//
		//  Read in the data from the opened file, computing the
		//     sum, average, count, max, and min
		//  of the data
		//
		//  count is the number of doubles read from the file
		//  The other statistics should be clear from their names
		//
		double sum = 0.0;
		double avg = 0.0;
		int count = 0;
		double max = 0.0;
		double min = 10000000000.0;
		while(!StdIn.isEmpty()){
			double d = StdIn.readDouble();
			sum += d;
			count++;
			if(d > max)
				max = d;
			
			if(d < min)
				min = d;
		}
		System.out.println("Sum is: " +sum);
		System.out.println("Average is: " +sum / count);
		System.out.println("Count is: " +count);
		System.out.println("Max is: " +max);
		System.out.println("Min is: " +min);
		

	}

}
