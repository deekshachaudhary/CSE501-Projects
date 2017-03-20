package lab6;

public class Beer {

	public static String bottlesOfBeer(int n) {
		if(n <= 0) {
			return "1 bottle of beer on the wall, 1 bottle of beer;"
					+ " you take one down, pass it around, "
					+ "0 bottle of beer on the wall.";
		}
		
		else {
			return n + " bottles of beer on the wall, " +n+ " bottles of beer;"
					+ " you take one down, pass it around, "
					+ (n-1)+ " bottles of beer on the wall."
					+ bottlesOfBeer(n-1);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(bottlesOfBeer(5));
	}

}
