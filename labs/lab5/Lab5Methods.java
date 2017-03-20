package lab5;

public class Lab5Methods {

	/**
	 * 
	 * @param n int
	 * @return sum of int n + (n-2) + (n-4)....;
	 */
	public static int sumDownBy2(int n) {
		
		int sum = 0;
		int i = n;
		
		if(n <= 0) {
			return 0;
		}
		
		while(i >= 1) {
			sum += i;
			i -= 2;
		}
		return sum;
	}
	
	/**
	 * 
	 * @param n - positive int
	 * @return - sum 1+ 1/2 + 1/3 + 1/(n-1) + 1/n
	 */
	public static double harmonicSum(int n) {
		double sum = 0;
		int i = 1;
		
		if(n <= 0) {
			n = Math.abs(n);
		}
		
		while(i <= n) {
			sum += (double) 1/i;
			i++;
		}
		return sum;
	}
	
	/**
	 * 
	 * @param k - positive int
	 * @return - 1 + 1/2 + 1/4 + 1/8... + 1/Math.pow(2,k)
	 */
	public static double geometricSum(int k) {
	
		double sum = 0;
		int i = 0;
		
		if(k <= 0) {
			k = Math.abs(k);
		}
		
		while(i <= k) {
			sum += (double) (1/Math.pow(2, i));
			i++;
		}
		return sum;
	}
	
	
	/**
	 * 
	 * @param x - positive int
	 * @param y - positive int
	 * @return - x*y using iteration
	 */
	public static int multPos(int x, int y) {

		x = Math.abs(x);
		y = Math.abs(y);
		
		int product = 0;
		for(int i = 0; i < y; i++) {
			product += x;
		}
		return product;
	}
	
	/**
	 * 
	 * @param x - -ve, +ve or 0 
	 * @param y - -ve, +ve or 0
	 * @return - x*y
	 */
	public static int mult(int x, int y) {

		int product = multPos(x, y);
		
		if((x < 0 && y > 0) || (x > 0 && y < 0)) {
			product = -product;
		}
		
		return product;
	}
	
	/**
	 * 
	 * @param n
	 * @param k
	 * @return - expt(3,2) = 9
	 */
	
	public static int expt(int n, int k) {
		k = Math.abs(k);
		int exp = n;

		if(k == 0) 
			return 1;
		
		for(int i = 0; i < k-1; i++) {
			exp = mult(exp, n);
		}

		return exp;
	}
	
//	public static void main (String args[]) {
//		System.out.println(sumDownBy2(5));
//		System.out.println(sumDownBy2(-1));
//		System.out.println(sumDownBy2(0));
//	}

}
