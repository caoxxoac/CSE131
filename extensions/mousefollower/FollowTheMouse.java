package mousefollower;

import sedgewick.StdDraw;

public class FollowTheMouse {

	/**
	 * 
	 * @return the x and y coordinate of the mouse currently
	 */
	public static double[] getMousePosition() {
		return new double[] { StdDraw.mouseX(), StdDraw.mouseY() };   // FIXME
	}

	/**
	 * Draw a ball of radius r at the specified location
	 * @param location the x and y coordinate for the ball
	 * @param r the radius of the ball
	 */
	public static void drawBall(double[] location, double r) {
		// Delete the following line and then draw the ball here as specified
		//  in the write up
		double x = location[0];
		double y = location[1];
		StdDraw.filledCircle(x, y, r);
	}
	
	/**
	 * 
	 * @param currentBallPosition the location of the ball currently
	 * @param mousePosition the location of the mouse currently
	 * @param speed the speed with which the ball should move toward the mouse
	 * @return the next location of the ball given its current position, the mouse's position, and the speed
	 */
	public static double[] changePosition(double[] currentBallPosition, double[] mousePosition, double speed) {
		double x = currentBallPosition[0];
		double y = currentBallPosition[1];
		double dx = mousePosition[0]-x;
		double dy = mousePosition[1]-y;
		double distance = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		double time = distance / speed;
		return new double[] {x+dx/time, y+dy/time};
	}

	public static void main(String[] args) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		double[] tester = new double[]{.5, .5};
		drawBall(tester, .05);
		StdDraw.show(2000);
		StdDraw.setPenColor(StdDraw.CYAN);
		while (true) {
			if (StdDraw.mousePressed()) {
				double[] mouseLocation = getMousePosition();
			//	tester = mouseLocation;
				double[] newLocation = changePosition(tester, mouseLocation, 0.01);
				drawBall(newLocation, 0.01);
				tester = newLocation;
			}
			StdDraw.show(300);
		}
	}
}
