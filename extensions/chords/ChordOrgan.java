package chords;

import java.awt.Color;

import sedgewick.StdDraw;
import chords.gui.*;
import chords.music.*;

public class ChordOrgan {

	public static void main(String[] args) {
		String[] chordNames = {
				"C", "d", "e", "F", "G", "a", "b", "C"	
		};
		
		final double width =  .05;  // Entire width of rectangle
		final double height = .3;  // Entire height of rectangle
		
		Color rectColor = null;
		int iters=0;

		//
		// Infinite Sedgewick event loop
		//
		while (true) {
			double xLoc = 0.1;          // Sedgewick x coordinate of center of rectangle
			double yLoc = 0.5;          // Sedgewick y coordinate of center of rectangle
			
			//
			// Clear the Sedgewick panel
			//
			StdDraw.clear();
			//
			// Keep track of the number of iterations we have performed
			//
			iters = iters + 1;
			
			
			for (int i=0; i<chordNames.length; i++) {
				//
				// A Bounding box that represents the rectangle we will draw
				// These are constructed from the lower-left and upper-right corners
				//
				SWPoint ll = new SWPoint(xLoc-width/2, yLoc-height/2);
				SWPoint ur = new SWPoint(xLoc+width/2, yLoc+height/2);
				BoundingBox bb = new BoundingBox(ll, ur);
				
				//
				// Where is the mouse?
				//
				double xmouse = StdDraw.mouseX();
				double ymouse = StdDraw.mouseY();
				
				//
				// Is the mouse currently inside the rectangle?
				//
				if (bb.inside(new SWPoint(xmouse, ymouse))) {
					//
					// Yes choose red for the rectangle's color
					//
					rectColor = Color.CYAN;
				}
				else {
					//
					// No, choose blue
					//
					rectColor = Color.PINK;
				}
				
				//
				// Draw the rectangle in its current color
				//
				StdDraw.setPenColor(rectColor);
				StdDraw.filledRectangle(xLoc, yLoc, width/2, height/2);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(xLoc, yLoc, chordNames[i]);
				xLoc += 0.1;
				DiatonicScale ds = new DiatonicScale(3);
			}
			//
			// Every 20 iterations change the location
			//    Because each iteration pauses a 1/10 of a second,
			//    the location will change every 2 seconds
			//
			//
			// Pause for 100 ms ==  1/10 of a second
			//   All Sedgewick event loops should pause for some time!
			//
			StdDraw.show(100);
		}
	}

}
