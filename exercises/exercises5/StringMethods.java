package exercises5;

public class StringMethods {

	//
	// Below are the methods defined for this exercise
	//   The names are not prescribed in the assignment, so choose
	//   names you like (that are meaningful)
	//

	//
	// First one is completed for you:
	//

	public static String selfConcat(String s) {
		// return s + s;
		return stringCopies(s, 2);
	}

	/** 
	 * n copies of s concatenated together
	 * @param s string
	 * @param n number of copies required
	 * @return concatenated string
	 */
	public static String stringCopies(String s, int n) {
		//		String nCopies = "";
		//		for(int i = 0; i < n; i++) {
		//			nCopies += s;
		//		}
		//		return nCopies;
		// }
		String[] copies = new String[n];
		for(int i = 0; i < n; i++) {
			copies[i] = s;
		}
		return join(copies, "");
	}

	public static String[] splitString(String s) {
		String[] splitted = s.split(" ");
		for (String words : splitted) {
			System.out.println(words+ " ");
		}
		return splitted;
	}

	public static String join(String[] array, String joiner) {
		String joint = "";
		for(String element : array) {
			joint += element + joiner;
		}
		return joint;
	}

	public static void main(String[] args) {

		//
		// Testing the methods
		//
		System.out.println(selfConcat("echo"));
		System.out.println(stringCopies("echo", 5));
		System.out.println(splitString("How are you today?"));
		// System.out.println(join(splitString("How have you been?"), " "));

	}

}
