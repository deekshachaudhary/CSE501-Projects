package imagetransforms;

import java.awt.Color;

import sedgewick.Picture;


public class Transforms {
	
	/**
	 * This one is solved for you.
	 * @param source
	 * @param target
	 */
	public static void flipHoriz(Picture source, Picture target) { 
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				//
				// Convince yourself that otherX is the x coordinate flipped,
				//     on the other side of the image by doing the following:
				// Check that this is true when x == 0
				//      then otherX = source.width() - 1
				//      which is indeed the rightmost pixel
				// Check that this is true when x == source.width()-1
				//      then otherX = 0
				//      which is indeed the leftmost pixel
				//
				int otherX = source.width() - 1 - x;  // otherX is the mirror of x
				Color c = source.get(otherX, y);      // get the Color at the mirror point of the source
				target.set(x, y, c);                  // and set it at x,y in the target
			}
		}
	}
	
	/**
	 * 
	 * @param source source picture
	 * @param target  target picture
	 */
	public static void flipVert(Picture source, Picture target) {
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				int otherY = source.height() - 1 - y;
				Color c = source.get(x, otherY);
				target.set(x, y, c);
			}
		}
	}
	
	/**
	 * 
	 * @param source source picture
	 * @param target target picture
	 */
	public static void flipHorizLeftHalf(Picture source, Picture target) {
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				int otherX = source.width() - 1 - x;
				if(x > source.width()/2) {
					Color c = source.get(otherX, y);
					target.set(x, y, c);
				}
				else {
					Color c1 = source.get(x, y);
				target.set(x, y, c1);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param source source picture
	 * @param target target picture
	 */
	public static void flipVertBotHalf(Picture source, Picture target) {
		for (int x = 0; x < source.width(); x++) {
			for (int y = 0; y < source.height(); y++) {
				int otherY = source.height() - 1 - y;
				if(y > source.height()/2) {
					Color c = source.get(x, otherY);
					target.set(x, y, c);
				}
				else {
					Color c1 = source.get(x, y);
					target.set(x, y, c1);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param target target picture
	 */
	public static void gradient(Picture target) {
		double rDouble = 0;
		double gDouble = 0;
		for (int x = 0; x < target.width(); x++) {
			rDouble = rDouble + (double)255/target.width();
			gDouble = 0;
			int r =	(int) rDouble;
			for (int y = 0; y < target.height(); y++) {
				gDouble = gDouble + (double)255/target.height();		
				int g = (int) gDouble;
				Color c = new Color(r, g, 128);
				target.set(x, y, c);
			}
		}
	}
	
	public static void edgeDetect(Picture source, Picture target) {
		// FIXME
	}
	
	public static void digitalFilter(Picture source, Picture target) {
		// FIXME	
	}



}
