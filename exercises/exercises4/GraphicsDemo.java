package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point (look carefully, will be very small on your screen)
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.point(0.2, 0.2);
		
		// larger green point
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.setPenRadius(0.05);
		StdDraw.point(0.3, 0.3);
		
		// unfilled red triangle
		StdDraw.setPenColor(Color.RED);
		StdDraw.line(0, 0, 0.1, 0);
		StdDraw.line(0.1, 0, 0.2, 0.5);
		StdDraw.line(0.2, 0.5, 0, 0);

		// yellow circle, filled
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(0.4, 0.4, 0.1);
		
		// filled blue rectangle
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(0.7, 0.7, 0.05, 0.03);
		
		StdDraw.setPenColor(new Color(200, 30, 110));
		StdDraw.filledEllipse(0.8, 0.5, 0.2, 0.15);

	}

}
