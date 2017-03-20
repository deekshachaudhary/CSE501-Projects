package lab6;

public class Methods {
	
	//
	// In this class, implement the f and g functions described on the lab page
	//

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
