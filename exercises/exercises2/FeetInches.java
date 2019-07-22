package exercises2;
import cse131.ArgsProcessor;

public class FeetInches {

	public static void main(String[] args) {
		//
		// Prompt the user for a number of inches
		//
		// Convert that into feet and inches
		//   BUT
		// Be sure to use the singular "foot" or "inch"
		//   where appropriate, as discussed in
		//   the introductory video
		//
		// For example, 61 inches would produce
		//    the output
		//   5 feet and 1 inch
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int userInches = ap.nextInt("Enter a number of inches: ");
		
		int feet = userInches / 12;
		int inches = userInches % 12;
		String feetFoot = " feet and ";
		String inchInches = " inches";
		if (feet == 1) {
			feetFoot = " foot and ";
		}
		if (inches == 1) {
			inchInches = " inch";
		}
		
		System.out.println(userInches+" inches will produce: "+feet+feetFoot+inches+inchInches);

	}

}
