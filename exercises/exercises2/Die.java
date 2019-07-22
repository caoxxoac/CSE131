package exercises2;

public class Die {

	public static void main(String[] args) {

		//
		// Use the random number generator
		//    (Math.random())
		// so that this program prints out one of
		// the following integers:
		//   1 2 3 4 5 6
		// with equal probability
		//
		// Note this program does not prompt the user
		//  for input, it just produces one of the
		//  above integers as output, as if by 
		//  throw of a die
		//
		double random = Math.random();
		if (random < ((double)1/6)) {
			System.out.println(1);
		}
		else if (random < ((double)1/3) && random >= ((double)1/6)) {
			System.out.println(2);
		}
		else if (random < 0.5 && random >= ((double)1/3)) {
			System.out.println(3);
		}
		else if (random < ((double)2/3) && random >= 0.5) {
			System.out.println(4);
		}
		else if (random < ((double)5/6) && random >= ((double)2/3)) {
			System.out.println(5);
		}
		else {
			System.out.println(6);
		}
	}

}
