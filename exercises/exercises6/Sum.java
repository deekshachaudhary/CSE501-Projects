package exercises6;

public class Sum {

	public static int sum(int n) {
		if(n <= 0) {
			return 0;
		}
		else
			return sum(n-1) + n;

	}
}
