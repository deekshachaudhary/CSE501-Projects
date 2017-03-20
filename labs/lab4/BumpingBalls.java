package lab4;

import java.awt.Color;
import java.util.Random;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numBalls = ap.nextInt("How many balls?");
		int numIterations = ap.nextInt("How many iterations?");
		double[] xPosition = new double[numBalls];
		double[] yPosition = new double[numBalls];
		double[] xVelocity = new double[numBalls];
		double[] yVelocity = new double[numBalls];
		double radius = 0.05;
		Random rand = new Random();	

		// set the scale of the coordinate system
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);

		for(int b = 0; b < numBalls; b++) {
			xPosition[b] = -1.0 + (1.0 - (-1.0)) * rand.nextDouble(); 
			yPosition[b] = -1.0 + (1.0 - (-1.0)) * rand.nextDouble(); 

			// range 0.015 and 0.023
			xVelocity[b] =  0.015 + (0.023 - 0.015) * rand.nextDouble(); // googled how to generate random numbers in a range
			yVelocity[b] =  0.015 + (0.023 - 0.015) * rand.nextDouble();
		}

		for(int i = 0; i < numIterations; i++) {		

			StdDraw.clear();
			for (int b1 = 0; b1 < numBalls; b1++) {

				// bounce off wall according to law of elastic collision
				if (Math.abs(xPosition[b1] + xVelocity[b1]) > 1.0 - radius) xVelocity[b1] = -xVelocity[b1];
				if (Math.abs(yPosition[b1] + yVelocity[b1]) > 1.0 - radius) yVelocity[b1] = -yVelocity[b1];

				for (int b2 = b1 + 1; b2 < numBalls; b2++) {
					// bounce off each other						
					double dist = Math.pow((Math.pow(xPosition[b2] - xPosition[b1], 2) + Math.pow(yPosition[b2] - yPosition[b1], 2)), 0.5); 

					if(dist <= (radius + radius)) {
						xVelocity[b1] = -xVelocity[b1];
						xVelocity[b2] = -xVelocity[b2];
						yVelocity[b1] = -yVelocity[b1];
						yVelocity[b2] = -yVelocity[b2];	

					}

				}		    

				// update position

				xPosition[b1] = xPosition[b1] + xVelocity[b1]; 
				yPosition[b1] = yPosition[b1] + yVelocity[b1]; 
				// xPosition[b2] = xPosition[b2] + xVelocity[b2]; 
				// yPosition[b2] = yPosition[b2] + yVelocity[b2]; 
				// draw ball on the screen
				StdDraw.setPenColor(StdDraw.RED); 
				StdDraw.filledCircle(xPosition[b1], yPosition[b1], radius);
//				StdDraw.picture(xPosition[b1], yPosition[b1], "arch.jpg");
			}
			StdDraw.show(25);
		}
	}
}

