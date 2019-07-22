package exercises2;
import cse131.ArgsProcessor;

public class Max {

	public static void main(String[] args) {
		//
		// Below, prompt the user for two ints, x and y
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int integerX = ap.nextInt("Enter the first integer: ");
		int integerY = ap.nextInt("Enter the second integer: ");
		int max = 0;
		//
		// Now use what you have learned about conditional
		//   execution to print the larger of the two values.
		//
		if (integerX >= integerY) {
			max = integerX;
		}
		else {
			max = integerY;
		}
		
		System.out.println("Max value of "+integerX+" and "+integerY+" is "+max);
		
		
		//
		// Run this program testing on various inputs for
		//    x and y:  some where x < y, some where x > y,
		//              some where x == y

	}

}
