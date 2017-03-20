package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How much history?");
		
		StdDraw.setPenColor(Color.RED);
		double[] histX = new double[N];
		double[] histY = new double[N];
		int cur = 0;
		
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//
			
			// copied the history part from solution
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			histX[cur] = x;
			histY[cur] = y;
			cur++;
			if(cur >= histX.length) {
				cur = 0;
			}
			
			int oldest = cur;
			
			StdDraw.filledCircle(histX[oldest], histY[oldest], 0.05);
						
			//  
			// End of your frame
			//
			// Stdraw.show(..) achieves double buffering and
			//   avoids the tight spinning loop
			StdDraw.show(10);
		}

	}
}