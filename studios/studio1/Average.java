package studio1;
import cse131.ArgsProcessor;

public class Average {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n1 = ap.nextInt("Enter the first integer: ");
		int n2 = ap.nextInt("Enter the second integer: ");
		
		// I was trying to use the sum of two integers divided by 2
		// but it was not working when the sum of two integers was an odd number
		// then I change the divisor to 2.0, it works.
		double average = (n1 + n2) / 2.0;
		System.out.println("The average value of "+n1+" and "+n2+
				" is "+average);
	}

}
