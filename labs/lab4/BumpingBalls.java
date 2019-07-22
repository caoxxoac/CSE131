package lab4;
import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int balls = ap.nextInt("Enter the number of balls: ");
		int iteration = ap.nextInt("Enter the number of iterations: ");
		int pause = ap.nextInt("Enter the pause: ");
		
		// set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        
        double[][] allPosition = new double[balls][2];
        double[][] allVelocity = new double[balls][2];
        double[] allRadius = new double[balls];
        
        for (int i=0; i<balls; i++) {
        	
        	// not finished yet
        	allPosition[i][0] = Math.random();
        	allPosition[i][1] = Math.random();
        	allVelocity[i][0] = Math.random() / 100.0;
        	allVelocity[i][1] = Math.random() / 100.0;
        	allRadius[i] = 0.05;
        }
        
        
        for (int i=0; i<iteration; i++) {
        	// clear the background
            StdDraw.clear();
            
            // clear the background
            StdDraw.setPenColor(StdDraw.BLUE);
            
	        for (int j=0; j<balls; j++)  {
	            // bounce off wall according to law of elastic collision
	            if (Math.abs(allPosition[j][0] + allVelocity[j][0]) > 1.0 - allRadius[j]) allVelocity[j][0] = -allVelocity[j][0];
	            //if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;
	            if (Math.abs(allPosition[j][1] + allVelocity[j][1]) > 1.0 - allRadius[j]) allVelocity[j][1] = -allVelocity[j][1];
	
	            
	            
	            for (int n=0; n<balls; n++) {
	            	if ((distance(allPosition[j], allPosition[n], allVelocity[j], allVelocity[n]) <= (allRadius[j]+allRadius[n])) && n != j) {
	            		allVelocity[j][0] = -allVelocity[j][0];
	            		allVelocity[j][1] = -allVelocity[j][1];
	            		allVelocity[n][0] = -allVelocity[n][0];
	            		allVelocity[n][1] = -allVelocity[n][1];
	            	}
	            }
	            
	            // update position
	            allPosition[j][0] = allPosition[j][0] + allVelocity[j][0];
	            allPosition[j][1] = allPosition[j][1] + allVelocity[j][1];
	        }
	        
	        
	        
	        // animation on each ball
	        for (int w=0; w<balls; w++) {
	
	            // draw ball on the screen
	            // StdDraw.setPenColor(StdDraw.BLACK); 
	            // StdDraw.filledCircle(rx, ry, radius); 
	
	            StdDraw.filledCircle(allPosition[w][0], allPosition[w][1], allRadius[w]);
	            // display and pause for 20 ms
	        }
	        StdDraw.show(pause);
        }
        
	}
	
	public static double distance(double[] position1, double[] position2, double[] velocity1, double[] velocity2) {
		double x = (position1[0]+velocity1[0]) - (position2[0]+velocity2[0]);
		double y = (position1[1]+velocity1[1]) - (position2[1]+velocity2[1]);
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}

}
