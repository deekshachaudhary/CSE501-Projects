package lab3;

import java.util.HashSet;
import java.util.Set;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int numDice = ap.nextInt("How many dice?");
		int numThrows = ap.nextInt("How many times to throw the dice?");
		int[][] result = new int[numThrows][numDice];

		
		for(int t = 0; t < numThrows; t++) {
			for(int d = 0; d < numDice; d++) {
				result[t][d] = (int) ((Math.random() * 6) + 1);

				System.out.print(result[t][d]+ " ");
			}
		System.out.println();
		}
		
		int numSameRow = 1;
		int numSame = 0;
		for (int t = 0; t < numThrows; t++) {
			int first = result[t][0];
			for(int d = 1; d < numDice; d++) {
				if(result[t][d] == first) {
					numSameRow +=1;
				}
			}
			if(numSameRow == numDice) {
				numSame += 1;
			}
	
		}
		
		System.out.println("Number of times same values show up: " +numSame+ " in " +numThrows+ " times");
		System.out.println("Fraction that same values show up: " +(double)numSame / numThrows);
		System.out.println("Percentage that same values show up: " +(double)numSame / numThrows*100.0 + "%");

		// summing values in each throw	
		System.out.println();
		int[] sum = new int[numThrows];
		for (int t = 0; t < numThrows; t++) {
			for(int d = 0; d < numDice; d++) {
				sum[t] += result[t][d];		
			}
			System.out.println("Sum of all values in throw " +t+ " is: " +sum[t]);
		}
		
		// referred oracle docs and googled how to convert a set to array
		Set<Integer> uniqueSet = new HashSet<Integer>();
		for(int i : sum){		
			uniqueSet.add(i);
		}
		
		int uniqueSetSize = uniqueSet.size();
		int[] uniqueSumArray = new int[uniqueSetSize];
		int j = 0;
		for(Integer u : uniqueSet){
			uniqueSumArray[j] = u;
			j++;
		}

		System.out.print("Unique values of sum: ");
		for (int u: uniqueSumArray) {
			System.out.print(u+ " ");
		}		

		System.out.println();
		int[][] count = new int[uniqueSumArray.length][2];	//col 1 = unique sum values, rows- 1 for each occurrence
		System.out.println("Sum 	Number of times Sum was seen");
		for (int i = 0; i < uniqueSumArray.length; i++) {
				count[i][0] = uniqueSumArray[i];
			}
		
		for (int i = 0; i < uniqueSumArray.length; i++) {
			for (int k = 0; k < sum.length; k++) {
				if(uniqueSumArray[i] == sum[k]) {
					count[i][1] += 1;
				}
			}
		}

//		for (int m = 0; m < sum.length-1; m++) {
//			int sumCount = 0;
//			for (int n = 1; n < sum.length-1; n++) {
//				sumCount += count[m][n];
//			}	

		for (int i = 0; i < uniqueSumArray.length; i++) {
			System.out.println(" " +count[i][0]+ "		" +count[i][1]);
		}
	}
}
