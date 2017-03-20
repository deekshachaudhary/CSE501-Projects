package exercises4;

import sedgewick.StdDraw;

public class WaitPoint {

	public static void main(String[] args) {
		// wait for the mouse to be pressed and released
		while(!StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}
		System.out.println("Mouse is pressed");
		
		// here, the mouse has been pressed
		
		while(StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}
		System.out.println("Mouse is released");		
		
		// here the mouse is released
		
		StdDraw.setPenRadius(0.01);	
		StdDraw.point(StdDraw.mouseX(), StdDraw.mouseY());
		
		// copied from the solution
		char input = ' ';
		while(input != 'q') {
			while(!StdDraw.hasNextKeyTyped()) {
				StdDraw.pause(100);
			}
			input = StdDraw.nextKeyTyped();	
		}

		// here, the mouse has been pressed

		// here the mouse is released
		
		
		// draw a point at the location of the mouse
		
		
		// here, a q has been typed
		
		
		StdDraw.text(0.5, 0.5, "Farewell!");

	}

}
