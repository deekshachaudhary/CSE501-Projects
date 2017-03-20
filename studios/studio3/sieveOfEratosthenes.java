package studio3;

import cse131.ArgsProcessor;

public class sieveOfEratosthenes {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("Enter the size of the array");
		int[] prime = new int[n];
		
		for(int i = 0; i < n; i++) {
			prime[i] = i+2;
		}
		for(int num : prime) {
			System.out.print(" " +num);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if((prime[j] != 0) && (prime[j] % prime[i] == 0)) {
					prime[j] = 0;
				}
			}
		}
		System.out.print("Prime numbers are: ");
		for(int i : prime) {
			System.out.print(i);
		}
	}

}
