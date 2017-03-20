package Mario;

public class Mario {

	/**
	 * Produces 
	 * 		    #
	 *         ##
	 *        ###
	 *       ####
	 *      #####
	 */
	public static void rightAscending() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	/**
	 * Generates the pattern
	 * #
	 * ##
	 * ###
	 * ####
	 * #####
	 */
	public static void rightDescending() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * Generates
	 * #####
	 *  ####
	 *   ###
	 *    ##
	 *     #
	 */
	public static void rightAscendingFlipped() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 5-i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
	
	/**
	 * #####
	 * ####
	 * ###
	 * ##
	 * #
	 */
	public static void rightDescendingFlipped() {
		for(int i = 0; i < 5; i++) {
			for(int j = 5; j > i; j--) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
	
	// Generates the above 4 patterns
	public static void main(String[] args) {
		System.out.println("Right Ascending mountain");
		rightAscending();
		System.out.println();
		
		System.out.println("Right Descending mountain");
		rightDescending();
		System.out.println();
		
		System.out.println("Right Ascending Flipped mountain");
		rightAscendingFlipped();
		System.out.println();
		
		System.out.println("Right Descending Flipped mountain");
		rightDescendingFlipped();
		System.out.println();
	}

}
