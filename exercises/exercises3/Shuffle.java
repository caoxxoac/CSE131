package exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		System.out.println();
		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		String[] shuffle = new String[original.length];
		for (int i=shuffle.length-1; i >= 0; i--) {
			int c = (int) (Math.random() * (i + 1));
			shuffle[i] = original[c];
			
			String temp = original[i];
			original[i] = original[c];
			original[c] = temp;
		}
		
		// print out the result
		for (int i=0; i < shuffle.length; i++) {
			System.out.println("Shuffled at "+i+" is "+shuffle[i]);
		}
		
		
		

	}
	
}