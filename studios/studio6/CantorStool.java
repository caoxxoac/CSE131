package studio6;

import java.awt.Color;

import sedgewick.StdDraw;

public class CantorStool {
	
	private static void recursiveRect(double x, double y, double halfWidth, double halfHeight) {
		if (halfWidth < 0.01) {
			return;
		}
		else {
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
			//recursiveRect(x, y-halfHeight/2, halfWidth/3, halfHeight/2);
			//recursiveRect-halfWidth/3, y-halfHeight/2, halfWidth/3, halfHeight/2);
		}
	}

	public static void main(String[] args) {
		StdDraw.setXscale(-1, +1);
		StdDraw.setYscale(-1, +1);
		StdDraw.setPenColor(Color.GRAY);
		StdDraw.filledRectangle(0, 0, 1, 1);
		recursiveRect((double)-1/6, -0.5, (double)-1/6, 0.25);

	}

}
