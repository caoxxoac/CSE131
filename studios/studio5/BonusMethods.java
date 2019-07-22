package studio5;

public class BonusMethods {
	/**
	 * 
	 * @param integer n
	 * @return sum of n's, and decrease by 2 each time
	 */
	public static int sumDownBy2(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n;
			n -= 2;
		}
		return sum;
	}
	
	/**
	 * 
	 * @param integer n
	 * @return sum of 1 over a number that is from 1 to k
	 */
	public static double harmonicSum(int n) {
		double sum = 0;
		for (int i=1; i<n+1; i++) {
			sum += (double) 1 / i;
		}
		return sum;
	}
	
	/**
	 * 
	 * @param integer k
	 * @return sum of 1 over a number that is from 2 to the 0, to 2 to the k
	 */
	public static double geometricSum(int k) {
		double sum = 0;
		for (int i=0; i<k+1; i++) {
			sum += (double) 1 / Math.pow(2, i);
		}
		return sum;
	}
	
	/**
	 * 
	 * @param positive integer j
	 * @param positive integer k
	 * @return multiplication of j and k
	 */
	public static int multPos(int j, int k) {
		return j * k;
	}
	
	/**
	 * 
	 * @param integer j
	 * @param integer k
	 * @return multiplication of j and k
	 */
	public static int mult(int j, int k) {
		return j * k;
	}
	
	/**
	 * 
	 * @param integer n
	 * @param integer k
	 * @return n to the k
	 */
	public static int expt(int n, int k) {
		int total = 1;
		for (int i=0; i<k; i++) {
			total *= n;
		}
		return total;
	}
}
