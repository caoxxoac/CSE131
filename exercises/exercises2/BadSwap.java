package exercises2;

import cse131.ArgsProcessor;

public class BadSwap {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int x = ap.nextInt("Enter x");
		int y = ap.nextInt("Enter y");
		
		if (x > y) {
			x = y;     // Bad
			y = x;     // swap!!
		}
		
		System.out.println("x and y are now"
				+ x + " and " + y);
		
		//
		// Student fill in with comments below this line:
		//   Why does the code above *not* swap the values of
		//      x and y?
		//   Note that the bad swap executes only if x>y
		//
		// Your answer:
		// in the if statement, the program assigns the value of y to x, then 
		// x will contains the value of y.
		// Then, the program assign the value of x (which is the value of y) to y,
		// so it will never be able to assign the value of x to y.
		// The solution should be using a temporary variable to store the value of
		// x first, then assign the value of y to x, and assign the value of the temporary variable to y

	}

}
