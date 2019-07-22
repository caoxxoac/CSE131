package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How much history?");
		StdDraw.setPenColor(Color.CYAN);
		
		double[] histX = new double[N];
		double[] histY = new double[N];
		int current = 0;
		
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			
			histX[current] = x;
			histY[current] = y; 
			current = current + 1;
			
			if (current >= histX.length) {
				current = 0;
			}
			int oldest = current;
			
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
