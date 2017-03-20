package studio6;

public class Methods {

	// Your methods go below this line
	
	public static int fact(int n) {
		if(n <= 0) {
			return 1;
		}
		else
			return n*fact(n-1);
	}
	
	public static int fib(int n) {
		if(n <= 1) {
			return n;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static boolean isOdd(int n) {
		if(n <= 0) {
			return false;
		}
		else {
			return !isOdd(n-1);
		}
	}
	
	public static int sum(int a, int b) {
		if(b <= 0) {
			return a;
		}
		else {
			return sum(a+1, b-1);
		}
	}
	
	
	// Evaluation using substitution model
	
	//		isOdd(3) -> !isOdd(2)
	//				 -> !(!isOdd(1))
	//				 -> !(!(!isOdd(0)))
	//				 -> !(!(!false))
	//				 -> !(!true)
	//				 -> !(false)
	//				 -> true
	
	//		sum(100,3) -> sum(101, 2)
	//				   -> sum(102, 1)
	//				   -> sum(103, 0)
	//				   -> 103
	
	public static int sumDownBy2(int n) {
		if(n <= 0) {
			return 0;
		}
		else {
			return n + sumDownBy2(n-2);
		}
	}
	
	public static double harmonicSum(double n) {
		if(n <= 1) {
			return 1;
		}
		else {
			return harmonicSum(n-1) + 1/n;			
		}
	}
	
	public static int mult(int a, int b ) {
		if(b <= 0) {
			return 0;
		}
		else {
			return a + mult(a, b-1);
		}
	}
	
	// For f(99) and f(87) evaluation, and answers to other
	//  3 questions, refer lab6 problem 2,3,4
	
	public static int f(int x) {
		if(x > 100) {
			return x-10;
		}
		else {
			return f(f(x+11));
		}
	}
	
	public static int g(int x, int y) {
		if(x == 0) {
			return y+1;
		}
		
		else if(x > 0 && y == 0) {
			return g(x-1, 1);
		}
		
		else if(x > 0 && y > 0) {
			return g(x-1, g(x, y-1));
		}
		else
			return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println("For 99: " +f(99));
		System.out.println("For 87: " +f(87));
		System.out.println("For 101: " +f(101));
		System.out.println("For 102: " +f(102));
		System.out.println("For 103: " +f(103));
		
		for(int i = 0; i < 150; i++) {
			System.out.println("For " +i+ ": " +f(i));		
		}
		
		System.out.println("For g(1,0): " +g(1,0));
		System.out.println("For g(1,2): " +g(1,2));
		System.out.println("For g(2,2): " +g(2,2));
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				
				System.out.println("For g(" +i+ ", " +j+ "): " +g(i,j));				
				
			}
		}		
	}	  
}
