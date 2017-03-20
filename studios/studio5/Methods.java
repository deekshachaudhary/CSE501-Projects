package studio5;

public class Methods {

	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}

	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		return 0;  // FIXME
	}

	/**
	 * Returns double average of three numbers
	 * @param x - first number
	 * @param y - second number
	 * @param z - third number
	 * @return - double average
	 */
	public static double avg3(int x, int y, int z) {
		return (double)(x + y + z) / 3;
	}

	/**
	 * adding array values
	 * @param arr = input array
	 * @return - sum of elements
	 */
	public static double sumArray(double[] arr) {
		double sum = 0.0;
		for(double d : arr) {
			sum += d;
		}
		return sum;
	}

	/**
	 * average using sumArray
	 */
	public static double average(double[] arr) {
		return (sumArray(arr)/arr.length);
	}

	/**
	 * return minimum value in an array
	 * @param array
	 * @return minimum value
	 */
	public static double minValue(double[] array) {
		double min = 10000;
		for(double d : array) {
			if(d < min) {
				min = d;
			}
		}
		return min;
	}
	
	/**
	 * Pig latin
	 * computer = omputercay; fun = unfay
	 * @param string - string to be converted to pig latin version
	 * @return - pig latin version
	 */
	public static String pig(String string) {
		String s1 = string.substring(1); // all except first char
		String s2 = string.substring(0, 1); // first char
		return s1 + s2 + "ay";
	}

//	public static void main(String args[]) {
//		double[] arrayTest = {1.0, 2.0, 3.0};
//		System.out.println(average(arrayTest));
//	}
}
