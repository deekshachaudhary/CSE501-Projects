package lab6;

import java.awt.Color;

import sedgewick.StdDraw;

public class Triangles {

	/**
	 * 
	 * @param llx
	 * @param lly
	 * @param s - length of side
	 */
	public static void triangles(double llx, double lly, double s) {
		
		if(s <= 0.03) {
			return;
		}

		//draw the bigger black triangle
		StdDraw.setPenColor(Color.BLACK);
		double[] xBigBlack = {llx, llx + s, llx + s/2};
		double[] yBigBlack = {lly, lly, lly + s};
	
		StdDraw.filledPolygon(xBigBlack, yBigBlack);
		
		// draw the inner upside down white triangle
		StdDraw.setPenColor(Color.WHITE);
		double[] xSmallWhite = {llx+s/2, llx + 3*s / 4, llx + s/4};
		double[] ySmallWhite = {lly, lly+s/2, lly+s/2};
	
		StdDraw.filledPolygon(xSmallWhite, ySmallWhite);
		
		StdDraw.pause(10);
		
		triangles(llx, lly, s/2); //left triangle
		triangles(llx+s/2, lly, s/2); // right triangle
		triangles(llx+s/4, lly+s/2, s/2); // upper triangle
	}
	
	public static void main(String[] args) {
		triangles(0,0,1);
	}

}
