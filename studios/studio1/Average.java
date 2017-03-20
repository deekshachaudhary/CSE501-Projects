package studio1;

import cse131.ArgsProcessor;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int num1 = ap.nextInt("Enter the first number");
		int num2 = ap.nextInt("Enter the second number");
		double avg = (double) (num1 + num2) / 2;
		System.out.println("The average of " +num1+ " and " +num2+ " is " +avg);

	}

}
