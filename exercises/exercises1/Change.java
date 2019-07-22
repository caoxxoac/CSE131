package exercises1;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int money = ap.nextInt("Please Enter a numbne of pennies: ");
		
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
		int dollars = money / 100;     // the number of dollars we can exchange
		int pennies = money % 100;     // the number of pennies left after exchanging for dollars
		int quarters = pennies / 25;   // the number of quarters we can exchange by using remained pennies
		pennies = pennies % 25;        // the number of pennies left after exchanging for quarters 
		int dimes = pennies / 10;      // the number of dimes we can exchange by using remained pennies
		pennies = pennies % 10;        // the number of pennies left after exchanging for dimes
		int nickels = pennies / 5;     // the number of nickels we can exchange by using remained pennies
		pennies = pennies % 5;         // the number of pennies left after exchanging for nickels (the pennies we can exchange no more)
		
		// print out the dollars, quarter, dimes, nickels, and pennies should be given
		// in exchange for those pennies
		System.out.println(dollars+" dollars, "+quarters+" quarters, "+dimes+" dimes, "+nickels+
				" nickelss, "+pennies+" pennies should be given in exchange for "+money+" pennies");
	}

}
