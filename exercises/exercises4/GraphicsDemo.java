package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point (look carefully, will be very small on your screen)
		StdDraw.setPenColor(Color.blue);
		StdDraw.point(0.5, 0.25);
		
		// larger green point
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(Color.green);
		StdDraw.point(0.25, 0.5);
		
		// unfilled red triangle
		StdDraw.setPenRadius();
		StdDraw.setPenColor(Color.red);
		StdDraw.line(0, 0, 0, 1);
		StdDraw.line(0, 1, 0.5, 0);
		StdDraw.line(0.5, 0, 0, 0);
		
		// yellow circle, filled
		StdDraw.setPenColor(Color.blue);
		StdDraw.filledRectangle(0.25, 0.25, 0.2, 0.1);

		// filled blue rectangle


	}

}
