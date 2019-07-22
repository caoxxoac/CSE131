package neighbors;

import java.util.Arrays;

public class KNearestNeighbors {
	
	/**
	 * This is the method you need to complete. It takes in a 2 dimensional array
	 * 	containing the data from real homes in Broward County, Florida you may have
	 * 	seen in extension 3.8.
	 * This array is formatted as follows:
	 * 				   {{price_0, x_0, y_0}
	 * 					{price_1, x_1, y_1}
	 * 						    ...
	 * 					{price_n, x_n, y_n}}
	 * price is the selling price of the house, x is its longitude and y is its latitude.
	 * Therefore, you would call house 0's latitude by writing homes[0][2].
	 * It also takes in the longitude and latitude coordinates of a hypothetical
	 *  house whose price you wish to predict.
	 * The final parameter is the amount of houses you wish to use to predict the price
	 *  of the hypothetical home.
	 * You will make this prediction by finding the k-nearest neighbors to the
	 * hypothetical home and averaging their prices.
	 *  
	 * @param homes the array containing the selling price and coordinates of
	 *  3389 homes in the format {price, x, y}
	 * @param x the longitude of the hypothetical house we are looking at
	 * @param y the latitude of the hypothetical house
	 * @param k the amount of houses with which to compare the price
	 * @return
	 */
	public static double predictPrice(double[][] homes, double x, double y, int k) {
		int dataNum = homes.length;
		double[][] kNearest = new double[dataNum][4];
		for (int i=0; i<dataNum; i++) {
			kNearest[i][0] = homes[i][1];
			kNearest[i][1] = homes[i][2];
			kNearest[i][2] = distance(x, y, homes[i][1], homes[i][2]);
			kNearest[i][3] = homes[i][0];
		}
		kNearest = bubbleSort(kNearest);
		double sum = 0;
		for (int i=0; i<k; i++) {
			sum += kNearest[i][3];
		}
		return sum / k;
	}
	
	public static double[][] bubbleSort(double[][] kNearest) {
		for (int i=0; i<kNearest.length; i++) {
			for (int j=i+1; j<kNearest.length; j++) {
				if (kNearest[j][2] < kNearest[i][2]) {
					double[] temp = new double[4];
					temp[0] = kNearest[i][0];
					temp[1] = kNearest[i][1];
					temp[2] = kNearest[i][2];
					temp[3] = kNearest[i][3];
					kNearest[i][0] = kNearest[j][0];
					kNearest[i][1] = kNearest[j][1];
					kNearest[i][2] = kNearest[j][2];
					kNearest[i][3] = kNearest[j][3];
					kNearest[j][0] = temp[0];
					kNearest[j][1] = temp[1];
					kNearest[j][2] = temp[2];
					kNearest[j][3] = temp[3];
				}
			}
		}
		return kNearest;
	}
	
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
}
