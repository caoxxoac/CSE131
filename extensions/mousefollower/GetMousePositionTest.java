package mousefollower;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;


public class GetMousePositionTest {

	@Test
	public void testGetMousePosition() throws InterruptedException{

		double[] myMousePos;
		double[] theirMousePos;
		double xPos = 1;
		double yPos = 1;

		for (int i=0; i<50; i++){

			StdDraw.clear();
			myMousePos = new double[]{StdDraw.mouseX(), StdDraw.mouseY()};
			theirMousePos = FollowTheMouse.getMousePosition();
			assertTrue("Your x Coordinate is Wrong", Math.abs(myMousePos[0]-theirMousePos[0]) < .01);	
			assertTrue("Your y Coordinate is Wrong", Math.abs(myMousePos[1]-theirMousePos[1]) < .01 );
			xPos = xPos - Math.random()*.05;
			yPos = yPos - Math.random()*.05;
			StdDraw.filledCircle(xPos, yPos, .02);
			StdDraw.show(50);
		}
	}

	@Test
	public void testDrawBall() {
		double[] tester = new double[]{.5, .5};
		FollowTheMouse.drawBall(tester, .2);
		assertTrue(new ArgsProcessor(new String[0]).nextBoolean("Looks OK? (true or false)"));
	}
	
	@Test
	public void testChangePosition() {
		double[] currentPos = new double[]{.5, .5};
		double[] mouse      = new double[] { 0, 0 };
		double [] next = FollowTheMouse.changePosition(currentPos, mouse, 0.5);
		assertTrue("Position should change", !Arrays.equals(currentPos, next));
	}

}
