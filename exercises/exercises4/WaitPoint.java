package exercises4;

import sedgewick.StdDraw;

public class WaitPoint {

	public static void main(String[] args) {
		// wait for the mouse to be pressed and released
		while (!StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}
		
		// here, the mouse has been pressed
		while (StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}

		// here the mouse is released
		
		
		// draw a point at the location of the mouse
		StdDraw.setPenRadius(0.01);
		StdDraw.point(StdDraw.mouseX(), StdDraw.mouseY());
		
		char gotKey = ' ';
		while (gotKey != 'q') {
			while (!StdDraw.hasNextKeyTyped()) {
				StdDraw.pause(100);
			}
			gotKey = StdDraw.nextKeyTyped();
		}
		// here, a q has been typed
		StdDraw.text(0.5, 0.5, "Farewell!");

	}

}
