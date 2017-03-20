package recursivepatterns;

import java.awt.Color;
import sedgewick.*;

public class PersianRug {

	/**
	 * 
	 * @param palette an array of Colors to choose from
	 * @param llx lower left x coordinate of this rug square
	 * @param lly lower left y coordinate of this rug square
	 * @param size width (and therefore also height) of this rug square
	 * @param north color index of the north side of this rug square
	 * @param east color index of the east side of this rug square
	 * @param south color index of the south side of this rug square
	 * @param west color index of the west side of this rug square
	 */
	private static void persianRug(
			Color[] palette, 
			double llx, double lly,
			double size, 
			int north, int east, int south, int west) {
		
		if(size <= 0.005) {
			return;
		}

		StdDraw.setPenColor(palette[0]);
		StdDraw.line(llx, lly+size/2, llx+size, lly+size/2);
		StdDraw.setPenColor(palette[0]);
		StdDraw.line(llx+size/2, lly, llx+size/2, lly+size);

		StdDraw.setPenColor(palette[9]);

		// comment this and uncomment the next line for a different rug
		StdDraw.filledSquare(llx+size/2, lly+size/2, size/5);
		
		// comment the previous line and uncomment this for a different rug
//		StdDraw.filledSquare(llx+size/2, lly+size/2, size/7);
		
		int n = (((north+east+south+west))*31)%palette.length;
		int e = (((north+east+south+west))*31)%palette.length;
		int s = (((north+east+south+west))*31)%palette.length;
		int w = (((north+east+south+west))*31)%palette.length;
		
		persianRug(palette, llx, lly, size/2, 
				n, e, south, west); 	// lower left square
		persianRug(palette, llx+size/2, lly, size/2, 
				n, east, south, w); // lower right square
		persianRug(palette, llx, lly+size/2, size/2, 
				 north, e, s, west); // upper left square
		persianRug(palette, llx+size/2, lly+size/2, size/2, 
				 north, east, s, w); // upper right square
	}

	public static void main(String args[]) {
		//
		// Leave the following line commented out, but once you
		//   have things working, uncomment it, and also uncomment
		//   the similar line at the end of this method.
		// Uncommenting those lines will run the graphics code
		//   in double-buffering mode, so that your image will appear
		//   almost instantaneously, instead of being drawn one line
		//   at a time.
		//
		//  Here is the line to uncomment:
		//
		StdDraw.show(10);   // don't forget to uncomment the other line at the end
		//	
		
		//
		// Generate a palette of colors
		//
		Color[] palette = { StdDraw.BLUE, StdDraw.CYAN, StdDraw.DARK_GRAY,
				StdDraw.GRAY, StdDraw.GREEN, StdDraw.LIGHT_GRAY,
				StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.PINK,
				StdDraw.RED, StdDraw.WHITE, StdDraw.YELLOW };
		//
		// Draw the outermost square as a special case
		// Use color 0 for that
		//
		StdDraw.setPenColor(palette[0]);
		StdDraw.line(0, 0, 1, 0);
		StdDraw.line(1, 0, 1, 1);
		StdDraw.line(1, 1, 0, 1);
		StdDraw.line(0, 1, 0, 0);

		//
		// Kick off the recursion
		// Lower left is point (0,0)
		// Size of the square is 1
		// The color index of each surrounding side is 0
		//
		persianRug(palette, 0, 0, 1, 0, 9, 0, 9);
		//
		// Also uncomment this line when you have things working
		//   to speed up the drawing:
		//
		StdDraw.show(10);
		//
	}
}
