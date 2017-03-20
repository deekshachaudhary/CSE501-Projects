package sadcycle;

import java.util.HashSet;
import java.util.Set;

public class SadCycler {

	/**
	 * 
	 * @param base number we are raising n to the power of
	 * @param n number to raise to the power of base
	 * @return a set of sums of squares of separate digits of a number
	 */
	public static Set<Long> findCycle(int base, long n) {
		Set<Long> cycles = new HashSet<Long>();
		for(int i = 0; i < 10; i++) {
			n = powerAndSum(base, n);
			cycles.add(n);
		}
		return cycles;
	}
	
	/**
	 * 
	 * @param base number we are raising n to the power of
	 * @param n number to raise to the power of base 
	 * @return sum of square of separate digits of n
	 */
	public static long powerAndSum(int base, long n) {
		long sum = 0;
		while(n != 0) {
			sum = sum + (long)Math.pow(n % 10, base);
			n = n / 10;
		}
		return sum;
	}
	
	// Tells whether a number is happy or sad
	public static void main(String[] args) {
		int[] numbers = {1, 5,12, 922, 15, 82, 356, 860, 910};
		for(int num : numbers) {
			if(findCycle(2, num).contains((long)1)) {
				System.out.println(num+ ": Happy number");
			}
			else {
				//System.out.println(num + " findCycle = " + findCycle(2, num));
				System.out.println(num+ ": Sad number");
			}
		}
	}
}
