package studio5;

public class Methods {
	
	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}
	
	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		return x * y;
	}

	/**
	 * 
	 * @param integer a
	 * @param integer b
	 * @param integer c
	 * @return the average value of a, b and c
	 */
	public static double avg3(int a, int b, int c) {
		return (double) (a + b + c) / 3;
	}
	
	/**
	 * 
	 * @param an array with doubles
	 * @return sum of all doubles in the array
	 */
	public static double sumArray(double[] array) {
		double sum = 0;
		for (double i : array) {
			sum += i;
		}
		return sum;
	}
	
	/**
	 * 
	 * @param an array with doubles
	 * @return average of all doubles in the array
	 */
	public static double average(double[] array) {
		double avg = 0;
		for (double i : array) {
			avg += (double) i / array.length;
		}
		return avg;
	}
	
	/**
	 * 
	 * @param a string str
	 * @return a string with pig rule
	 */
	public static String pig(String str) {
		int i = 0;
		while (!str.substring(i, i+1).equals("a") &&
				!str.substring(i, i+1).equals("e") &&
				!str.substring(i, i+1).equals("i") &&
				!str.substring(i, i+1).equals("o") &&
				!str.substring(i, i+1).equals("u") && i < str.length()) {
			i ++;
		}
		if (i == 0) {
			return str+"ay";
		}
		else {
			return str.substring(i) + str.substring(0, i) + "ay";
		}
	}
	
	/**
	 * 
	 * @param a string str1
	 * @param a string str2
	 * @return a boolean value that determines whether str1 and str2 are the same,
	 * and they have the length that is greater than 10
	 */
	public static boolean lie(String str1, String str2) {
		if ((str1 == str2) && str1.length() > 10) {
			return true;
		}
		return false;
	}
}