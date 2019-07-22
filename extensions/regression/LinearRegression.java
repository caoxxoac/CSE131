package regression;

import sedgewick.StdIn;

public class LinearRegression {
	/**
	 * These are public class variables and are saved throughout the class
	 *  for use between methods.
	 * This allows us to access them at any point and also access them from
	 *  outside of the class so that we can test your code!
	 * You'll work with similar variables called instance variables 
	 *  when you learn about objects in Module 7.
	 * These will be initialized as 0, but you will change them in your code.
	 */
	public static double slope = 0;
	public static double intercept = 0;
	public static double[] x;
	public static double[] y;
	/**
	 * This is what you need to complete. Using the equations provided on the course website,
	 * 	find the slope and y-intercept of the line that predicts how much a house with a given
	 *  square footage would cost. Make sure you use the slope and intercept static variables.
	 *  
	 *  DO NOT change StdIn in this method. You can read the data using StdIn.readDoubles(), 
	 *  which will return a one dimensional array of doubles that is formatted as 
	 *                      {x1, y1, x2, y2,..., xn-1, yn-1, xn, yn},
	 * 	x being the square feet and y being the price. From there you can create another array
	 * 	if you want to make it easier to work with.
	 */
	public static void learn() {
		//FIXME: Write this method
		double[] data = StdIn.readDoubles();
		int length = data.length;
		x = new double[length/2];
		y = new double[length/2];
		int xCount = 0;
		int yCount = 0;
		for (int i=0; i<length; i++) {
			if (i % 2 == 0) {
				x[xCount++] = data[i]; 
			}
			else {
				y[yCount++] = data[i];
			}
		}
		double xMean = mean(x);
		double yMean = mean(y);
		double xyMean = xyMean(x, y);
		double xSquareMean = squareMean(x);
		slope = (xyMean - xMean * yMean) / (xSquareMean - Math.pow(xMean, 2));
		intercept = yMean - slope * xMean;
	}
	
	public static double mean(double[] nums) {
		double sum = 0;
		for (int i=0; i<nums.length; i++) {
			sum += nums[i];
		}
		return sum / nums.length;
	}
	
	public static double xyMean(double[] x, double[] y) {
		double sum = 0;
		for (int i=0; i<x.length; i++) {
			sum += x[i] * y[i];
		}
		return sum / x.length;
	}
	
	public static double squareMean(double[] nums) {
		double sum = 0;
		for (int i=0; i<nums.length; i++) {
			sum += nums[i] * nums[i];
		}
		return sum / nums.length;
	}
	/**
	 * You'll need to implement this as well. This method should return the predicted value
	 * 	of a home of a given square footage. Think about how the squareFeet variable relates
	 * 	to the equation of the line you found to make this prediction.
	 * 	The code should be very simple.
	 * @param squareFeet the square footage of the house you want to predict the price of
	 * @return the estimated price of the house
	 */
	public static double predictPrice(double squareFeet) {
		return slope * squareFeet + intercept;
	}
}
